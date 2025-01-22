package com.example.russianquiz.fundamental

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.russianquiz.R
import com.example.russianquiz.bars.NavigationScreen
import com.example.russianquiz.model.MainViewModel
import com.example.russianquiz.model.QuizData
import com.example.russianquiz.ui.theme.QuizAppTheme
import com.example.russianquiz.utils.toTwoDigitNumber

@Composable
fun ResultScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    mainViewModel: MainViewModel,
) {
    val quizData by mainViewModel.quizData.collectAsState()

    Box(
        modifier = modifier
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CompletedLevel(
                level = quizData.chosenLevel.ordinal + 1,
                modifier = Modifier
                    .size(250.dp)
            )
            ResultsCard(quizData = quizData)
            Spacer(modifier = Modifier.weight(1f))

            OtherFunctionButtons(
                buttonSize = 68.dp,
                modifier = Modifier.padding(start = 40.dp, end = 40.dp),
                onPlayAgainClick = {
                    val chosenLevel = quizData.chosenLevel
                    mainViewModel.resetResult()
                    mainViewModel.updateCurrentLevel(level = chosenLevel)
                    navController.navigate(NavigationScreen.QuizScreen.route)
                },
                onShareScoreClick = {},
                onHomeClick = {
                    mainViewModel.resetResult()
                    navController.navigate(NavigationScreen.ChooseScreen.route)
                }
            )
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun CompletedLevel(
    modifier: Modifier = Modifier,
    level: Int
) {
    val scaleXAnim = rememberInfiniteTransition(label = "")
    val scaleX by scaleXAnim.animateFloat(
        initialValue = 1f,
        targetValue = 0.7f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = FastOutLinearInEasing),
            repeatMode = RepeatMode.Reverse,
        ), label = ""
    )

    val textMeasurer = rememberTextMeasurer()
    val titleString = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = colorResource(id = R.color.purple_200),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
        ) { append(stringResource(R.string.completed_level)) }
    }

    val textLayoutCompletedLevel: TextLayoutResult =
        textMeasurer.measure(text = titleString)
    val textSizeCompletedLevel = textLayoutCompletedLevel.size

    val levelString = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = colorResource(id = R.color.purple_200),
                fontSize = 50.sp,
                fontWeight = FontWeight.ExtraBold
            )
        ) { append(level.toTwoDigitNumber()) }
    }

    val textLayoutLevel: TextLayoutResult =
        textMeasurer.measure(text = levelString)
    val textSizeLevel = textLayoutLevel.size

    Canvas(modifier = modifier) {
        val width = size.width
        val height = size.height

        drawCircle(
            color = Color(0x15FFFFFF),
            blendMode = BlendMode.Plus,
            radius = (size.minDimension / 2.0f) * scaleX,
        )
        drawCircle(
            color = Color(0xFFE0F0F0),
            blendMode = BlendMode.Src,
            radius = size.width / 2.7f
        )
        drawCircle(
            color = Color(0xFFFFFFFF),
            blendMode = BlendMode.Src,
            radius = size.width / 3.2f
        )
        drawText(
            textMeasurer = textMeasurer,
            text = titleString,
            topLeft = Offset(
                (width - textSizeCompletedLevel.width) / 2f,
                (height * 0.8f - textSizeCompletedLevel.height) / 2f
            )
        )
        drawText(
            textMeasurer = textMeasurer,
            text = levelString,
            topLeft = Offset(
                (width - textSizeLevel.width) / 2f,
                (height * 1.15f - textSizeLevel.height) / 2f
            )
        )
    }
}

