package com.example.russianquiz.utils

import java.util.Locale

fun Int.toTwoDigitNumber(): String {
    return String.format(Locale.CHINA, "%02d", this)
}