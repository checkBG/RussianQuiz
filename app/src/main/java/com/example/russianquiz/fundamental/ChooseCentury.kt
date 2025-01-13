package com.example.russianquiz.fundamental

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
import androidx.navigation.compose.rememberNavController
import com.example.russianquiz.R
import com.example.russianquiz.bars.NavigationScreen
import com.example.russianquiz.model.Century
import com.example.russianquiz.model.MainViewModel
import com.example.russianquiz.ui.theme.RussianQuizTheme
import com.example.russianquiz.utils.toTwoDigitNumber

@Composable
fun ChooseCentury(
    centuries: List<Century>,
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

    LazyVerticalGrid(
        columns = GridCells.Fixed(countOfColumns),
        modifier = modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
    ) {
        items(items = centuries) { century ->
            Pentagon(
                pentagonSize = 100.dp,
                century = century,
                navController = navController,
                mainViewModel = mainViewModel,
                widthSize = widthSize,
            )
        }
    }
}

@Composable
fun Pentagon(
    modifier: Modifier = Modifier,
    pentagonSize: Dp,
    century: Century,
    widthSize: WindowWidthSizeClass,
    navController: NavHostController,
    mainViewModel: MainViewModel,
    isFirstStarFill: Boolean = false,
    isSecondStarFill: Boolean = false,
    isThirdStarFill: Boolean = false,
) {
    var isScalePlanetSize by remember { mutableStateOf(false) }
    val scale by animateFloatAsState(targetValue = if (isScalePlanetSize) 0.94f else 1f, label = "")

    val interactionSource = remember { MutableInteractionSource() }
    val density = LocalDensity.current

    val width = with(density) { pentagonSize.toPx() }
    val height = with(density) { pentagonSize.toPx() }
    val centuryString = stringResource(id = R.string.century)

    val textMeasurer = rememberTextMeasurer()
    val titular = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontSize = (38).sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
            )
        ) { append(centuryString.first()) }

        withStyle(
            style = SpanStyle(
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
            )
        ) { append(centuryString.substring(1..<centuryString.length)) }
    }

    val centuryNumberString = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontSize = 25.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
            )
        ) { append(century.centuryNumber.toTwoDigitNumber()) }
    }

    val textLayoutResultTitular: TextLayoutResult =
        textMeasurer.measure(text = titular)
    val textSizeTitular = textLayoutResultTitular.size

    val textLayoutResultCenturyNumber: TextLayoutResult =
        textMeasurer.measure(text = centuryNumberString)
    val textSizeCenturyNumber = textLayoutResultCenturyNumber.size

    val path = pentagonPath(width = width, height = height)

    Box(
        modifier = modifier
            .size(width = pentagonSize, height = pentagonSize * 1.2f),
        contentAlignment = Alignment.Center
    ) {
        Star(
            starSize = pentagonSize * 0.2f,
            isFill = isFirstStarFill,
            modifier = Modifier
                .offset(x = 0.dp, y = -(pentagonSize / 2.5f))
        )

        Star(
            starSize = pentagonSize * 0.2f,
            isFill = isSecondStarFill,
            modifier = Modifier
                .offset(x = -(pentagonSize * 0.3f), y = -(pentagonSize / 4f))
        )

        Star(
            starSize = pentagonSize * 0.2f,
            isFill = isThirdStarFill,
            modifier = Modifier
                .offset(x = pentagonSize * 0.3f, y = -(pentagonSize / 4f))
        )
        Canvas(
            modifier = Modifier
                .size(width = pentagonSize, height = pentagonSize * 1.2f)
                .pointerInput(isScalePlanetSize) {
                    awaitPointerEventScope {
                        isScalePlanetSize = if (isScalePlanetSize) {
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
                    mainViewModel.updateCurrentCentury(century = century)
                    navController.navigate(NavigationScreen.StatisticCenturyScreen.route)
                }
        ) {
            drawPath(
                path = path,
                brush = Brush.linearGradient(century.colors),
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
                text = centuryNumberString,
                blendMode = BlendMode.Lighten,
                topLeft = Offset(
                    (width - textSizeCenturyNumber.width) / 2f,
                    (height * 1.85f - textSizeCenturyNumber.height) / 2f
                )
            )
        }
    }
}

@Composable
fun Star(modifier: Modifier = Modifier, starSize: Dp, isFill: Boolean = false) {
    Canvas(modifier = modifier.size(starSize)) {
        val width = size.width
        val height = size.height

        val path = Path().apply {
            moveTo(width * 0.5f, 0f) // 1
            lineTo(width * 0.625f, height * 0.4f) // 2
            lineTo(width, height * 0.4f) // 3
            lineTo(width * 0.7f, height * 0.6f) // 4
            lineTo(width * 0.8f, height) // 5
            lineTo(width * 0.5f, height * 0.67f) // 6

            moveTo(width * 0.5f, 0f) // 1
            lineTo(width * 0.375f, height * 0.4f) // 2
            lineTo(0f, height * 0.4f) // 3
            lineTo(width * 0.3f, height * 0.6f) // 4
            lineTo(width * 0.2f, height) // 5
            lineTo(width * 0.5f, height * 0.67f) // 6
        }
        if (isFill) {
            drawPath(
                path = path,
                brush = Brush.linearGradient(listOf(Color(0xFFffd500), Color(0xFFd6ae01))),
            )
        }
        drawPath(
            path = path,
            brush = Brush.linearGradient(listOf(Color(0xFFffd500), Color(0x77918407))),
            style = Stroke(2f),
        )
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

@Preview(showBackground = true)
@Composable
fun StarPreview() {
    RussianQuizTheme {
        Star(starSize = 100.dp, isFill = true)
    }
}

@Preview(showBackground = true)
@Composable
fun PentagonPreview() {
    RussianQuizTheme(darkTheme = true) {
        Pentagon(
            pentagonSize = 100.dp,
            century = Century.FIFTEENTH,
            mainViewModel = MainViewModel(),
            navController = rememberNavController(),
            widthSize = WindowWidthSizeClass.Compact,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CenturiesCompactPreview() {
    RussianQuizTheme {
        ChooseCentury(
            centuries = Century.entries,
            widthSize = WindowWidthSizeClass.Compact,
            navController = rememberNavController(),
            mainViewModel = MainViewModel(),
        )
    }
}

@Preview(showBackground = true, widthDp = 700)
@Composable
fun CenturiesMediumPreview() {
    RussianQuizTheme {
        ChooseCentury(
            centuries = Century.entries,
            widthSize = WindowWidthSizeClass.Medium,
            navController = rememberNavController(),
            mainViewModel = MainViewModel(),
        )
    }
}

@Preview(showBackground = true, widthDp = 1000)
@Composable
fun CenturiesExpandedPreview() {
    RussianQuizTheme {
        ChooseCentury(
            centuries = Century.entries,
            widthSize = WindowWidthSizeClass.Expanded,
            navController = rememberNavController(),
            mainViewModel = MainViewModel(),
        )
    }
}