@Composable
fun ResultsCard(
    modifier: Modifier = Modifier,
    quizData: QuizData,
) {
    val solvedQuestions =
        if (quizData.chosenOption != 0) quizData.solvedQuestions + 1 else quizData.solvedQuestions
    val percentage = (quizData.rightAnswers / solvedQuestions.toFloat() * 100).toInt()

    Card(
        modifier = modifier
            .padding(20.dp)
            .shadow(elevation = 20.dp)
            .clip(shape = RoundedCornerShape(15)),
        colors = CardDefaults.cardColors().copy(containerColor = Color.White),
    ) {
        Row(modifier = modifier.padding(20.dp)) {
            Column(modifier = Modifier.weight(1f)) {
                ResultElement(
                    value = "$percentage%",
                    component = R.string.completion,
                    color = colorResource(id = R.color.purple_200),
                )
                Spacer(modifier = Modifier.height(15.dp))
                ResultElement(
                    value = quizData.rightAnswers.toTwoDigitNumber(),
                    component = R.string.correct,
                    color = Color(0xFF0FAF33)
                )
            }

            Column {
                ResultElement(
                    value = solvedQuestions.toTwoDigitNumber(),
                    component = R.string.total_question,
                    color = Color(0xFFBF00EE)
                )
                Spacer(modifier = Modifier.height(15.dp))
                ResultElement(
                    value = (solvedQuestions - quizData.rightAnswers).toTwoDigitNumber(),
                    component = R.string.wrong,
                    color = Color(0xFFFF4000)
                )
            }
        }
    }
}

@Composable
fun ResultElement(
    modifier: Modifier = Modifier,
    value: String,
    @StringRes component: Int,
    color: Color,
) {
    Box(modifier = modifier) {
        Row {
            Canvas(modifier = Modifier.size(12.dp)) {
                drawCircle(
                    color = color
                )
            }

            Spacer(modifier = Modifier.width(10.dp))

            Column {
                Text(
                    text = value,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = color
                )
                Text(
                    text = stringResource(id = component),
                    fontWeight = FontWeight.W300,
                )
            }
        }
    }
}

@Composable
fun FunctionButton(
    modifier: Modifier = Modifier,
    @DrawableRes iconResId: Int,
    @StringRes iconContentDescription: Int,
    @StringRes actionTitle: Int,
    containerColor: Color,
    onClickAction: () -> Unit,
    buttonSize: Dp = 50.dp,
    scaleIcon: Float,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconButton(
            onClick = onClickAction,
            colors = IconButtonDefaults.iconButtonColors(
                containerColor = containerColor
            ),
            modifier = Modifier.size(buttonSize)
        ) {
            Icon(
                painter = painterResource(id = iconResId),
                contentDescription = stringResource(iconContentDescription),
                tint = Color.White,
                modifier = Modifier.size(buttonSize * scaleIcon)
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = stringResource(id = actionTitle),
            fontWeight = FontWeight.W500,
            fontSize = 15.sp,
            color = Color.White,
        )
    }
}

@Composable
fun OtherFunctionButtons(
    modifier: Modifier = Modifier,
    onPlayAgainClick: () -> Unit,
    onShareScoreClick: () -> Unit,
    onHomeClick: () -> Unit,
    buttonSize: Dp = 50.dp
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            FunctionButton(
                iconResId = R.drawable.play_again,
                iconContentDescription = R.string.play_again,
                actionTitle = R.string.play_again,
                containerColor = Color(0xFF006400),
                onClickAction = onPlayAgainClick,
                buttonSize = buttonSize,
                scaleIcon = 0.8f
            )

            Spacer(modifier = Modifier.weight(1f))

            FunctionButton(
                iconResId = R.drawable.share,
                iconContentDescription = R.string.share,
                actionTitle = R.string.share,
                containerColor = Color(0xFF520099),
                onClickAction = onShareScoreClick,
                buttonSize = buttonSize,
                scaleIcon = 0.8f
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        FunctionButton(
            iconResId = R.drawable.home,
            iconContentDescription = R.string.home,
            actionTitle = R.string.home,
            containerColor = Color(0xFFff6161),
            onClickAction = onHomeClick,
            buttonSize = buttonSize,
            scaleIcon = 0.7f
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun OtherFunctionButtonsPreview() {
    QuizAppTheme {
        OtherFunctionButtons(
            modifier = Modifier.fillMaxWidth(),
            {},
            {},
            {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ResultElementPreview() {
    QuizAppTheme {
        ResultElement(
            value = "100%",
            component = R.string.completion,
            color = colorResource(id = R.color.purple_200)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CompletedLevelPreview() {
    QuizAppTheme {
        CompletedLevel(
            level = 8,
            modifier = Modifier.size(200.dp)
        )
    }
}