package com.example.russianquiz

import com.example.russianquiz.model.Century
import com.example.russianquiz.model.StartQuiz
import org.junit.Test

import org.junit.Assert.*

class ExampleUnitTest {
    @Test
    fun generation_wrong_answer() {
        val wrongAnswers = StartQuiz.generateWrongAnswers(Century.SIXTEENTH, 1544)
        println(wrongAnswers)
        assertTrue(wrongAnswers.size == 6)
        val wrongAnswers1 = StartQuiz.generateWrongAnswers(Century.TWENTIETH, 1991)
        println(wrongAnswers1)
        assertTrue(wrongAnswers1.size == 6)
    }

    @Test
    fun change_max_score_for_Century_enum() {
        val enum = Century.NINETEENTH
        enum.updateMaxScore(100)
        assertEquals(100, enum.maxScore)
        enum.updateMaxScore(200)
        assertEquals(200, enum.maxScore)
    }

    @Test
    fun change_first_completion_century_quiz() {
        val enum = Century.NINETEENTH
        enum.isCompleted(rightAnswer = 18, answers = 20)
        assertTrue(enum.isFirstCompleted)
        enum.isCompleted(rightAnswer = 18, answers = 21)
        assertTrue(enum.isFirstCompleted)
        assertTrue(!enum.isSecondCompleted)
        enum.isCompleted(rightAnswer = 18, answers = 20)
        assertTrue(enum.isFirstCompleted)
        assertTrue(enum.isSecondCompleted)
        assertTrue(!enum.isThirdCompleted)
        enum.isCompleted(rightAnswer = 18, answers = 20)
        assertTrue(enum.isFirstCompleted)
        assertTrue(enum.isSecondCompleted)
        assertTrue(enum.isThirdCompleted)
        enum.isCompleted(rightAnswer = 18, answers = 20)
        assertTrue(enum.isFirstCompleted)
        assertTrue(enum.isSecondCompleted)
        assertTrue(enum.isThirdCompleted)
    }
}