package com.example.russianquiz.utils

import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import java.util.Locale

fun Int.toTwoDigitNumber(): String {
    return String.format(Locale.CHINA, "%02d", this)
}

fun (() -> Unit).createVibration(context: Context) {
    this.invoke()
    val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        val vibrationEffect: VibrationEffect =
            VibrationEffect.createPredefined(VibrationEffect.EFFECT_DOUBLE_CLICK)
        vibrator.cancel()
        vibrator.vibrate(vibrationEffect)
    }
}