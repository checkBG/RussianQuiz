package com.example.russianquiz.fundamental

import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.EaseInCirc
import androidx.compose.animation.core.EaseInOutBounce
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import com.example.russianquiz.R
import com.example.russianquiz.model.Levels
import com.example.russianquiz.model.MainViewModel
import com.example.russianquiz.model.QuizData
import com.example.russianquiz.model.Quizzes
import com.example.russianquiz.model.localizedString
import com.example.russianquiz.ui.theme.QuizAppTheme
import com.example.russianquiz.utils.createVibration
import com.example.russianquiz.utils.toTwoDigitNumber

@Composable
fun QuizScreen(
    modifier: Modifier = Modifier,
    mainViewModel: MainViewModel,
    widthSize: WindowWidthSizeClass,
) {
    val quizData by mainViewModel.quizData.collectAsState()
    val currentQuiz = quizData.quizzes[quizData.solvedQuestions]

    val context = LocalContext.current

    val ids =
        context.resources.obtainTypedArray(
            quizData.quizzes[quizData.solvedQuestions].options
        )
    val answersOptions = mutableListOf<Int>()
    for (i in 0 until ids.length()) {
        answersOptions.add(ids.getResourceId(i, 0))
    }
    ids.recycle()

    val quizCardWidthScale = when (widthSize) {
        WindowWidthSizeClass.Compact -> 1f
        WindowWidthSizeClass.Medium -> 0.8f
        WindowWidthSizeClass.Expanded -> 0.6f
        else -> 1f
    }

    Box(modifier = modifier) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            contentPadding = PaddingValues(bottom = if (quizData.isCompleted) 80.dp else 20.dp)
        ) {
            item {
                QuizCard(
                    quizData = quizData,
                    modifier = Modifier.fillMaxWidth(quizCardWidthScale)
                )
            }

            item {
                Spacer(modifier = Modifier)
            }

            items(items = answersOptions) { answerOption ->
                AnswerOption(
                    mainViewModel = mainViewModel,
                    answerOption = answerOption,
                    chosenAnswer = quizData.chosenOption,
                    rightAnswer = currentQuiz.rightAnswer,
                    isCompleted = quizData.isCompleted,
                    modifier = Modifier.fillMaxWidth(quizCardWidthScale)
                )
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}

@Composable
fun AnswerOption(
    modifier: Modifier = Modifier,
    mainViewModel: MainViewModel,
    chosenAnswer: Int? = null,
    answerOption: Int,
    rightAnswer: Int?,
    isCompleted: Boolean,
) {
    val isTick = isCompleted && (answerOption == rightAnswer)
    val isRadio = !isCompleted || (answerOption != chosenAnswer)
    val context = LocalContext.current

    ElevatedCard(
        onClick = {
            {
                mainViewModel.onChoosingOption(
                    isRight = rightAnswer == answerOption,
                    chosenOption = answerOption,
                )
            }.createVibration(context = context)
        },
        enabled = !isCompleted,
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp)
            .clip(
                shape = RoundedCornerShape(
                    topStartPercent = 100,
                    bottomStartPercent = 100,
                    topEndPercent = 100,
                    bottomEndPercent = 100,
                )
            )
            .border(
                3.dp,
                color = if (isTick) {
                    colorResource(id = R.color.purple_200)
                } else if (isRadio) {
                    Color.Gray
                } else {
                    Color.Red
                },
                shape = RoundedCornerShape(
                    topStartPercent = 100,
                    bottomStartPercent = 100,
                    topEndPercent = 100,
                    bottomEndPercent = 100,
                )
            ),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = localizedString(id = answerOption),
                fontSize = 17.sp,
                color = Color.Black,
                fontWeight = FontWeight.W500,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .weight(1f)
            )

            Spacer(modifier = Modifier.width(5.dp))

            if (isTick) {
                Tick(
                    color = colorResource(id = R.color.purple_200),
                    modifier = Modifier.size(30.dp)
                )
            } else if (isRadio) {
                Radio(
                    color = Color.Gray,
                    modifier = Modifier.size(30.dp)
                )
            } else {
                Cross(
                    color = Color.Red,
                    modifier = Modifier.size(30.dp)
                )
            }
        }
    }
}

