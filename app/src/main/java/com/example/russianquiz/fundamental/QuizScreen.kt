package com.example.russianquiz.fundamental

import android.util.Log
import androidx.compose.animation.core.EaseInCirc
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
import com.example.russianquiz.R
import com.example.russianquiz.model.Century
import com.example.russianquiz.model.MainViewModel
import com.example.russianquiz.model.QuizData
import com.example.russianquiz.model.StartQuiz
import com.example.russianquiz.ui.theme.RussianQuizTheme
import com.example.russianquiz.utils.toTwoDigitNumber

@Composable
fun QuizScreen(
    modifier: Modifier = Modifier,
    mainViewModel: MainViewModel,
) {
    val quizData by mainViewModel.quizData.collectAsState()
    val currentQuiz = quizData.quizzes!![quizData.solvedQuestions]
    val answersOptions by mainViewModel.answersOptions.collectAsState()

    LazyColumn(modifier = modifier) {
        item {
            QuizCard(quizData = quizData)
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
                score = currentQuiz.score,
                isCompleted = quizData.isCompleted,
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Composable
fun AnswerOption(
    modifier: Modifier = Modifier,
    mainViewModel: MainViewModel,
    chosenAnswer: Int? = null,
    answerOption: Int,
    rightAnswer: Int,
    score: Int,
    isCompleted: Boolean,
) {
    ElevatedCard(
        onClick = {
            mainViewModel.onChoosingOption(
                isRight = rightAnswer == answerOption,
                score = score,
                chosenOption = answerOption,
            )
        },
        enabled = !isCompleted,
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp)
            .clip(
                shape = RoundedCornerShape(
                    topStartPercent = 5,
                    bottomStartPercent = 5,
                    topEndPercent = 40,
                    bottomEndPercent = 40,
                )
            )
            .border(
                3.dp,
                color = if (isCompleted && ((chosenAnswer == answerOption) || (answerOption == rightAnswer))) {
                    if (answerOption == rightAnswer) {
                        colorResource(id = R.color.purple_200)
                    } else {
                        Color(0xFFFF0000)
                    }
                } else {
                    Color.Gray
                },
                shape = RoundedCornerShape(
                    topStartPercent = 5,
                    bottomStartPercent = 5,
                    topEndPercent = 40,
                    bottomEndPercent = 40,
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
                text = stringResource(id = answerOption),
                fontSize = 17.sp,
                color = Color.Black,
                fontWeight = FontWeight.W500,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .weight(1f)
            )

            Spacer(modifier = Modifier.width(5.dp))

            Image(
                painter = painterResource(
                    if (isCompleted && (answerOption == rightAnswer)) {
                        R.drawable.tick_icon
                    } else if (!isCompleted || (answerOption != chosenAnswer)) {
                        R.drawable.radio_button
                    } else {
                        R.drawable.cross_icon
                    }
                ),
                contentDescription = stringResource(
                    if (isCompleted && ((chosenAnswer == answerOption) || (answerOption == rightAnswer))) {
                        if (chosenAnswer == rightAnswer) {
                            R.string.right_answer
                        } else {
                            R.string.wrong_answer
                        }
                    } else if (!isCompleted) {
                        R.string.possible_option
                    } else {
                        R.string.wrong_option_not_chosen
                    }
                ),
                colorFilter = ColorFilter.tint(
                    color = if (isCompleted && ((chosenAnswer == answerOption) || (answerOption == rightAnswer))) {
                        if (answerOption == rightAnswer) {
                            colorResource(id = R.color.purple_200)
                        } else {
                            Color(0xFFFF0000)
                        }
                    } else {
                        Color.Gray
                    }
                ),
                modifier = Modifier.size(30.dp)
            )
        }
    }
}

@Composable
fun QuizCard(
    modifier: Modifier = Modifier,
    quizData: QuizData,
) {
    val currentQuiz = quizData.quizzes!![quizData.solvedQuestions]

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(WindowInsets.navigationBars.asPaddingValues())
            .padding(top = 40.dp)
    ) {
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(16.dp)
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
                            .size(width = 80.dp, height = 40.dp)
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    ProgressBar(
                        isRight = false,
                        answers = quizData.solvedQuestions - quizData.rightAnswers + if (quizData.isCompleted) 1 else 0,
                        modifier = Modifier
                            .size(width = 80.dp, height = 40.dp)
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
                    text = stringResource(id = currentQuiz.question),
                    fontSize = 19.sp,
                    fontWeight = FontWeight(650),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp),
                )
            }
        }

        Score(
//            brushTop = Brush.linearGradient(
//                colors = listOf(
//                    Color(0xFF87800A),
//                    Color(0xFF9900EE),
//                )
//            ),
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
            score = currentQuiz.score,
            modifier = Modifier
                .size(80.dp)
                .align(alignment = Alignment.TopCenter)
                .offset(0.dp, (-25).dp)
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
    countOfQuestions: Int,
    solvedQuestions: Int,
    modifier: Modifier = Modifier,
) {
    val textColor = colorResource(id = R.color.purple_200)

    val textMeasurer = rememberTextMeasurer()
    val questionText = stringResource(id = R.string.question)
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
        ) { append((solvedQuestions + 1).toTwoDigitNumber()) }

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
        ) { append(countOfQuestions.toTwoDigitNumber()) }
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
//    brushTop: Brush, /*TODO:*/
    score: Int,
    initialValue: Float = 0f,
    targetValue: Float = 360f,
) {
    val deltaXAnim = rememberInfiniteTransition(label = "")
    val sweepAngle by deltaXAnim.animateFloat(
        initialValue = initialValue,
        targetValue = targetValue,
        animationSpec = infiniteRepeatable(
            animation = tween(5000, easing = EaseInCirc),
            repeatMode = RepeatMode.Reverse,
        ), label = ""
    )

    val textMeasurer = rememberTextMeasurer()
    val scoreString = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold,
                color = colorResource(id = R.color.purple_200)
            )
        ) { append(score.toString()) }
    }
    val textLayoutResult: TextLayoutResult =
        textMeasurer.measure(text = scoreString)
    val textSize = textLayoutResult.size
    val backgroundColor = MaterialTheme.colorScheme.surfaceContainer

    Canvas(modifier = modifier) {
        val width = size.width
        val height = size.height

        drawCircle(
            color = backgroundColor
        )

        drawText(
            textMeasurer = textMeasurer,
            text = scoreString,
            topLeft = Offset(
                (width - textSize.width) / 2f,
                (height - textSize.height) / 2f
            ),
        )

        drawArc(
            brush = brushLeft,
            startAngle = initialValue - 180f,
            sweepAngle = sweepAngle,
            useCenter = false,
            style = Stroke(20f),
        )

//        drawArc(
//            brush = brushTop,
//            startAngle = initialValue - 90f,
//            sweepAngle = sweepAngle,
//            useCenter = false,
//            style = Stroke(20f),
////            blendMode = BlendMode.Modulate,
//        )

        drawArc(
            brush = brushRight,
            startAngle = initialValue,
            sweepAngle = sweepAngle,
            useCenter = false,
            style = Stroke(20f),
            blendMode = BlendMode.Difference,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun AnswerOptionPreview() {
    RussianQuizTheme {
        AnswerOption(
            mainViewModel = MainViewModel(),
            chosenAnswer = R.string.answer_twenty_first_century_4,
            answerOption = R.string.answer_twenty_first_century_5,
            rightAnswer = R.string.answer_twenty_first_century_44,
            score = 3,
            isCompleted = true,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ScorePreview() {
    RussianQuizTheme {
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
//            brushTop = Brush.linearGradient(
//                listOf(
//                    Color(0xFF004d00),
//                    Color(0xFF142300),
//                )
//            ),
            score = 5,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun QuizCardPreview() {
    RussianQuizTheme {
        QuizCard(
            quizData = QuizData(
                chosenCentury = Century.NINETEENTH,
                quizzes = StartQuiz.generateListOfQuizzes(century = Century.NINETEENTH),
                currentScore = 0,
                rightAnswers = 3,
                solvedQuestions = 5
            ),
        )
    }
}