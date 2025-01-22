package com.example.russianquiz

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp

@Composable
fun Background(
    modifier: Modifier = Modifier
) {
    val deltaXAnim = rememberInfiniteTransition(label = "")
    val dx by deltaXAnim.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(10000, easing = LinearEasing)
        ), label = ""
    )

    val screenHeightPx = with(LocalDensity.current) {
        (LocalConfiguration.current.screenHeightDp * density)
    }

    val waveWidth = 880
    val originalY = 150f

    val color = colorResource(id = R.color.purple_500)
    val path = Path()
    Canvas(
        modifier = modifier
            .fillMaxSize()
    ) {
        translate(top = screenHeightPx * 0.25f) {
            drawPath(path = path, color = color)
            path.reset()
            val halfWaveWidth = waveWidth / 2
            path.moveTo(-waveWidth + (waveWidth * dx), originalY.dp.toPx())

            for (i in -waveWidth..(size.width.toInt() + waveWidth) step waveWidth) {
                path.relativeQuadraticTo(
                    halfWaveWidth.toFloat() / 2,
                    -125f,
                    halfWaveWidth.toFloat(),
                    0f
                )
                path.relativeQuadraticTo(
                    halfWaveWidth.toFloat() / 2,
                    125f,
                    halfWaveWidth.toFloat(),
                    0f
                )

            }
            path.lineTo(size.width, size.height)
            path.lineTo(0f, size.height)
            path.close()
        }
    }
}