@Composable
fun QuizCard(
    modifier: Modifier = Modifier,
    quizData: QuizData,
) {
    val currentQuiz = quizData.quizzes[quizData.solvedQuestions]

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(WindowInsets.navigationBars.asPaddingValues())
            .padding(top = 40.dp)
    ) {
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.padding(5.dp)
                ) {
                    ProgressBar(
                        isRight = true,
                        answers = quizData.rightAnswers,
                        modifier = Modifier
                            .size(width = 60.dp, height = 40.dp)
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    ProgressBar(
                        isRight = false,
                        answers = quizData.solvedQuestions - quizData.rightAnswers + if (quizData.isCompleted) 1 else 0,
                        modifier = Modifier
                            .size(width = 60.dp, height = 40.dp)
                    )
                }

                CountOfQuestions(
                    countOfQuestions = quizData.quizzes.size,
                    solvedQuestions = quizData.solvedQuestions,
                    modifier = Modifier
                        .size(width = 200.dp, height = 50.dp)
                )

                Spacer(modifier = Modifier.height(15.dp))

                Text(
                    text = localizedString(id = currentQuiz.question),
                    fontSize = 19.sp,
                    fontWeight = FontWeight(650),
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp),
                )
                Spacer(modifier = Modifier.height(35.dp))
            }
        }

        Score(
            brushLeft = Brush.linearGradient(
                colors = listOf(
                    Color(0xFF87CEFA),
                    Color(0xFFB0E0E6),
                )
            ),
            brushRight = Brush.linearGradient(
                colors = listOf(
                    Color(0xFF099d00),
                    Color(0xFF149300),
                )
            ),
            isCompleted = quizData.isCompleted,
            explanationResId = currentQuiz.explanation,
            modifier = Modifier
                .align(alignment = Alignment.TopCenter)
                .offset(0.dp, (-20).dp)
        )
    }
}

@Composable
fun ProgressBar(
    isRight: Boolean,
    answers: Int,
    modifier: Modifier = Modifier,
) {
    val textMeasurer = rememberTextMeasurer()
    val color = if (isRight) Color(0xFF30B000) else Color(0xFFFF0000)
    val answersString = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = color,
            )
        ) { append(answers.toTwoDigitNumber()) }
    }
    val textLayoutResult: TextLayoutResult =
        textMeasurer.measure(text = answersString)
    val textSize = textLayoutResult.size

    Row {
        Canvas(
            modifier = Modifier
                .size(
                    with(LocalDensity.current) { textSize.width.toDp() },
                    with(LocalDensity.current) { textSize.height.toDp() }
                )
        ) {
            drawText(
                textMeasurer = textMeasurer,
                text = answersString,
            )
        }

        Spacer(modifier = Modifier.width(4.dp))

        Canvas(modifier = modifier) {
            drawRoundRect(
                color = color,
                size = Size(size.width, size.height / 2),
                cornerRadius = CornerRadius(40f, 40f),
                topLeft = Offset(0f, size.height - textSize.height)
            )
        }
    }
}

@Composable
fun CountOfQuestions(
    countOfQuestions: Int?,
    solvedQuestions: Int?,
    modifier: Modifier = Modifier,
) {
    val textColor = colorResource(id = R.color.purple_200)

    val textMeasurer = rememberTextMeasurer()
    val questionText = localizedString(id = R.string.question)
    val countOfQuestionText = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontSize = 50.sp,
                fontWeight = FontWeight.ExtraBold,
                fontStyle = FontStyle.Italic,
                color = textColor
            )
        ) { append(questionText.first()) }

        withStyle(
            style = SpanStyle(
                fontSize = 25.sp,
                fontWeight = FontWeight(550),
                fontStyle = FontStyle.Italic,
                color = textColor,
            )
        ) { append(questionText.drop(1)) }
        withStyle(
            style = SpanStyle(
                fontSize = 20.sp,
            )
        ) { append(" ") }
        withStyle(
            style = SpanStyle(
                fontSize = 35.sp,
                fontWeight = FontWeight.ExtraBold,
                fontStyle = FontStyle.Italic,
                color = textColor,
            )
        ) { append(((solvedQuestions ?: 0) + 1).toTwoDigitNumber()) }

        withStyle(
            style = SpanStyle(
                fontSize = 10.sp,
                fontStyle = FontStyle.Italic,
            )
        ) { append(" ") }

        withStyle(
            style = SpanStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight(550),
                fontStyle = FontStyle.Italic,
                color = textColor,
            )
        ) { append("/") }

        withStyle(
            style = SpanStyle(
                fontSize = 10.sp,
                fontStyle = FontStyle.Italic,
            )
        ) { append(" ") }

        withStyle(
            style = SpanStyle(
                fontSize = 25.sp,
                fontWeight = FontWeight(550),
                fontStyle = FontStyle.Italic,
                color = textColor,
            )
        ) { append(countOfQuestions?.toTwoDigitNumber() ?: "0") }
    }

    val textLayoutResultCountOfQuestions: TextLayoutResult =
        textMeasurer.measure(text = countOfQuestionText)
    val textSizeCountOfQuestions = textLayoutResultCountOfQuestions.size


    Canvas(modifier = modifier) {
        val width = size.width
        val height = size.height

        drawText(
            textMeasurer = textMeasurer,
            text = countOfQuestionText,
            topLeft = Offset(
                (width - textSizeCountOfQuestions.width) / 2f,
                (height - textSizeCountOfQuestions.height) / 2f
            ),
        )
    }
}

