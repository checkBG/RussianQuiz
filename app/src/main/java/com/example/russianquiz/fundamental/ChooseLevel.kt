package com.example.russianquiz.fundamental

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.russianquiz.R
import com.example.russianquiz.model.Level
import com.example.russianquiz.model.MainViewModel
import com.example.russianquiz.model.UserAction
import com.example.russianquiz.model.localizedString
import com.example.russianquiz.utils.toTwoDigitNumber

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ChooseLevel(
    levels: List<Level>,
    widthSize: WindowWidthSizeClass,
    navController: NavHostController,
    mainViewModel: MainViewModel,
    modifier: Modifier = Modifier,
) {
    val countOfColumns = when (widthSize) {
        WindowWidthSizeClass.Compact -> 2
        WindowWidthSizeClass.Medium -> 3
        WindowWidthSizeClass.Expanded -> 4
        else -> 2
    }

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        FlowRow(
            maxItemsInEachRow = countOfColumns,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = modifier
                .fillMaxSize(),
        ) {
            levels.forEachIndexed { index, level ->
                Pentagon(
                    pentagonSize = 120.dp,
                    level = level,
                    colors = level.colors,
                    navController = navController,
                    mainViewModel = mainViewModel,
                    index = index + 1,
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Composable
fun Pentagon(
    modifier: Modifier = Modifier,
    pentagonSize: Dp,
    level: Level,
    index: Int,
    colors: List<Color>,
    navController: NavHostController,
    mainViewModel: MainViewModel,
) {
    var isScale by remember { mutableStateOf(false) }
    val scale by animateFloatAsState(targetValue = if (isScale) 0.94f else 1f, label = "")

    val interactionSource = remember { MutableInteractionSource() }
    val density = LocalDensity.current

    val width = with(density) { pentagonSize.toPx() }
    val height = with(density) { pentagonSize.toPx() }

    val topicScreen = localizedString(id = R.string.level)

    val textMeasurer = rememberTextMeasurer()
    val titular = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontSize = 25.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
            )
        ) { append(topicScreen) }
    }

    val levelString = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontSize = 40.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
            )
        ) { append(index.toTwoDigitNumber()) }
    }

    val textLayoutResultTitular: TextLayoutResult =
        textMeasurer.measure(text = titular)
    val textSizeTitular = textLayoutResultTitular.size

    val textLayoutResultLevel: TextLayoutResult =
        textMeasurer.measure(text = levelString)
    val textSizeLevel = textLayoutResultLevel.size

    val path = pentagonPath(width = width, height = height)

    Box(
        modifier = modifier
            .size(width = pentagonSize, height = pentagonSize * 1.2f),
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier
                .size(width = pentagonSize, height = pentagonSize * 1.2f)
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
                ) {
                    mainViewModel.onUserAction(
                        action = UserAction.SelectLevel(
                            level = level,
                            navController = navController
                        )
                    )
                }
        ) {
            drawPath(
                path = path,
                brush = Brush.linearGradient(colors),
            )

            clipPath(path) {
                translate(
                    -(pentagonSize / 20f).toPx(),
                    (pentagonSize / 1.8f).toPx()
                ) {
                    drawPath(
                        path = pentagonPath(
                            width = width / 2f,
                            height / 2f
                        ),
                        color = Color(0x22FFFFFF),
                    )

                }

                translate(
                    (pentagonSize / 1.55f).toPx(),
                    (pentagonSize / 1.12f).toPx()
                ) {
                    drawPath(
                        path = pentagonPath(width = width / 5f, height / 5f),
                        color = Color(0x22FFFFFF),
                    )
                }

                drawCircle(
                    color = Color(0x22FFFFFF),
                    radius = width / 4f,
                    style = Stroke(10f),
                    center = Offset(width * 0.85f, height * 0.4f),
                )

                drawCircle(
                    color = Color(0x22FFFFFF),
                    radius = width / 10f,
                    center = Offset(width * 0.23f, height * 0.46f),
                )

                drawCircle(
                    color = Color(0x22FFFFFF),
                    radius = width / 20f,
                    center = Offset(width * 0.8f, height * 0.85f),
                )
            }

            drawText(
                textMeasurer = textMeasurer,
                text = titular,
                blendMode = BlendMode.Lighten,
                topLeft = Offset(
                    (width - textSizeTitular.width) / 2f,
                    (height * 1.3f - textSizeTitular.height) / 2f
                ),
            )

            drawText(
                textMeasurer = textMeasurer,
                text = levelString,
                blendMode = BlendMode.Lighten,
                topLeft = Offset(
                    (width - textSizeLevel.width) / 2f,
                    (height * 1.85f - textSizeLevel.height) / 2f
                )
            )
        }
    }
}

fun pentagonPath(
    width: Float,
    height: Float,
): Path {
    return Path().apply {
        moveTo(width * 0.6f, height * 0.37f) // 1
        lineTo(width * 0.84f, height * 0.55f) // 2
        quadraticTo(width * 0.96f, height * 0.65f, width * 0.94f, height * 0.79f) // 3
        lineTo(width * 0.9f, height) // 4
        quadraticTo(width * 0.85f, height * 1.2f, width * 0.65f, height * 1.2f) // 5
        lineTo(width * 0.5f, height * 1.2f) // 6

        moveTo(width * 0.6f, height * 0.37f)
        quadraticTo(width * 0.5f, height * 0.272f, width * 0.4f, height * 0.37f) // 1
        lineTo(width * 0.16f, height * 0.55f) // 2
        quadraticTo(width * 0.04f, height * 0.65f, width * 0.06f, height * 0.79f) // 3
        lineTo(width * 0.1f, height) // 4
        quadraticTo(width * 0.15f, height * 1.2f, width * 0.34f, height * 1.2f) // 5
        lineTo(width * 0.5f, height * 1.2f) // 6
        close()
    }
}

//@Preview(showBackground = true)
//@Composable
//fun PentagonPreview() {
//    QuizAppTheme(darkTheme = true) {
//        Pentagon(
//            pentagonSize = 100.dp,
//            colors = listOf(
//                Color(0xFF8B4513),
//                Color(0xFFFF4D00),
//                Color(0xFFF8F32B),
//            ),
//            mainViewModel = MainViewModel(dao = ),
//            navController = rememberNavController(),
////            widthSize = WindowWidthSizeClass.Compact,
//            level = Levels.FIFTH_LEVEL,
//            index = 5
//        )
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun LevelsCompactPreview() {
//    QuizAppTheme {
//        ChooseLevel(
//            levels = Levels.entries,
//            widthSize = WindowWidthSizeClass.Compact,
//            navController = rememberNavController(),
//            mainViewModel = MainViewModel(),
//        )
//    }
//}
//
//@Preview(showBackground = true, widthDp = 700)
//@Composable
//fun LevelsMediumPreview() {
//    QuizAppTheme {
//        ChooseLevel(
//            levels = Levels.entries,
//            widthSize = WindowWidthSizeClass.Medium,
//            navController = rememberNavController(),
//            mainViewModel = MainViewModel(),
//        )
//    }
//}
//
//@Preview(showBackground = true, widthDp = 1000)
//@Composable
//fun LevelsExpandedPreview() {
//    QuizAppTheme {
//        ChooseLevel(
//            levels = Levels.entries,
//            widthSize = WindowWidthSizeClass.Expanded,
//            navController = rememberNavController(),
//            mainViewModel = MainViewModel(),
//        )
//    }
//}