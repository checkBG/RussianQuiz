package com.example.russianquiz.utils

fun Int.toTwoDigitNumber(): String {
    return if (this in (10..<100)) this.toString() else "0$this"
}