@Composable
fun Score(
    modifier: Modifier = Modifier,
    brushRight: Brush,
    brushLeft: Brush,
    isCompleted: Boolean,
    @StringRes explanationResId: Int,
    initialValue: Float = 0f,
    targetValue: Float = 360f,
) {
    var isScale by remember { mutableStateOf(false) }
    val scale by animateFloatAsState(
        targetValue = if (isScale && isCompleted) 0.94f else 1f,
        label = ""
    )
    val interactionSource = remember { MutableInteractionSource() }

    var openDialog by remember { mutableStateOf(false) }

    val lightBulbColor by animateColorAsState(
        targetValue = if (isCompleted) Color(0xFFffc261) else Color.Black,
        animationSpec = tween(durationMillis = 250, easing = EaseInOutBounce),
        label = "",
    )

    val deltaXAnim = rememberInfiniteTransition(label = "")
    val sweepAngle by deltaXAnim.animateFloat(
        initialValue = initialValue,
        targetValue = targetValue,
        animationSpec = infiniteRepeatable(
            animation = tween(5000, easing = EaseInCirc),
            repeatMode = RepeatMode.Reverse,
        ), label = ""
    )

    val backgroundColor = MaterialTheme.colorScheme.surfaceContainer

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier,
    ) {
        Box(contentAlignment = Alignment.Center) {

            Canvas(modifier = Modifier.size(80.dp)) {
                drawCircle(
                    color = backgroundColor
                )

                drawArc(
                    brush = brushLeft,
                    startAngle = initialValue - 180f,
                    sweepAngle = sweepAngle,
                    useCenter = false,
                    style = Stroke(20f),
                )

                drawArc(
                    brush = brushRight,
                    startAngle = initialValue,
                    sweepAngle = sweepAngle,
                    useCenter = false,
                    style = Stroke(20f),
                    blendMode = BlendMode.Difference,
                )
            }

            Image(
                painter = painterResource(id = R.drawable.light_bulb),
                contentDescription = null,
                colorFilter = ColorFilter.tint(
                    color = lightBulbColor
                ),
                modifier = Modifier
                    .size(35.dp)
                    .rotate(15f)
                    .pointerInput(isScale) {
                        awaitPointerEventScope {
                            isScale = if (isScale) {
                                waitForUpOrCancellation()
                                false
                            } else {
                                awaitFirstDown(requireUnconsumed = false)
                                true
                            }
                        }
                    }
                    .scale(scale = scale)
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null,
                        enabled = isCompleted && !openDialog
                    ) {
                        openDialog = true
                    }
            )
        }

        AnimatedVisibility(
            visible = openDialog,
            exit = ExitTransition.None,
        ) {
            Spacer(modifier = Modifier.height(10.dp))

            PopupWindowDialog(
                onDismissRequest = { openDialog = false },
                explanationResId = explanationResId,
                modifier = Modifier
            )
        }
    }
}

@Composable
fun Cross(
    modifier: Modifier = Modifier,
    color: Color,
) {
    Canvas(modifier = modifier) {
        drawCircle(
            color = color,
        )
        drawLine(
            color = Color.White,
            start = Offset(size.width * 0.25f, size.height * 0.25f),
            end = Offset(size.width * 0.75f, size.height * 0.75f),
            strokeWidth = 10f,
            cap = StrokeCap.Round,
        )
        drawLine(
            color = Color.White,
            start = Offset(size.width * 0.27f, size.height * 0.75f),
            end = Offset(size.width * 0.75f, size.height * 0.25f),
            strokeWidth = 10f,
            cap = StrokeCap.Round,
        )
    }
}

