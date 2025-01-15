package com.example.russianquiz.fundamental

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.ElevatedButton
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.russianquiz.R
import com.example.russianquiz.bars.NavigationScreen
import com.example.russianquiz.model.Century
import com.example.russianquiz.model.MainViewModel
import com.example.russianquiz.ui.theme.RussianQuizTheme
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun StatisticCentury(
    widthSize: WindowWidthSizeClass,
    mainViewModel: MainViewModel,
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    val quizData by mainViewModel.quizData.collectAsState()

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        CircleStatistic(century = quizData.chosenCentury!!, widthSize = widthSize)

        Spacer(modifier = Modifier.height(30.dp))

        ElevatedButton(
            onClick = { navController.navigate(NavigationScreen.CenturyQuiz.route) },
            modifier = Modifier.size(width = 250.dp, height = 60.dp)
        ) {
            Box {
                Text(
                    text = stringResource(R.string.start),
                    color = Color.Black,
                    fontSize = 25.sp,
                    fontWeight = FontWeight(450),
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(align = Alignment.CenterHorizontally)
                )
                CenturyIconNumber(
                    centuryNumber = quizData.chosenCentury!!.centuryNumber,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(align = Alignment.End)
                )
            }
        }
    }
}

@Composable
fun CircleStatistic(
    widthSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier,
    century: Century,
) {
    var startAnimation by remember { mutableStateOf(false) }
    val animatedCount = animateIntAsState(
        targetValue = if (startAnimation) century.maxScore else 0,
        animationSpec = tween(durationMillis = 100, easing = LinearEasing), label = ""
    )
    val circleColor = Color(0xFFFF5500)
    val configuration = LocalConfiguration.current
    val padding = when (widthSize) {
        WindowWidthSizeClass.Compact -> 30.dp
        WindowWidthSizeClass.Medium -> 35.dp
        WindowWidthSizeClass.Expanded -> 40.dp
        else -> 30.dp
    }
    val screenWidth = configuration.screenWidthDp
    val progressPercentage by animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        label = "progress percentage",
        animationSpec = TweenSpec(900, easing = FastOutSlowInEasing)
    )
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = stringResource(id = R.string.max_score).replaceFirstChar { it.uppercase() },
                fontSize = 30.sp,
                color = Color.White,
                fontWeight = FontWeight.W300
            )
            Spacer(modifier = Modifier.height(10.dp))
            AnimatedContent(
                targetState = animatedCount.value,
                transitionSpec = {
                    if (targetState > initialState) {
                        slideInVertically { -it } togetherWith slideOutVertically { it }
                    } else {
                        slideInVertically { it } togetherWith slideOutVertically { -it }
                    }
                },
                label = ""
            ) { digit ->
                Text(
                    text = digit.toString(),
                    color = Color.White,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Canvas(
            modifier = Modifier
                .size(screenWidth.dp - padding)
                .padding(15.dp)
        ) {
            drawArc(
                color = Color.Gray,
                size = size,
                startAngle = 35f,
                sweepAngle = -250f,
                useCenter = false,
                style = Stroke(width = 12.5.dp.toPx(), cap = StrokeCap.Round),
//                blendMode = BlendMode.Hue
            )
            drawArc(
                color = circleColor,
                size = size,
                startAngle = -215f,
                sweepAngle = 250f * progressPercentage,
                useCenter = false,
                style = Stroke(width = 12.5.dp.toPx(), cap = StrokeCap.Round),
                blendMode = BlendMode.Hardlight
            )
            val angleInDegrees = (progressPercentage * 250.0) + 55.0
            val radius = (size.height / 2)
            val x =
                -(radius * sin(Math.toRadians(angleInDegrees))).toFloat() + (size.width / 2)
            val y =
                (radius * cos(Math.toRadians(angleInDegrees))).toFloat() + (size.height / 2)

            // icon for split
            drawCircle(
                color = Color.Yellow,
                radius = 5f,
                center = Offset(x, y)
            )
            startAnimation = true
        }
    }
}

@Composable
fun CenturyIconNumber(
    centuryNumber: Int,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.size(30.dp)) {
            drawArc(
                color = Color.Black,
                startAngle = 0f,
                sweepAngle = 360f,
                useCenter = false,
                style = Stroke(width = 5.5f, cap = StrokeCap.Round),
            )
        }
        Text(
            text = centuryNumber.toString(),
            fontSize = 17.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CenturyIconNumberPreview() {
    RussianQuizTheme {
        CenturyIconNumber(centuryNumber = 21)
    }
}

@Preview(showBackground = true)
@Composable
fun StatisticCenturyCompactPreview() {
    RussianQuizTheme {
        StatisticCentury(
            navController = rememberNavController(),
            widthSize = WindowWidthSizeClass.Compact,
            mainViewModel = MainViewModel()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CircleStatisticPreview() {
    RussianQuizTheme {
        CircleStatistic(
            widthSize = WindowWidthSizeClass.Compact,
            century = Century.EIGHTEENTH
        )
    }
}