@Composable
fun Tick(
    modifier: Modifier = Modifier,
    color: Color,
) {
    Canvas(modifier = modifier) {
        drawCircle(
            color = color
        )
        drawLine(
            color = Color.White,
            start = Offset(size.width * 0.45f, size.height * 0.7f),
            end = Offset(size.width * 0.8f, size.height * 0.35f),
            strokeWidth = 10f,
            cap = StrokeCap.Round,
        )
        drawLine(
            color = Color.White,
            start = Offset(size.width * 0.45f, size.height * 0.7f),
            end = Offset(size.width * 0.25f, size.height * 0.48f),
            strokeWidth = 10f,
            cap = StrokeCap.Round,
        )
    }
}

@Composable
fun Radio(
    modifier: Modifier = Modifier,
    color: Color,
) {
    Canvas(modifier = modifier) {
        drawCircle(
            color = color,
            style = Stroke(10f)
        )
    }
}

@Composable
fun PopupWindowDialog(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit,
    @StringRes explanationResId: Int,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Popup(
            alignment = Alignment.TopCenter,
            onDismissRequest = onDismissRequest,
            properties = PopupProperties(),
        ) {
            Box(
                modifier = Modifier
                    .padding(15.dp)
                    .clip(shape = RoundedCornerShape(20))
                    .border(
                        width = 3.dp,
                        color = Color(0xFFFFC261),
                        shape = RoundedCornerShape(20)
                    )
                    .background(color = Color(0xE52E8B57))
                    .padding(12.dp)
            ) {
                Text(
                    text = localizedString(id = explanationResId),
                    color = Color(0xFFFFFFFF),
                    textAlign = TextAlign.Justify,
                    modifier = Modifier
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PopupDialogPreview() {
    QuizAppTheme {
        PopupWindowDialog(
            onDismissRequest = { },
            explanationResId = R.string.explanation_tenses_5
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun RadioPreview() {
    QuizAppTheme {
        Radio(
            color = Color.Gray,
            modifier = Modifier.size(100.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TickPreview() {
    QuizAppTheme {
        Tick(
            color = colorResource(id = R.color.purple_200),
            modifier = Modifier.size(100.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CrossPreview() {
    QuizAppTheme {
        Cross(
            color = Color.Red,
            modifier = Modifier.size(100.dp)
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//private fun AnswerOptionNeutralPreview() {
//    val quiz = Quizzes.firstLevelQuizzes[0]
//    QuizAppTheme {
//        AnswerOption(
//            mainViewModel = MainViewModel(),
//            chosenAnswer = R.string.answer_grammar_1_1,
//            answerOption = R.string.answer_grammar_1_2,
//            rightAnswer = quiz.rightAnswer,
//            isCompleted = true,
//        )
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//private fun AnswerOptionWrongPreview() {
//    val quiz = Quizzes.firstLevelQuizzes[0]
//    QuizAppTheme {
//        AnswerOption(
//            mainViewModel = MainViewModel(),
//            chosenAnswer = R.string.answer_grammar_1_1,
//            answerOption = R.string.answer_grammar_1_1,
//            rightAnswer = quiz.rightAnswer,
//            isCompleted = true,
//        )
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//private fun AnswerOptionRightPreview() {
//    val quiz = Quizzes.firstLevelQuizzes[0]
//    QuizAppTheme {
//        AnswerOption(
//            mainViewModel = MainViewModel(),
//            chosenAnswer = R.string.answer_grammar_1_1,
//            answerOption = quiz.rightAnswer,
//            rightAnswer = quiz.rightAnswer,
//            isCompleted = true,
//        )
//    }
//}

@Preview(showBackground = true)
@Composable
private fun ScorePreview() {
    QuizAppTheme {
        Score(
            modifier = Modifier.size(80.dp),
            brushRight = Brush.linearGradient(
                listOf(
                    Color(0xFFFF9900),
                    Color(0xFF00FF99)
                )
            ),
            brushLeft = Brush.linearGradient(
                listOf(
                    Color(0xFF87CEFA),
                    Color(0xFFB0E0E6),
                )
            ),
            isCompleted = false,
            explanationResId = R.string.explanation_tenses_5
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun QuizCardPreview() {
    QuizAppTheme {
        QuizCard(
            quizData = QuizData(
                chosenLevel = Levels.SIXTH_LEVEL,
                quizzes = Quizzes.sixthLevelQuizzes,
                rightAnswers = 1,
                solvedQuestions = 3
            ),
        )
    }
}