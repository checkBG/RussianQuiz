package com.example.russianquiz.model

import androidx.annotation.StringRes
import com.example.russianquiz.R

data class Quiz(
    @StringRes val question: Int,
    val rightAnswer: Int,
    val score: Int,
)

object Quizzes {
    val quizzes_ninth_century = listOf(
        Quiz(
            question = R.string.question_ninth_century_1,
            rightAnswer = 862,
            score = 1,
        ),
        Quiz(
            question = R.string.question_ninth_century_2,
            rightAnswer = R.string.answer_ninth_century_2,
            score = 2,
        ),
        Quiz(
            question = R.string.question_ninth_century_3,
            rightAnswer = R.string.answer_ninth_century_3,
            score = 1,
        ),
        Quiz(
            question = R.string.question_ninth_century_4,
            rightAnswer = 862,
            score = 2,
        ),
        Quiz(
            question = R.string.question_ninth_century_5,
            rightAnswer = R.string.answer_ninth_century_5,
            score = 3,
        ),
        Quiz(
            question = R.string.question_ninth_century_6,
            rightAnswer = R.string.answer_ninth_century_6,
            score = 3,
        ),
        Quiz(
            question = R.string.question_ninth_century_7,
            rightAnswer = R.string.answer_ninth_century_7,
            score = 3,
        ),
        Quiz(
            question = R.string.question_ninth_century_8,
            rightAnswer = R.string.answer_ninth_century_8,
            score = 2,
        ),
        Quiz(
            question = R.string.question_ninth_century_9,
            rightAnswer = R.string.answer_ninth_century_9,
            score = 3,
        ),
        Quiz(
            question = R.string.question_ninth_century_10,
            rightAnswer = R.string.answer_ninth_century_10,
            score = 2,
        ),
        Quiz(
            question = R.string.question_ninth_century_11,
            rightAnswer = R.string.answer_ninth_century_11,
            score = 3,
        ),
        Quiz(
            question = R.string.question_ninth_century_12,
            rightAnswer = R.string.answer_ninth_century_12,
            score = 3,
        ),
        Quiz(
            question = R.string.question_ninth_century_13,
            rightAnswer = R.string.answer_ninth_century_13,
            score = 2,
        ),
        Quiz(
            question = R.string.question_ninth_century_14,
            rightAnswer = R.string.answer_ninth_century_14,
            score = 2,
        ),
        Quiz(
            question = R.string.question_ninth_century_15,
            rightAnswer = R.string.answer_ninth_century_15,
            score = 1,
        ),
        Quiz(
            question = R.string.question_ninth_century_16,
            rightAnswer = R.string.answer_ninth_century_16,
            score = 3,
        ),
        Quiz(
            question = R.string.question_ninth_century_17,
            rightAnswer = R.string.answer_ninth_century_17,
            score = 4,
        ),
        Quiz(
            question = R.string.question_ninth_century_18,
            rightAnswer = R.string.answer_ninth_century_18,
            score = 3,
        ),
        Quiz(
            question = R.string.question_ninth_century_19,
            rightAnswer = R.string.answer_ninth_century_19,
            score = 4,
        ),
        Quiz(
            question = R.string.question_ninth_century_20,
            rightAnswer = R.string.answer_ninth_century_20,
            score = 4,
        ),
        Quiz(
            question = R.string.question_ninth_century_21,
            rightAnswer = R.string.answer_ninth_century_21,
            score = 3,
        ),
        Quiz(
            question = R.string.question_ninth_century_22,
            rightAnswer = R.string.answer_ninth_century_22,
            score = 4,
        ),
        Quiz(
            question = R.string.question_ninth_century_23,
            rightAnswer = R.string.answer_ninth_century_23,
            score = 3,
        ),
        Quiz(
            question = R.string.question_ninth_century_24,
            rightAnswer = R.string.answer_ninth_century_24,
            score = 3,
        ),
        Quiz(
            question = R.string.question_ninth_century_25,
            rightAnswer = R.string.answer_ninth_century_25,
            score = 4,
        ),
        Quiz(
            question = R.string.question_ninth_century_26,
            rightAnswer = R.string.answer_ninth_century_26,
            score = 3,
        ),
        Quiz(
            question = R.string.question_ninth_century_27,
            rightAnswer = R.string.answer_ninth_century_27,
            score = 3,
        ),
        Quiz(
            question = R.string.question_ninth_century_28,
            rightAnswer = R.string.answer_ninth_century_28,
            score = 3,
        ),
        Quiz(
            question = R.string.question_ninth_century_29,
            rightAnswer = R.string.answer_ninth_century_29,
            score = 4,
        ),
        Quiz(
            question = R.string.question_ninth_century_30,
            rightAnswer = R.string.answer_ninth_century_30,
            score = 4,
        ),
        Quiz(
            question = R.string.question_ninth_century_31,
            rightAnswer = R.string.answer_ninth_century_31,
            score = 3,
        ),
        Quiz(
            question = R.string.question_ninth_century_32,
            rightAnswer = R.string.answer_ninth_century_32,
            score = 4,
        ),
        Quiz(
            question = R.string.question_ninth_century_33,
            rightAnswer = R.string.answer_ninth_century_33,
            score = 4,
        ),
        Quiz(
            question = R.string.question_ninth_century_34,
            rightAnswer = R.string.answer_ninth_century_34,
            score = 3,
        ),
        Quiz(
            question = R.string.question_ninth_century_35,
            rightAnswer = R.string.answer_ninth_century_35,
            score = 3,
        ),
        Quiz(
            question = R.string.question_ninth_century_36,
            rightAnswer = R.string.answer_ninth_century_36,
            score = 4,
        ),
        Quiz(
            question = R.string.question_ninth_century_37,
            rightAnswer = R.string.answer_ninth_century_37,
            score = 3,
        ),
        Quiz(
            question = R.string.question_ninth_century_38,
            rightAnswer = R.string.answer_ninth_century_38,
            score = 2,
        ),
        Quiz(
            question = R.string.question_ninth_century_39,
            rightAnswer = R.string.answer_ninth_century_39,
            score = 3,
        ),
        Quiz(
            question = R.string.question_ninth_century_40,
            rightAnswer = R.string.answer_ninth_century_40,
            score = 4,
        ),
        Quiz(
            question = R.string.question_ninth_century_41,
            rightAnswer = R.string.answer_ninth_century_41,
            score = 4,
        ),
        Quiz(
            question = R.string.question_ninth_century_42,
            rightAnswer = R.string.answer_ninth_century_42,
            score = 2,
        ),
        Quiz(
            question = R.string.question_ninth_century_43,
            rightAnswer = R.string.answer_ninth_century_43,
            score = 3,
        ),
        Quiz(
            question = R.string.question_ninth_century_44,
            rightAnswer = R.string.answer_ninth_century_44,
            score = 4,
        ),
        Quiz(
            question = R.string.question_ninth_century_45,
            rightAnswer = R.string.answer_ninth_century_45,
            score = 4,
        ),
        Quiz(
            question = R.string.question_ninth_century_46,
            rightAnswer = R.string.answer_ninth_century_46,
            score = 3,
        ),
        Quiz(
            question = R.string.question_ninth_century_47,
            rightAnswer = R.string.answer_ninth_century_47,
            score = 3,
        ),
        Quiz(
            question = R.string.question_ninth_century_48,
            rightAnswer = R.string.answer_ninth_century_48,
            score = 4,
        ),
        Quiz(
            question = R.string.question_ninth_century_49,
            rightAnswer = R.string.answer_ninth_century_49,
            score = 3,
        ),
        Quiz(
            question = R.string.question_ninth_century_50,
            rightAnswer = R.string.answer_ninth_century_50,
            score = 2,
        )
    )
    val quizzes_tenth_century = listOf(
        Quiz(
            question = R.string.question_tenth_century_1,
            rightAnswer = R.string.answer_tenth_century_1,
            score = 3,
        ),
        Quiz(
            question = R.string.question_tenth_century_2,
            rightAnswer = 955,
            score = 2,
        ),
        Quiz(
            question = R.string.question_tenth_century_3,
            rightAnswer = R.string.answer_tenth_century_3,
            score = 4,
        ),
        Quiz(
            question = R.string.question_tenth_century_4,
            rightAnswer = R.string.answer_tenth_century_4,
            score = 4,
        ),
        Quiz(
            question = R.string.question_tenth_century_5,
            rightAnswer = R.string.answer_tenth_century_5,
            score = 5,
        ),
        Quiz(
            question = R.string.question_tenth_century_6,
            rightAnswer = R.string.answer_tenth_century_6,
            score = 4,
        ),
        Quiz(
            question = R.string.question_tenth_century_7,
            rightAnswer = R.string.answer_tenth_century_7,
            score = 3,
        ),
        Quiz(
            question = R.string.question_tenth_century_8,
            rightAnswer = R.string.answer_tenth_century_8,
            score = 3,
        ),
        Quiz(
            question = R.string.question_tenth_century_9,
            rightAnswer = R.string.answer_tenth_century_9,
            score = 4,
        ),
        Quiz(
            question = R.string.question_tenth_century_10,
            rightAnswer = R.string.answer_tenth_century_10,
            score = 5,
        ),
        Quiz(
            question = R.string.question_tenth_century_11,
            rightAnswer = R.string.answer_tenth_century_11,
            score = 4,
        ),
        Quiz(
            question = R.string.question_tenth_century_12,
            rightAnswer = R.string.answer_tenth_century_12,
            score = 3,
        ),
        Quiz(
            question = R.string.question_tenth_century_13,
            rightAnswer = R.string.answer_tenth_century_13,
            score = 2,
        ),
        Quiz(
            question = R.string.question_tenth_century_14,
            rightAnswer = R.string.answer_tenth_century_14,
            score = 4,
        ),
        Quiz(
            question = R.string.question_tenth_century_15,
            rightAnswer = R.string.answer_tenth_century_15,
            score = 3,
        ),
        Quiz(
            question = R.string.question_tenth_century_16,
            rightAnswer = 957,
            score = 3,
        ),
        Quiz(
            question = R.string.question_tenth_century_17,
            rightAnswer = R.string.answer_tenth_century_17,
            score = 5,
        ),
        Quiz(
            question = R.string.question_tenth_century_18,
            rightAnswer = R.string.answer_tenth_century_18,
            score = 3,
        ),
        Quiz(
            question = R.string.question_tenth_century_19,
            rightAnswer = R.string.answer_tenth_century_19,
            score = 3,
        ),
        Quiz(
            question = R.string.question_tenth_century_20,
            rightAnswer = R.string.answer_tenth_century_20,
            score = 4,
        ),
        Quiz(
            question = R.string.question_tenth_century_21,
            rightAnswer = R.string.answer_tenth_century_21,
            score = 4,
        ),
        Quiz(
            question = R.string.question_tenth_century_22,
            rightAnswer = R.string.answer_tenth_century_22,
            score = 3,
        ),
        Quiz(
            question = R.string.question_tenth_century_23,
            rightAnswer = R.string.answer_tenth_century_23,
            score = 5,
        ),
        Quiz(
            question = R.string.question_tenth_century_24,
            rightAnswer = R.string.answer_tenth_century_24,
            score = 3,
        ),
        Quiz(
            question = R.string.question_tenth_century_25,
            rightAnswer = R.string.answer_tenth_century_25,
            score = 3,
        ),
        Quiz(
            question = R.string.question_tenth_century_26,
            rightAnswer = R.string.answer_tenth_century_26,
            score = 4,
        ),
        Quiz(
            question = R.string.question_tenth_century_27,
            rightAnswer = R.string.answer_tenth_century_27,
            score = 3,
        ),
        Quiz(
            question = R.string.question_tenth_century_28,
            rightAnswer = R.string.answer_tenth_century_28,
            score = 4,
        ),
        Quiz(
            question = R.string.question_tenth_century_29,
            rightAnswer = R.string.answer_tenth_century_29,
            score = 4,
        ),
        Quiz(
            question = R.string.question_tenth_century_30,
            rightAnswer = R.string.answer_tenth_century_30,
            score = 3,
        ),
        Quiz(
            question = R.string.question_tenth_century_31,
            rightAnswer = R.string.answer_tenth_century_31,
            score = 4,
        ),
        Quiz(
            question = R.string.question_tenth_century_32,
            rightAnswer = R.string.answer_tenth_century_32,
            score = 5,
        ),
        Quiz(
            question = R.string.question_tenth_century_33,
            rightAnswer = R.string.answer_tenth_century_33,
            score = 2,
        ),
        Quiz(
            question = R.string.question_tenth_century_34,
            rightAnswer = R.string.answer_tenth_century_34,
            score = 4,
        ),
        Quiz(
            question = R.string.question_tenth_century_35,
            rightAnswer = R.string.answer_tenth_century_35,
            score = 5,
        ),
        Quiz(
            question = R.string.question_tenth_century_36,
            rightAnswer = R.string.answer_tenth_century_36,
            score = 3,
        ),
        Quiz(
            question = R.string.question_tenth_century_37,
            rightAnswer = R.string.answer_tenth_century_37,
            score = 4,
        ),
        Quiz(
            question = R.string.question_tenth_century_38,
            rightAnswer = R.string.answer_tenth_century_38,
            score = 5,
        ),
        Quiz(
            question = R.string.question_tenth_century_39,
            rightAnswer = R.string.answer_tenth_century_39,
            score = 3,
        ),
        Quiz(
            question = R.string.question_tenth_century_40,
            rightAnswer = R.string.answer_tenth_century_40,
            score = 4,
        ),
        Quiz(
            question = R.string.question_tenth_century_41,
            rightAnswer = R.string.answer_tenth_century_41,
            score = 5,
        ),
        Quiz(
            question = R.string.question_tenth_century_42,
            rightAnswer = R.string.answer_tenth_century_42,
            score = 4,
        ),
        Quiz(
            question = R.string.question_tenth_century_43,
            rightAnswer = R.string.answer_tenth_century_43,
            score = 4,
        ),
        Quiz(
            question = R.string.question_tenth_century_44,
            rightAnswer = R.string.answer_tenth_century_44,
            score = 3,
        ),
        Quiz(
            question = R.string.question_tenth_century_45,
            rightAnswer = R.string.answer_tenth_century_45,
            score = 1,
        ),
        Quiz(
            question = R.string.question_tenth_century_46,
            rightAnswer = R.string.answer_tenth_century_46,
            score = 4,
        ),
        Quiz(
            question = R.string.question_tenth_century_47,
            rightAnswer = R.string.answer_tenth_century_47,
            score = 5,
        ),
        Quiz(
            question = R.string.question_tenth_century_48,
            rightAnswer = R.string.answer_tenth_century_48,
            score = 4,
        ),
        Quiz(
            question = R.string.question_tenth_century_49,
            rightAnswer = R.string.answer_tenth_century_49,
            score = 3,
        ),
        Quiz(
            question = R.string.question_tenth_century_50,
            rightAnswer = R.string.answer_tenth_century_50,
            score = 5,
        )
    )
    val quizzes_eleventh_century = listOf(
        Quiz(
            question = R.string.question_eleventh_century_1,
            rightAnswer = R.string.answer_eleventh_century_1,
            score = 2,
        ),
        Quiz(
            question = R.string.question_eleventh_century_2,
            rightAnswer = R.string.answer_eleventh_century_2,
            score = 3,
        ),
        Quiz(
            question = R.string.question_eleventh_century_3,
            rightAnswer = R.string.answer_eleventh_century_3,
            score = 4,
        ),
        Quiz(
            question = R.string.question_eleventh_century_4,
            rightAnswer = R.string.answer_eleventh_century_4,
            score = 3,
        ),
        Quiz(
            question = R.string.question_eleventh_century_5,
            rightAnswer = R.string.answer_eleventh_century_5,
            score = 3,
        ),
        Quiz(
            question = R.string.question_eleventh_century_6,
            rightAnswer = R.string.answer_eleventh_century_6,
            score = 4,
        ),
        Quiz(
            question = R.string.question_eleventh_century_7,
            rightAnswer = R.string.answer_eleventh_century_7,
            score = 3,
        ),
        Quiz(
            question = R.string.question_eleventh_century_8,
            rightAnswer = R.string.answer_eleventh_century_8,
            score = 3,
        ),
        Quiz(
            question = R.string.question_eleventh_century_9,
            rightAnswer = R.string.answer_eleventh_century_9,
            score = 2,
        ),
        Quiz(
            question = R.string.question_eleventh_century_10,
            rightAnswer = R.string.answer_eleventh_century_10,
            score = 4,
        ),
        Quiz(
            question = R.string.question_eleventh_century_11,
            rightAnswer = R.string.answer_eleventh_century_11,
            score = 3,
        ),
        Quiz(
            question = R.string.question_eleventh_century_12,
            rightAnswer = R.string.answer_eleventh_century_12,
            score = 3,
        ),
        Quiz(
            question = R.string.question_eleventh_century_13,
            rightAnswer = R.string.answer_eleventh_century_13,
            score = 4,
        ),
        Quiz(
            question = R.string.question_eleventh_century_14,
            rightAnswer = R.string.answer_eleventh_century_14,
            score = 3,
        ),
        Quiz(
            question = R.string.question_eleventh_century_15,
            rightAnswer = R.string.answer_eleventh_century_15,
            score = 3,
        ),
        Quiz(
            question = R.string.question_eleventh_century_16,
            rightAnswer = R.string.answer_eleventh_century_16,
            score = 4,
        ),
        Quiz(
            question = R.string.question_eleventh_century_17,
            rightAnswer = R.string.answer_eleventh_century_17,
            score = 3,
        ),
        Quiz(
            question = R.string.question_eleventh_century_18,
            rightAnswer = R.string.answer_eleventh_century_18,
            score = 3,
        ),
        Quiz(
            question = R.string.question_eleventh_century_19,
            rightAnswer = R.string.answer_eleventh_century_19,
            score = 2,
        ),
        Quiz(
            question = R.string.question_eleventh_century_20,
            rightAnswer = R.string.answer_eleventh_century_20,
            score = 4,
        ),
        Quiz(
            question = R.string.question_eleventh_century_21,
            rightAnswer = R.string.answer_eleventh_century_21,
            score = 3,
        ),
        Quiz(
            question = R.string.question_eleventh_century_22,
            rightAnswer = R.string.answer_eleventh_century_22,
            score = 4,
        ),
        Quiz(
            question = R.string.question_eleventh_century_23,
            rightAnswer = R.string.answer_eleventh_century_23,
            score = 4,
        ),
        Quiz(
            question = R.string.question_eleventh_century_24,
            rightAnswer = R.string.answer_eleventh_century_24,
            score = 3,
        ),
        Quiz(
            question = R.string.question_eleventh_century_25,
            rightAnswer = R.string.answer_eleventh_century_25,
            score = 3,
        ),
        Quiz(
            question = R.string.question_eleventh_century_26,
            rightAnswer = R.string.answer_eleventh_century_26,
            score = 4,
        ),
        Quiz(
            question = R.string.question_eleventh_century_27,
            rightAnswer = R.string.answer_eleventh_century_27,
            score = 4,
        ),
        Quiz(
            question = R.string.question_eleventh_century_28,
            rightAnswer = R.string.answer_eleventh_century_28,
            score = 3,
        ),
        Quiz(
            question = R.string.question_eleventh_century_29,
            rightAnswer = R.string.answer_eleventh_century_29,
            score = 3,
        ),
        Quiz(
            question = R.string.question_eleventh_century_30,
            rightAnswer = R.string.answer_eleventh_century_30,
            score = 4,
        ),
        Quiz(
            question = R.string.question_eleventh_century_31,
            rightAnswer = R.string.answer_eleventh_century_31,
            score = 2,
        ),
        Quiz(
            question = R.string.question_eleventh_century_32,
            rightAnswer = R.string.answer_eleventh_century_32,
            score = 3,
        ),
        Quiz(
            question = R.string.question_eleventh_century_33,
            rightAnswer = R.string.answer_eleventh_century_33,
            score = 3,
        ),
        Quiz(
            question = R.string.question_eleventh_century_34,
            rightAnswer = R.string.answer_eleventh_century_34,
            score = 4,
        ),
        Quiz(
            question = R.string.question_eleventh_century_35,
            rightAnswer = R.string.answer_eleventh_century_35,
            score = 3,
        ),
        Quiz(
            question = R.string.question_eleventh_century_36,
            rightAnswer = R.string.answer_eleventh_century_36,
            score = 4,
        ),
        Quiz(
            question = R.string.question_eleventh_century_37,
            rightAnswer = R.string.answer_eleventh_century_37,
            score = 3,
        ),
        Quiz(
            question = R.string.question_eleventh_century_38,
            rightAnswer = R.string.answer_eleventh_century_38,
            score = 3,
        ),
        Quiz(
            question = R.string.question_eleventh_century_39,
            rightAnswer = R.string.answer_eleventh_century_39,
            score = 4,
        ),
        Quiz(
            question = R.string.question_eleventh_century_40,
            rightAnswer = R.string.answer_eleventh_century_40,
            score = 3,
        ),
        Quiz(
            question = R.string.question_eleventh_century_41,
            rightAnswer = R.string.answer_eleventh_century_41,
            score = 3,
        ),
        Quiz(
            question = R.string.question_eleventh_century_42,
            rightAnswer = R.string.answer_eleventh_century_42,
            score = 2,
        ),
        Quiz(
            question = R.string.question_eleventh_century_43,
            rightAnswer = R.string.answer_eleventh_century_43,
            score = 3,
        ),
        Quiz(
            question = R.string.question_eleventh_century_44,
            rightAnswer = R.string.answer_eleventh_century_44,
            score = 4,
        ),
        Quiz(
            question = R.string.question_eleventh_century_45,
            rightAnswer = R.string.answer_eleventh_century_45,
            score = 4,
        ),
        Quiz(
            question = R.string.question_eleventh_century_46,
            rightAnswer = R.string.answer_eleventh_century_46,
            score = 2,
        ),
        Quiz(
            question = R.string.question_eleventh_century_47,
            rightAnswer = R.string.answer_eleventh_century_47,
            score = 3,
        ),
        Quiz(
            question = R.string.question_eleventh_century_48,
            rightAnswer = R.string.answer_eleventh_century_48,
            score = 3,
        ),
        Quiz(
            question = R.string.question_eleventh_century_49,
            rightAnswer = R.string.answer_eleventh_century_49,
            score = 2,
        ),
        Quiz(
            question = R.string.question_eleventh_century_50,
            rightAnswer = R.string.answer_eleventh_century_50,
            score = 3,
        )
    )
    val quizzes_twelfth_century = listOf(
        Quiz(
            question = R.string.question_twelfth_century_1,
            rightAnswer = R.string.answer_twelfth_century_1,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twelfth_century_2,
            rightAnswer = R.string.answer_twelfth_century_2,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twelfth_century_3,
            rightAnswer = R.string.answer_twelfth_century_3,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twelfth_century_4,
            rightAnswer = R.string.answer_twelfth_century_4,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twelfth_century_5,
            rightAnswer = R.string.answer_twelfth_century_5,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twelfth_century_6,
            rightAnswer = R.string.answer_twelfth_century_6,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twelfth_century_7,
            rightAnswer = R.string.answer_twelfth_century_7,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twelfth_century_8,
            rightAnswer = R.string.answer_twelfth_century_8,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twelfth_century_9,
            rightAnswer = R.string.answer_twelfth_century_9,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twelfth_century_10,
            rightAnswer = R.string.answer_twelfth_century_10,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twelfth_century_11,
            rightAnswer = R.string.answer_twelfth_century_11,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twelfth_century_12,
            rightAnswer = R.string.answer_twelfth_century_12,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twelfth_century_13,
            rightAnswer = R.string.answer_twelfth_century_13,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twelfth_century_14,
            rightAnswer = R.string.answer_twelfth_century_14,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twelfth_century_15,
            rightAnswer = R.string.answer_twelfth_century_15,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twelfth_century_16,
            rightAnswer = R.string.answer_twelfth_century_16,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twelfth_century_17,
            rightAnswer = R.string.answer_twelfth_century_17,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twelfth_century_18,
            rightAnswer = R.string.answer_twelfth_century_18,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twelfth_century_19,
            rightAnswer = R.string.answer_twelfth_century_19,
            score = 5,
        ),
        Quiz(
            question = R.string.question_twelfth_century_20,
            rightAnswer = R.string.answer_twelfth_century_20,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twelfth_century_21,
            rightAnswer = R.string.answer_twelfth_century_21,
            score = 5,
        ),
        Quiz(
            question = R.string.question_twelfth_century_22,
            rightAnswer = R.string.answer_twelfth_century_22,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twelfth_century_23,
            rightAnswer = R.string.answer_twelfth_century_23,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twelfth_century_24,
            rightAnswer = R.string.answer_twelfth_century_24,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twelfth_century_25,
            rightAnswer = R.string.answer_twelfth_century_25,
            score = 5,
        ),
        Quiz(
            question = R.string.question_twelfth_century_26,
            rightAnswer = R.string.answer_twelfth_century_26,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twelfth_century_27,
            rightAnswer = R.string.answer_twelfth_century_27,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twelfth_century_28,
            rightAnswer = R.string.answer_twelfth_century_28,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twelfth_century_29,
            rightAnswer = R.string.answer_twelfth_century_29,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twelfth_century_30,
            rightAnswer = R.string.answer_twelfth_century_30,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twelfth_century_31,
            rightAnswer = R.string.answer_twelfth_century_31,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twelfth_century_32,
            rightAnswer = R.string.answer_twelfth_century_32,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twelfth_century_33,
            rightAnswer = R.string.answer_twelfth_century_33,
            score = 5,
        ),
        Quiz(
            question = R.string.question_twelfth_century_34,
            rightAnswer = R.string.answer_twelfth_century_34,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twelfth_century_35,
            rightAnswer = R.string.answer_twelfth_century_35,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twelfth_century_36,
            rightAnswer = R.string.answer_twelfth_century_36,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twelfth_century_37,
            rightAnswer = R.string.answer_twelfth_century_37,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twelfth_century_38,
            rightAnswer = R.string.answer_twelfth_century_38,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twelfth_century_39,
            rightAnswer = R.string.answer_twelfth_century_39,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twelfth_century_40,
            rightAnswer = R.string.answer_twelfth_century_40,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twelfth_century_41,
            rightAnswer = R.string.answer_twelfth_century_41,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twelfth_century_42,
            rightAnswer = R.string.answer_twelfth_century_42,
            score = 5,
        ),
        Quiz(
            question = R.string.question_twelfth_century_43,
            rightAnswer = R.string.answer_twelfth_century_43,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twelfth_century_44,
            rightAnswer = R.string.answer_twelfth_century_44,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twelfth_century_45,
            rightAnswer = R.string.answer_twelfth_century_45,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twelfth_century_46,
            rightAnswer = R.string.answer_twelfth_century_46,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twelfth_century_47,
            rightAnswer = R.string.answer_twelfth_century_47,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twelfth_century_48,
            rightAnswer = R.string.answer_twelfth_century_48,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twelfth_century_49,
            rightAnswer = R.string.answer_twelfth_century_49,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twelfth_century_50,
            rightAnswer = R.string.answer_twelfth_century_50,
            score = 3,
        )
    )
    val quizzes_thirteenth_century = listOf(
        Quiz(
            question = R.string.question_thirteenth_century_1,
            rightAnswer = R.string.answer_thirteenth_century_1,
            score = 4,
        ),
        Quiz(
            question = R.string.question_thirteenth_century_2,
            rightAnswer = R.string.answer_thirteenth_century_2,
            score = 4,
        ),
        Quiz(
            question = R.string.question_thirteenth_century_3,
            rightAnswer = R.string.answer_thirteenth_century_3,
            score = 3,
        ),
        Quiz(
            question = R.string.question_thirteenth_century_4,
            rightAnswer = R.string.answer_thirteenth_century_4,
            score = 3,
        ),
        Quiz(
            question = R.string.question_thirteenth_century_5,
            rightAnswer = R.string.answer_thirteenth_century_5,
            score = 4,
        ),
        Quiz(
            question = R.string.question_thirteenth_century_6,
            rightAnswer = R.string.answer_thirteenth_century_6,
            score = 3,
        ),
        Quiz(
            question = R.string.question_thirteenth_century_7,
            rightAnswer = R.string.answer_thirteenth_century_7,
            score = 4,
        ),
        Quiz(
            question = R.string.question_thirteenth_century_8,
            rightAnswer = R.string.answer_thirteenth_century_8,
            score = 3,
        ),
        Quiz(
            question = R.string.question_thirteenth_century_9,
            rightAnswer = R.string.answer_thirteenth_century_9,
            score = 4,
        ),
        Quiz(
            question = R.string.question_thirteenth_century_10,
            rightAnswer = R.string.answer_thirteenth_century_10,
            score = 5,
        ),
        Quiz(
            question = R.string.question_thirteenth_century_11,
            rightAnswer = R.string.answer_thirteenth_century_11,
            score = 4,
        ),
        Quiz(
            question = R.string.question_thirteenth_century_12,
            rightAnswer = R.string.answer_thirteenth_century_12,
            score = 2,
        ),
        Quiz(
            question = R.string.question_thirteenth_century_13,
            rightAnswer = R.string.answer_thirteenth_century_13,
            score = 4,
        ),
        Quiz(
            question = R.string.question_thirteenth_century_14,
            rightAnswer = R.string.answer_thirteenth_century_14,
            score = 3,
        ),
        Quiz(
            question = R.string.question_thirteenth_century_15,
            rightAnswer = R.string.answer_thirteenth_century_15,
            score = 4,
        ),
        Quiz(
            question = R.string.question_thirteenth_century_16,
            rightAnswer = R.string.answer_thirteenth_century_16,
            score = 3,
        ),
        Quiz(
            question = R.string.question_thirteenth_century_17,
            rightAnswer = R.string.answer_thirteenth_century_17,
            score = 3,
        ),
        Quiz(
            question = R.string.question_thirteenth_century_18,
            rightAnswer = R.string.answer_thirteenth_century_18,
            score = 4,
        ),
        Quiz(
            question = R.string.question_thirteenth_century_19,
            rightAnswer = R.string.answer_thirteenth_century_19,
            score = 3,
        ),
        Quiz(
            question = R.string.question_thirteenth_century_20,
            rightAnswer = R.string.answer_thirteenth_century_20,
            score = 4,
        ),
        Quiz(
            question = R.string.question_thirteenth_century_21,
            rightAnswer = R.string.answer_thirteenth_century_21,
            score = 3,
        ),
        Quiz(
            question = R.string.question_thirteenth_century_22,
            rightAnswer = R.string.answer_thirteenth_century_22,
            score = 5,
        ),
        Quiz(
            question = R.string.question_thirteenth_century_23,
            rightAnswer = R.string.answer_thirteenth_century_23,
            score = 4,
        ),
        Quiz(
            question = R.string.question_thirteenth_century_24,
            rightAnswer = R.string.answer_thirteenth_century_24,
            score = 4,
        ),
        Quiz(
            question = R.string.question_thirteenth_century_25,
            rightAnswer = R.string.answer_thirteenth_century_25,
            score = 4,
        ),
        Quiz(
            question = R.string.question_thirteenth_century_26,
            rightAnswer = R.string.answer_thirteenth_century_26,
            score = 5,
        ),
        Quiz(
            question = R.string.question_thirteenth_century_27,
            rightAnswer = R.string.answer_thirteenth_century_27,
            score = 3,
        ),
        Quiz(
            question = R.string.question_thirteenth_century_28,
            rightAnswer = R.string.answer_thirteenth_century_28,
            score = 3,
        ),
        Quiz(
            question = R.string.question_thirteenth_century_29,
            rightAnswer = R.string.answer_thirteenth_century_29,
            score = 3,
        ),
        Quiz(
            question = R.string.question_thirteenth_century_30,
            rightAnswer = R.string.answer_thirteenth_century_30,
            score = 4,
        ),
        Quiz(
            question = R.string.question_thirteenth_century_31,
            rightAnswer = R.string.answer_thirteenth_century_31,
            score = 4,
        ),
        Quiz(
            question = R.string.question_thirteenth_century_32,
            rightAnswer = R.string.answer_thirteenth_century_32,
            score = 4,
        ),
        Quiz(
            question = R.string.question_thirteenth_century_33,
            rightAnswer = R.string.answer_thirteenth_century_33,
            score = 3,
        ),
        Quiz(
            question = R.string.question_thirteenth_century_34,
            rightAnswer = R.string.answer_thirteenth_century_34,
            score = 3,
        ),
        Quiz(
            question = R.string.question_thirteenth_century_35,
            rightAnswer = R.string.answer_thirteenth_century_35,
            score = 4,
        ),
        Quiz(
            question = R.string.question_thirteenth_century_36,
            rightAnswer = R.string.answer_thirteenth_century_36,
            score = 4,
        ),
        Quiz(
            question = R.string.question_thirteenth_century_37,
            rightAnswer = R.string.answer_thirteenth_century_37,
            score = 4,
        ),
        Quiz(
            question = R.string.question_thirteenth_century_38,
            rightAnswer = R.string.answer_thirteenth_century_38,
            score = 4,
        ),
        Quiz(
            question = R.string.question_thirteenth_century_39,
            rightAnswer = R.string.answer_thirteenth_century_39,
            score = 3,
        ),
        Quiz(
            question = R.string.question_thirteenth_century_40,
            rightAnswer = R.string.answer_thirteenth_century_40,
            score = 3,
        ),
        Quiz(
            question = R.string.question_thirteenth_century_41,
            rightAnswer = R.string.answer_thirteenth_century_41,
            score = 2,
        ),
        Quiz(
            question = R.string.question_thirteenth_century_42,
            rightAnswer = R.string.answer_thirteenth_century_42,
            score = 3,
        ),
        Quiz(
            question = R.string.question_thirteenth_century_43,
            rightAnswer = R.string.answer_thirteenth_century_43,
            score = 3,
        ),
        Quiz(
            question = R.string.question_thirteenth_century_44,
            rightAnswer = R.string.answer_thirteenth_century_44,
            score = 4,
        ),
        Quiz(
            question = R.string.question_thirteenth_century_45,
            rightAnswer = R.string.answer_thirteenth_century_45,
            score = 2,
        ),
        Quiz(
            question = R.string.question_thirteenth_century_46,
            rightAnswer = R.string.answer_thirteenth_century_46,
            score = 5,
        ),
        Quiz(
            question = R.string.question_thirteenth_century_47,
            rightAnswer = R.string.answer_thirteenth_century_47,
            score = 4,
        ),
        Quiz(
            question = R.string.question_thirteenth_century_48,
            rightAnswer = R.string.answer_thirteenth_century_48,
            score = 3,
        ),
        Quiz(
            question = R.string.question_thirteenth_century_49,
            rightAnswer = R.string.answer_thirteenth_century_49,
            score = 3,
        ),
        Quiz(
            question = R.string.question_thirteenth_century_50,
            rightAnswer = R.string.answer_thirteenth_century_50,
            score = 4,
        )
    )
    val quizzes_fourteenth_century = listOf(
        Quiz(
            question = R.string.question_fourteenth_century_1,
            rightAnswer = R.string.answer_fourteenth_century_1,
            score = 3,
        ),
        Quiz(
            question = R.string.question_fourteenth_century_2,
            rightAnswer = R.string.answer_fourteenth_century_2,
            score = 4,
        ),
        Quiz(
            question = R.string.question_fourteenth_century_3,
            rightAnswer = R.string.answer_fourteenth_century_3,
            score = 2,
        ),
        Quiz(
            question = R.string.question_fourteenth_century_4,
            rightAnswer = R.string.answer_fourteenth_century_4,
            score = 5,
        ),
        Quiz(
            question = R.string.question_fourteenth_century_5,
            rightAnswer = R.string.answer_fourteenth_century_5,
            score = 4,
        ),
        Quiz(
            question = R.string.question_fourteenth_century_6,
            rightAnswer = R.string.answer_fourteenth_century_6,
            score = 3,
        ),
        Quiz(
            question = R.string.question_fourteenth_century_7,
            rightAnswer = R.string.answer_fourteenth_century_7,
            score = 4,
        ),
        Quiz(
            question = R.string.question_fourteenth_century_8,
            rightAnswer = R.string.answer_fourteenth_century_8,
            score = 3,
        ),
        Quiz(
            question = R.string.question_fourteenth_century_9,
            rightAnswer = R.string.answer_fourteenth_century_9,
            score = 3,
        ),
        Quiz(
            question = R.string.question_fourteenth_century_10,
            rightAnswer = R.string.answer_fourteenth_century_10,
            score = 4,
        ),
        Quiz(
            question = R.string.question_fourteenth_century_11,
            rightAnswer = R.string.answer_fourteenth_century_11,
            score = 4,
        ),
        Quiz(
            question = R.string.question_fourteenth_century_12,
            rightAnswer = R.string.answer_fourteenth_century_12,
            score = 5,
        ),
        Quiz(
            question = R.string.question_fourteenth_century_13,
            rightAnswer = R.string.answer_fourteenth_century_13,
            score = 4,
        ),
        Quiz(
            question = R.string.question_fourteenth_century_14,
            rightAnswer = R.string.answer_fourteenth_century_14,
            score = 3,
        ),
        Quiz(
            question = R.string.question_fourteenth_century_15,
            rightAnswer = R.string.answer_fourteenth_century_15,
            score = 4,
        ),
        Quiz(
            question = R.string.question_fourteenth_century_16,
            rightAnswer = R.string.answer_fourteenth_century_16,
            score = 3,
        ),
        Quiz(
            question = R.string.question_fourteenth_century_17,
            rightAnswer = R.string.answer_fourteenth_century_17,
            score = 3,
        ),
        Quiz(
            question = R.string.question_fourteenth_century_18,
            rightAnswer = R.string.answer_fourteenth_century_18,
            score = 4,
        ),
        Quiz(
            question = R.string.question_fourteenth_century_19,
            rightAnswer = R.string.answer_fourteenth_century_19,
            score = 4,
        ),
        Quiz(
            question = R.string.question_fourteenth_century_20,
            rightAnswer = R.string.answer_fourteenth_century_20,
            score = 3,
        ),
        Quiz(
            question = R.string.question_fourteenth_century_21,
            rightAnswer = R.string.answer_fourteenth_century_21,
            score = 3,
        ),
        Quiz(
            question = R.string.question_fourteenth_century_22,
            rightAnswer = R.string.answer_fourteenth_century_22,
            score = 3,
        ),
        Quiz(
            question = R.string.question_fourteenth_century_23,
            rightAnswer = R.string.answer_fourteenth_century_23,
            score = 4,
        ),
        Quiz(
            question = R.string.question_fourteenth_century_24,
            rightAnswer = R.string.answer_fourteenth_century_24,
            score = 4,
        ),
        Quiz(
            question = R.string.question_fourteenth_century_25,
            rightAnswer = R.string.answer_fourteenth_century_25,
            score = 3,
        ),
        Quiz(
            question = R.string.question_fourteenth_century_26,
            rightAnswer = R.string.answer_fourteenth_century_26,
            score = 4,
        ),
        Quiz(
            question = R.string.question_fourteenth_century_27,
            rightAnswer = R.string.answer_fourteenth_century_27,
            score = 4,
        ),
        Quiz(
            question = R.string.question_fourteenth_century_28,
            rightAnswer = R.string.answer_fourteenth_century_28,
            score = 4,
        ),
        Quiz(
            question = R.string.question_fourteenth_century_29,
            rightAnswer = R.string.answer_fourteenth_century_29,
            score = 3,
        ),
        Quiz(
            question = R.string.question_fourteenth_century_30,
            rightAnswer = R.string.answer_fourteenth_century_30,
            score = 3,
        ),
        Quiz(
            question = R.string.question_fourteenth_century_31,
            rightAnswer = R.string.answer_fourteenth_century_31,
            score = 4,
        ),
        Quiz(
            question = R.string.question_fourteenth_century_32,
            rightAnswer = R.string.answer_fourteenth_century_32,
            score = 3,
        ),
        Quiz(
            question = R.string.question_fourteenth_century_33,
            rightAnswer = R.string.answer_fourteenth_century_33,
            score = 4,
        ),
        Quiz(
            question = R.string.question_fourteenth_century_34,
            rightAnswer = R.string.answer_fourteenth_century_34,
            score = 4,
        ),
        Quiz(
            question = R.string.question_fourteenth_century_35,
            rightAnswer = R.string.answer_fourteenth_century_35,
            score = 4,
        ),
        Quiz(
            question = R.string.question_fourteenth_century_36,
            rightAnswer = R.string.answer_fourteenth_century_36,
            score = 4,
        ),
        Quiz(
            question = R.string.question_fourteenth_century_37,
            rightAnswer = R.string.answer_fourteenth_century_37,
            score = 4,
        ),
        Quiz(
            question = R.string.question_fourteenth_century_38,
            rightAnswer = R.string.answer_fourteenth_century_38,
            score = 3,
        ),
        Quiz(
            question = R.string.question_fourteenth_century_39,
            rightAnswer = R.string.answer_fourteenth_century_39,
            score = 3,
        ),
        Quiz(
            question = R.string.question_fourteenth_century_40,
            rightAnswer = R.string.answer_fourteenth_century_40,
            score = 4,
        ),
        Quiz(
            question = R.string.question_fourteenth_century_41,
            rightAnswer = R.string.answer_fourteenth_century_41,
            score = 3,
        ),
        Quiz(
            question = R.string.question_fourteenth_century_42,
            rightAnswer = R.string.answer_fourteenth_century_42,
            score = 3,
        ),
        Quiz(
            question = R.string.question_fourteenth_century_43,
            rightAnswer = R.string.answer_fourteenth_century_43,
            score = 3,
        ),
        Quiz(
            question = R.string.question_fourteenth_century_44,
            rightAnswer = R.string.answer_fourteenth_century_44,
            score = 4,
        ),
        Quiz(
            question = R.string.question_fourteenth_century_45,
            rightAnswer = R.string.answer_fourteenth_century_45,
            score = 4,
        ),
        Quiz(
            question = R.string.question_fourteenth_century_46,
            rightAnswer = R.string.answer_fourteenth_century_46,
            score = 4,
        ),
        Quiz(
            question = R.string.question_fourteenth_century_47,
            rightAnswer = R.string.answer_fourteenth_century_47,
            score = 4,
        ),
        Quiz(
            question = R.string.question_fourteenth_century_48,
            rightAnswer = R.string.answer_fourteenth_century_48,
            score = 3,
        ),
        Quiz(
            question = R.string.question_fourteenth_century_49,
            rightAnswer = R.string.answer_fourteenth_century_49,
            score = 4,
        ),
        Quiz(
            question = R.string.question_fourteenth_century_50,
            rightAnswer = R.string.answer_fourteenth_century_50,
            score = 3,
        )
    )
    val quizzes_fifteenth_century = listOf(
        Quiz(
            question = R.string.question_fifteenth_century_1,
            rightAnswer = R.string.answer_fifteenth_century_1,
            score = 3,
        ),
        Quiz(
            question = R.string.question_fifteenth_century_2,
            rightAnswer = R.string.answer_fifteenth_century_2,
            score = 3,
        ),
        Quiz(
            question = R.string.question_fifteenth_century_3,
            rightAnswer = R.string.answer_fifteenth_century_3,
            score = 2,
        ),
        Quiz(
            question = R.string.question_fifteenth_century_4,
            rightAnswer = R.string.answer_fifteenth_century_4,
            score = 4,
        ),
        Quiz(
            question = R.string.question_fifteenth_century_5,
            rightAnswer = R.string.answer_fifteenth_century_5,
            score = 4,
        ),
        Quiz(
            question = R.string.question_fifteenth_century_6,
            rightAnswer = R.string.answer_fifteenth_century_6,
            score = 3,
        ),
        Quiz(
            question = R.string.question_fifteenth_century_7,
            rightAnswer = R.string.answer_fifteenth_century_7,
            score = 3,
        ),
        Quiz(
            question = R.string.question_fifteenth_century_8,
            rightAnswer = R.string.answer_fifteenth_century_8,
            score = 4,
        ),
        Quiz(
            question = R.string.question_fifteenth_century_9,
            rightAnswer = R.string.answer_fifteenth_century_9,
            score = 4,
        ),
        Quiz(
            question = R.string.question_fifteenth_century_10,
            rightAnswer = R.string.answer_fifteenth_century_10,
            score = 3,
        ),
        Quiz(
            question = R.string.question_fifteenth_century_11,
            rightAnswer = R.string.answer_fifteenth_century_11,
            score = 3,
        ),
        Quiz(
            question = R.string.question_fifteenth_century_12,
            rightAnswer = R.string.answer_fifteenth_century_12,
            score = 2,
        ),
        Quiz(
            question = R.string.question_fifteenth_century_13,
            rightAnswer = R.string.answer_fifteenth_century_13,
            score = 3,
        ),
        Quiz(
            question = R.string.question_fifteenth_century_14,
            rightAnswer = R.string.answer_fifteenth_century_14,
            score = 3,
        ),
        Quiz(
            question = R.string.question_fifteenth_century_15,
            rightAnswer = R.string.answer_fifteenth_century_15,
            score = 2,
        ),
        Quiz(
            question = R.string.question_fifteenth_century_16,
            rightAnswer = R.string.answer_fifteenth_century_16,
            score = 3,
        ),
        Quiz(
            question = R.string.question_fifteenth_century_17,
            rightAnswer = R.string.answer_fifteenth_century_17,
            score = 4,
        ),
        Quiz(
            question = R.string.question_fifteenth_century_18,
            rightAnswer = R.string.answer_fifteenth_century_18,
            score = 4,
        ),
        Quiz(
            question = R.string.question_fifteenth_century_19,
            rightAnswer = R.string.answer_fifteenth_century_19,
            score = 3,
        ),
        Quiz(
            question = R.string.question_fifteenth_century_20,
            rightAnswer = R.string.answer_fifteenth_century_20,
            score = 4,
        ),
        Quiz(
            question = R.string.question_fifteenth_century_21,
            rightAnswer = R.string.answer_fifteenth_century_21,
            score = 3,
        ),
        Quiz(
            question = R.string.question_fifteenth_century_22,
            rightAnswer = R.string.answer_fifteenth_century_22,
            score = 4,
        ),
        Quiz(
            question = R.string.question_fifteenth_century_23,
            rightAnswer = R.string.answer_fifteenth_century_23,
            score = 4,
        ),
        Quiz(
            question = R.string.question_fifteenth_century_24,
            rightAnswer = R.string.answer_fifteenth_century_24,
            score = 3,
        ),
        Quiz(
            question = R.string.question_fifteenth_century_25,
            rightAnswer = R.string.answer_fifteenth_century_25,
            score = 3,
        ),
        Quiz(
            question = R.string.question_fifteenth_century_26,
            rightAnswer = R.string.answer_fifteenth_century_26,
            score = 3,
        ),
        Quiz(
            question = R.string.question_fifteenth_century_27,
            rightAnswer = R.string.answer_fifteenth_century_27,
            score = 4,
        ),
        Quiz(
            question = R.string.question_fifteenth_century_28,
            rightAnswer = R.string.answer_fifteenth_century_28,
            score = 4,
        ),
        Quiz(
            question = R.string.question_fifteenth_century_29,
            rightAnswer = R.string.answer_fifteenth_century_29,
            score = 3,
        ),
        Quiz(
            question = R.string.question_fifteenth_century_30,
            rightAnswer = R.string.answer_fifteenth_century_30,
            score = 5,
        ),
        Quiz(
            question = R.string.question_fifteenth_century_31,
            rightAnswer = R.string.answer_fifteenth_century_31,
            score = 4,
        ),
        Quiz(
            question = R.string.question_fifteenth_century_32,
            rightAnswer = R.string.answer_fifteenth_century_32,
            score = 3,
        ),
        Quiz(
            question = R.string.question_fifteenth_century_33,
            rightAnswer = R.string.answer_fifteenth_century_33,
            score = 4,
        ),
        Quiz(
            question = R.string.question_fifteenth_century_34,
            rightAnswer = R.string.answer_fifteenth_century_34,
            score = 5,
        ),
        Quiz(
            question = R.string.question_fifteenth_century_35,
            rightAnswer = R.string.answer_fifteenth_century_35,
            score = 4,
        ),
        Quiz(
            question = R.string.question_fifteenth_century_36,
            rightAnswer = R.string.answer_fifteenth_century_36,
            score = 4,
        ),
        Quiz(
            question = R.string.question_fifteenth_century_37,
            rightAnswer = R.string.answer_fifteenth_century_37,
            score = 4,
        ),
        Quiz(
            question = R.string.question_fifteenth_century_38,
            rightAnswer = R.string.answer_fifteenth_century_38,
            score = 4,
        ),
        Quiz(
            question = R.string.question_fifteenth_century_39,
            rightAnswer = R.string.answer_fifteenth_century_39,
            score = 3,
        ),
        Quiz(
            question = R.string.question_fifteenth_century_40,
            rightAnswer = R.string.answer_fifteenth_century_40,
            score = 3,
        ),
        Quiz(
            question = R.string.question_fifteenth_century_41,
            rightAnswer = R.string.answer_fifteenth_century_41,
            score = 2,
        ),
        Quiz(
            question = R.string.question_fifteenth_century_42,
            rightAnswer = R.string.answer_fifteenth_century_42,
            score = 4,
        ),
        Quiz(
            question = R.string.question_fifteenth_century_43,
            rightAnswer = R.string.answer_fifteenth_century_43,
            score = 3,
        ),
        Quiz(
            question = R.string.question_fifteenth_century_44,
            rightAnswer = R.string.answer_fifteenth_century_44,
            score = 4,
        ),
        Quiz(
            question = R.string.question_fifteenth_century_45,
            rightAnswer = R.string.answer_fifteenth_century_45,
            score = 4,
        ),
        Quiz(
            question = R.string.question_fifteenth_century_46,
            rightAnswer = R.string.answer_fifteenth_century_46,
            score = 4,
        ),
        Quiz(
            question = R.string.question_fifteenth_century_47,
            rightAnswer = R.string.answer_fifteenth_century_47,
            score = 3,
        ),
        Quiz(
            question = R.string.question_fifteenth_century_48,
            rightAnswer = R.string.answer_fifteenth_century_48,
            score = 3,
        ),
        Quiz(
            question = R.string.question_fifteenth_century_49,
            rightAnswer = R.string.answer_fifteenth_century_49,
            score = 3,
        ),
        Quiz(
            question = R.string.question_fifteenth_century_50,
            rightAnswer = R.string.answer_fifteenth_century_50,
            score = 3,
        )
    )
    val quizzes_sixteenth_century = listOf(
        Quiz(
            question = R.string.question_sixteenth_century_1,
            rightAnswer = R.string.answer_sixteenth_century_1,
            score = 4,
        ),
        Quiz(
            question = R.string.question_sixteenth_century_2,
            rightAnswer = R.string.answer_sixteenth_century_2,
            score = 4,
        ),
        Quiz(
            question = R.string.question_sixteenth_century_3,
            rightAnswer = R.string.answer_sixteenth_century_3,
            score = 4,
        ),
        Quiz(
            question = R.string.question_sixteenth_century_4,
            rightAnswer = R.string.answer_sixteenth_century_4,
            score = 4,
        ),
        Quiz(
            question = R.string.question_sixteenth_century_5,
            rightAnswer = R.string.answer_sixteenth_century_5,
            score = 3,
        ),
        Quiz(
            question = R.string.question_sixteenth_century_6,
            rightAnswer = R.string.answer_sixteenth_century_6,
            score = 3,
        ),
        Quiz(
            question = R.string.question_sixteenth_century_7,
            rightAnswer = R.string.answer_sixteenth_century_7,
            score = 4,
        ),
        Quiz(
            question = R.string.question_sixteenth_century_8,
            rightAnswer = R.string.answer_sixteenth_century_8,
            score = 3,
        ),
        Quiz(
            question = R.string.question_sixteenth_century_9,
            rightAnswer = R.string.answer_sixteenth_century_9,
            score = 4,
        ),
        Quiz(
            question = R.string.question_sixteenth_century_10,
            rightAnswer = R.string.answer_sixteenth_century_10,
            score = 4,
        ),
        Quiz(
            question = R.string.question_sixteenth_century_11,
            rightAnswer = R.string.answer_sixteenth_century_11,
            score = 3,
        ),
        Quiz(
            question = R.string.question_sixteenth_century_12,
            rightAnswer = R.string.answer_sixteenth_century_12,
            score = 3,
        ),
        Quiz(
            question = R.string.question_sixteenth_century_13,
            rightAnswer = R.string.answer_sixteenth_century_13,
            score = 5,
        ),
        Quiz(
            question = R.string.question_sixteenth_century_14,
            rightAnswer = R.string.answer_sixteenth_century_14,
            score = 4,
        ),
        Quiz(
            question = R.string.question_sixteenth_century_15,
            rightAnswer = R.string.answer_sixteenth_century_15,
            score = 3,
        ),
        Quiz(
            question = R.string.question_sixteenth_century_16,
            rightAnswer = R.string.answer_sixteenth_century_16,
            score = 4,
        ),
        Quiz(
            question = R.string.question_sixteenth_century_17,
            rightAnswer = R.string.answer_sixteenth_century_17,
            score = 3,
        ),
        Quiz(
            question = R.string.question_sixteenth_century_18,
            rightAnswer = R.string.answer_sixteenth_century_18,
            score = 4,
        ),
        Quiz(
            question = R.string.question_sixteenth_century_19,
            rightAnswer = R.string.answer_sixteenth_century_19,
            score = 4,
        ),
        Quiz(
            question = R.string.question_sixteenth_century_20,
            rightAnswer = R.string.answer_sixteenth_century_20,
            score = 5,
        ),
        Quiz(
            question = R.string.question_sixteenth_century_21,
            rightAnswer = R.string.answer_sixteenth_century_21,
            score = 4,
        ),
        Quiz(
            question = R.string.question_sixteenth_century_22,
            rightAnswer = R.string.answer_sixteenth_century_22,
            score = 3,
        ),
        Quiz(
            question = R.string.question_sixteenth_century_23,
            rightAnswer = R.string.answer_sixteenth_century_23,
            score = 5,
        ),
        Quiz(
            question = R.string.question_sixteenth_century_24,
            rightAnswer = R.string.answer_sixteenth_century_24,
            score = 3,
        ),
        Quiz(
            question = R.string.question_sixteenth_century_25,
            rightAnswer = R.string.answer_sixteenth_century_25,
            score = 4,
        ),
        Quiz(
            question = R.string.question_sixteenth_century_26,
            rightAnswer = R.string.answer_sixteenth_century_26,
            score = 5,
        ),
        Quiz(
            question = R.string.question_sixteenth_century_27,
            rightAnswer = R.string.answer_sixteenth_century_27,
            score = 4,
        ),
        Quiz(
            question = R.string.question_sixteenth_century_28,
            rightAnswer = R.string.answer_sixteenth_century_28,
            score = 3,
        ),
        Quiz(
            question = R.string.question_sixteenth_century_29,
            rightAnswer = R.string.answer_sixteenth_century_29,
            score = 3,
        ),
        Quiz(
            question = R.string.question_sixteenth_century_30,
            rightAnswer = R.string.answer_sixteenth_century_30,
            score = 4,
        ),
        Quiz(
            question = R.string.question_sixteenth_century_31,
            rightAnswer = R.string.answer_sixteenth_century_31,
            score = 4,
        ),
        Quiz(
            question = R.string.question_sixteenth_century_32,
            rightAnswer = R.string.answer_sixteenth_century_32,
            score = 5,
        ),
        Quiz(
            question = R.string.question_sixteenth_century_33,
            rightAnswer = R.string.answer_sixteenth_century_33,
            score = 4,
        ),
        Quiz(
            question = R.string.question_sixteenth_century_34,
            rightAnswer = R.string.answer_sixteenth_century_34,
            score = 3,
        ),
        Quiz(
            question = R.string.question_sixteenth_century_35,
            rightAnswer = R.string.answer_sixteenth_century_35,
            score = 3,
        ),
        Quiz(
            question = R.string.question_sixteenth_century_36,
            rightAnswer = R.string.answer_sixteenth_century_36,
            score = 3,
        ),
        Quiz(
            question = R.string.question_sixteenth_century_37,
            rightAnswer = R.string.answer_sixteenth_century_37,
            score = 4,
        ),
        Quiz(
            question = R.string.question_sixteenth_century_38,
            rightAnswer = R.string.answer_sixteenth_century_38,
            score = 4,
        ),
        Quiz(
            question = R.string.question_sixteenth_century_39,
            rightAnswer = R.string.answer_sixteenth_century_39,
            score = 4,
        ),
        Quiz(
            question = R.string.question_sixteenth_century_40,
            rightAnswer = R.string.answer_sixteenth_century_40,
            score = 3,
        ),
        Quiz(
            question = R.string.question_sixteenth_century_41,
            rightAnswer = R.string.answer_sixteenth_century_41,
            score = 4,
        ),
        Quiz(
            question = R.string.question_sixteenth_century_42,
            rightAnswer = R.string.answer_sixteenth_century_42,
            score = 3,
        ),
        Quiz(
            question = R.string.question_sixteenth_century_43,
            rightAnswer = R.string.answer_sixteenth_century_43,
            score = 5,
        ),
        Quiz(
            question = R.string.question_sixteenth_century_44,
            rightAnswer = R.string.answer_sixteenth_century_44,
            score = 4,
        ),
        Quiz(
            question = R.string.question_sixteenth_century_45,
            rightAnswer = R.string.answer_sixteenth_century_45,
            score = 5,
        ),
        Quiz(
            question = R.string.question_sixteenth_century_46,
            rightAnswer = R.string.answer_sixteenth_century_46,
            score = 4,
        ),
        Quiz(
            question = R.string.question_sixteenth_century_47,
            rightAnswer = R.string.answer_sixteenth_century_47,
            score = 3,
        ),
        Quiz(
            question = R.string.question_sixteenth_century_48,
            rightAnswer = R.string.answer_sixteenth_century_48,
            score = 4,
        ),
        Quiz(
            question = R.string.question_sixteenth_century_49,
            rightAnswer = R.string.answer_sixteenth_century_49,
            score = 4,
        ),
        Quiz(
            question = R.string.question_sixteenth_century_50,
            rightAnswer = R.string.answer_sixteenth_century_50,
            score = 4,
        )
    )
    val quizzes_seventeenth_century = listOf(
        Quiz(
            question = R.string.question_seventeenth_century_1,
            rightAnswer = R.string.answer_seventeenth_century_1,
            score = 4,
        ),
        Quiz(
            question = R.string.question_seventeenth_century_2,
            rightAnswer = R.string.answer_seventeenth_century_2,
            score = 3,
        ),
        Quiz(
            question = R.string.question_seventeenth_century_3,
            rightAnswer = R.string.answer_seventeenth_century_3,
            score = 3,
        ),
        Quiz(
            question = R.string.question_seventeenth_century_4,
            rightAnswer = R.string.answer_seventeenth_century_4,
            score = 3,
        ),
        Quiz(
            question = R.string.question_seventeenth_century_5,
            rightAnswer = R.string.answer_seventeenth_century_5,
            score = 4,
        ),
        Quiz(
            question = R.string.question_seventeenth_century_6,
            rightAnswer = R.string.answer_seventeenth_century_6,
            score = 4,
        ),
        Quiz(
            question = R.string.question_seventeenth_century_7,
            rightAnswer = R.string.answer_seventeenth_century_7,
            score = 3,
        ),
        Quiz(
            question = R.string.question_seventeenth_century_8,
            rightAnswer = R.string.answer_seventeenth_century_8,
            score = 4,
        ),
        Quiz(
            question = R.string.question_seventeenth_century_9,
            rightAnswer = R.string.answer_seventeenth_century_9,
            score = 3,
        ),
        Quiz(
            question = R.string.question_seventeenth_century_10,
            rightAnswer = R.string.answer_seventeenth_century_10,
            score = 3,
        ),
        Quiz(
            question = R.string.question_seventeenth_century_11,
            rightAnswer = R.string.answer_seventeenth_century_11,
            score = 3,
        ),
        Quiz(
            question = R.string.question_seventeenth_century_12,
            rightAnswer = R.string.answer_seventeenth_century_12,
            score = 3,
        ),
        Quiz(
            question = R.string.question_seventeenth_century_13,
            rightAnswer = R.string.answer_seventeenth_century_13,
            score = 4,
        ),
        Quiz(
            question = R.string.question_seventeenth_century_14,
            rightAnswer = R.string.answer_seventeenth_century_14,
            score = 3,
        ),
        Quiz(
            question = R.string.question_seventeenth_century_15,
            rightAnswer = R.string.answer_seventeenth_century_15,
            score = 4,
        ),
        Quiz(
            question = R.string.question_seventeenth_century_16,
            rightAnswer = R.string.answer_seventeenth_century_16,
            score = 3,
        ),
        Quiz(
            question = R.string.question_seventeenth_century_17,
            rightAnswer = R.string.answer_seventeenth_century_17,
            score = 3,
        ),
        Quiz(
            question = R.string.question_seventeenth_century_18,
            rightAnswer = R.string.answer_seventeenth_century_18,
            score = 3,
        ),
        Quiz(
            question = R.string.question_seventeenth_century_19,
            rightAnswer = R.string.answer_seventeenth_century_19,
            score = 4,
        ),
        Quiz(
            question = R.string.question_seventeenth_century_20,
            rightAnswer = R.string.answer_seventeenth_century_20,
            score = 4,
        ),
        Quiz(
            question = R.string.question_seventeenth_century_21,
            rightAnswer = R.string.answer_seventeenth_century_21,
            score = 3,
        ),
        Quiz(
            question = R.string.question_seventeenth_century_22,
            rightAnswer = R.string.answer_seventeenth_century_22,
            score = 3,
        ),
        Quiz(
            question = R.string.question_seventeenth_century_23,
            rightAnswer = R.string.answer_seventeenth_century_23,
            score = 3,
        ),
        Quiz(
            question = R.string.question_seventeenth_century_24,
            rightAnswer = R.string.answer_seventeenth_century_24,
            score = 3,
        ),
        Quiz(
            question = R.string.question_seventeenth_century_25,
            rightAnswer = R.string.answer_seventeenth_century_25,
            score = 3,
        ),
        Quiz(
            question = R.string.question_seventeenth_century_26,
            rightAnswer = R.string.answer_seventeenth_century_26,
            score = 4,
        ),
        Quiz(
            question = R.string.question_seventeenth_century_27,
            rightAnswer = R.string.answer_seventeenth_century_27,
            score = 3,
        ),
        Quiz(
            question = R.string.question_seventeenth_century_28,
            rightAnswer = R.string.answer_seventeenth_century_28,
            score = 3,
        ),
        Quiz(
            question = R.string.question_seventeenth_century_29,
            rightAnswer = R.string.answer_seventeenth_century_29,
            score = 4,
        ),
        Quiz(
            question = R.string.question_seventeenth_century_30,
            rightAnswer = R.string.answer_seventeenth_century_30,
            score = 4,
        ),
        Quiz(
            question = R.string.question_seventeenth_century_31,
            rightAnswer = R.string.answer_seventeenth_century_31,
            score = 3,
        ),
        Quiz(
            question = R.string.question_seventeenth_century_32,
            rightAnswer = R.string.answer_seventeenth_century_32,
            score = 4,
        ),
        Quiz(
            question = R.string.question_seventeenth_century_33,
            rightAnswer = R.string.answer_seventeenth_century_33,
            score = 3,
        ),
        Quiz(
            question = R.string.question_seventeenth_century_34,
            rightAnswer = R.string.answer_seventeenth_century_34,
            score = 4,
        ),
        Quiz(
            question = R.string.question_seventeenth_century_35,
            rightAnswer = R.string.answer_seventeenth_century_35,
            score = 4,
        ),
        Quiz(
            question = R.string.question_seventeenth_century_36,
            rightAnswer = R.string.answer_seventeenth_century_36,
            score = 4,
        ),
        Quiz(
            question = R.string.question_seventeenth_century_37,
            rightAnswer = R.string.answer_seventeenth_century_37,
            score = 4,
        ),
        Quiz(
            question = R.string.question_seventeenth_century_38,
            rightAnswer = R.string.answer_seventeenth_century_38,
            score = 4,
        ),
        Quiz(
            question = R.string.question_seventeenth_century_39,
            rightAnswer = R.string.answer_seventeenth_century_39,
            score = 4,
        ),
        Quiz(
            question = R.string.question_seventeenth_century_40,
            rightAnswer = R.string.answer_seventeenth_century_40,
            score = 3,
        ),
        Quiz(
            question = R.string.question_seventeenth_century_41,
            rightAnswer = R.string.answer_seventeenth_century_41,
            score = 3,
        ),
        Quiz(
            question = R.string.question_seventeenth_century_42,
            rightAnswer = R.string.answer_seventeenth_century_42,
            score = 3,
        ),
        Quiz(
            question = R.string.question_seventeenth_century_43,
            rightAnswer = R.string.answer_seventeenth_century_43,
            score = 3,
        ),
        Quiz(
            question = R.string.question_seventeenth_century_44,
            rightAnswer = R.string.answer_seventeenth_century_44,
            score = 3,
        ),
        Quiz(
            question = R.string.question_seventeenth_century_45,
            rightAnswer = R.string.answer_seventeenth_century_45,
            score = 3,
        ),
        Quiz(
            question = R.string.question_seventeenth_century_46,
            rightAnswer = R.string.answer_seventeenth_century_46,
            score = 4,
        ),
        Quiz(
            question = R.string.question_seventeenth_century_47,
            rightAnswer = R.string.answer_seventeenth_century_47,
            score = 4,
        ),
        Quiz(
            question = R.string.question_seventeenth_century_48,
            rightAnswer = R.string.answer_seventeenth_century_48,
            score = 3,
        ),
        Quiz(
            question = R.string.question_seventeenth_century_49,
            rightAnswer = R.string.answer_seventeenth_century_49,
            score = 3,
        ),
        Quiz(
            question = R.string.question_seventeenth_century_50,
            rightAnswer = R.string.answer_seventeenth_century_50,
            score = 3,
        )
    )
    val quizzes_eighteenth_century = listOf(
        Quiz(
            question = R.string.question_eighteenth_century_1,
            rightAnswer = R.string.answer_eighteenth_century_1,
            score = 4,
        ),
        Quiz(
            question = R.string.question_eighteenth_century_2,
            rightAnswer = R.string.answer_eighteenth_century_2,
            score = 3,
        ),
        Quiz(
            question = R.string.question_eighteenth_century_3,
            rightAnswer = R.string.answer_eighteenth_century_3,
            score = 3,
        ),
        Quiz(
            question = R.string.question_eighteenth_century_4,
            rightAnswer = R.string.answer_eighteenth_century_4,
            score = 4,
        ),
        Quiz(
            question = R.string.question_eighteenth_century_5,
            rightAnswer = R.string.answer_eighteenth_century_5,
            score = 5,
        ),
        Quiz(
            question = R.string.question_eighteenth_century_6,
            rightAnswer = R.string.answer_eighteenth_century_6,
            score = 4,
        ),
        Quiz(
            question = R.string.question_eighteenth_century_7,
            rightAnswer = R.string.answer_eighteenth_century_7,
            score = 3,
        ),
        Quiz(
            question = R.string.question_eighteenth_century_8,
            rightAnswer = R.string.answer_eighteenth_century_8,
            score = 3,
        ),
        Quiz(
            question = R.string.question_eighteenth_century_9,
            rightAnswer = R.string.answer_eighteenth_century_9,
            score = 3,
        ),
        Quiz(
            question = R.string.question_eighteenth_century_10,
            rightAnswer = R.string.answer_eighteenth_century_10,
            score = 3,
        ),
        Quiz(
            question = R.string.question_eighteenth_century_11,
            rightAnswer = R.string.answer_eighteenth_century_11,
            score = 5,
        ),
        Quiz(
            question = R.string.question_eighteenth_century_12,
            rightAnswer = R.string.answer_eighteenth_century_12,
            score = 4,
        ),
        Quiz(
            question = R.string.question_eighteenth_century_13,
            rightAnswer = R.string.answer_eighteenth_century_13,
            score = 3,
        ),
        Quiz(
            question = R.string.question_eighteenth_century_14,
            rightAnswer = R.string.answer_eighteenth_century_14,
            score = 3,
        ),
        Quiz(
            question = R.string.question_eighteenth_century_15,
            rightAnswer = R.string.answer_eighteenth_century_15,
            score = 2,
        ),
        Quiz(
            question = R.string.question_eighteenth_century_16,
            rightAnswer = R.string.answer_eighteenth_century_16,
            score = 4,
        ),
        Quiz(
            question = R.string.question_eighteenth_century_17,
            rightAnswer = R.string.answer_eighteenth_century_17,
            score = 5,
        ),
        Quiz(
            question = R.string.question_eighteenth_century_18,
            rightAnswer = R.string.answer_eighteenth_century_18,
            score = 4,
        ),
        Quiz(
            question = R.string.question_eighteenth_century_19,
            rightAnswer = R.string.answer_eighteenth_century_19,
            score = 3,
        ),
        Quiz(
            question = R.string.question_eighteenth_century_20,
            rightAnswer = R.string.answer_eighteenth_century_20,
            score = 5,
        ),
        Quiz(
            question = R.string.question_eighteenth_century_21,
            rightAnswer = R.string.answer_eighteenth_century_21,
            score = 4,
        ),
        Quiz(
            question = R.string.question_eighteenth_century_22,
            rightAnswer = R.string.answer_eighteenth_century_22,
            score = 5,
        ),
        Quiz(
            question = R.string.question_eighteenth_century_23,
            rightAnswer = R.string.answer_eighteenth_century_23,
            score = 3,
        ),
        Quiz(
            question = R.string.question_eighteenth_century_24,
            rightAnswer = R.string.answer_eighteenth_century_24,
            score = 4,
        ),
        Quiz(
            question = R.string.question_eighteenth_century_25,
            rightAnswer = R.string.answer_eighteenth_century_25,
            score = 4,
        ),
        Quiz(
            question = R.string.question_eighteenth_century_26,
            rightAnswer = R.string.answer_eighteenth_century_26,
            score = 3,
        ),
        Quiz(
            question = R.string.question_eighteenth_century_27,
            rightAnswer = R.string.answer_eighteenth_century_27,
            score = 4,
        ),
        Quiz(
            question = R.string.question_eighteenth_century_28,
            rightAnswer = R.string.answer_eighteenth_century_28,
            score = 4,
        ),
        Quiz(
            question = R.string.question_eighteenth_century_29,
            rightAnswer = R.string.answer_eighteenth_century_29,
            score = 3,
        ),
        Quiz(
            question = R.string.question_eighteenth_century_30,
            rightAnswer = R.string.answer_eighteenth_century_30,
            score = 4,
        ),
        Quiz(
            question = R.string.question_eighteenth_century_31,
            rightAnswer = R.string.answer_eighteenth_century_31,
            score = 3,
        ),
        Quiz(
            question = R.string.question_eighteenth_century_32,
            rightAnswer = R.string.answer_eighteenth_century_32,
            score = 4,
        ),
        Quiz(
            question = R.string.question_eighteenth_century_33,
            rightAnswer = R.string.answer_eighteenth_century_33,
            score = 4,
        ),
        Quiz(
            question = R.string.question_eighteenth_century_34,
            rightAnswer = R.string.answer_eighteenth_century_34,
            score = 4,
        ),
        Quiz(
            question = R.string.question_eighteenth_century_35,
            rightAnswer = R.string.answer_eighteenth_century_35,
            score = 3,
        ),
        Quiz(
            question = R.string.question_eighteenth_century_36,
            rightAnswer = R.string.answer_eighteenth_century_36,
            score = 5,
        ),
        Quiz(
            question = R.string.question_eighteenth_century_37,
            rightAnswer = R.string.answer_eighteenth_century_37,
            score = 3,
        ),
        Quiz(
            question = R.string.question_eighteenth_century_38,
            rightAnswer = R.string.answer_eighteenth_century_38,
            score = 3,
        ),
        Quiz(
            question = R.string.question_eighteenth_century_39,
            rightAnswer = R.string.answer_eighteenth_century_39,
            score = 2,
        ),
        Quiz(
            question = R.string.question_eighteenth_century_40,
            rightAnswer = R.string.answer_eighteenth_century_40,
            score = 5,
        ),
        Quiz(
            question = R.string.question_eighteenth_century_41,
            rightAnswer = R.string.answer_eighteenth_century_41,
            score = 3,
        ),
        Quiz(
            question = R.string.question_eighteenth_century_42,
            rightAnswer = R.string.answer_eighteenth_century_42,
            score = 3,
        ),
        Quiz(
            question = R.string.question_eighteenth_century_43,
            rightAnswer = R.string.answer_eighteenth_century_43,
            score = 4,
        ),
        Quiz(
            question = R.string.question_eighteenth_century_44,
            rightAnswer = R.string.answer_eighteenth_century_44,
            score = 3,
        ),
        Quiz(
            question = R.string.question_eighteenth_century_45,
            rightAnswer = R.string.answer_eighteenth_century_45,
            score = 4,
        ),
        Quiz(
            question = R.string.question_eighteenth_century_46,
            rightAnswer = R.string.answer_eighteenth_century_46,
            score = 3,
        ),
        Quiz(
            question = R.string.question_eighteenth_century_47,
            rightAnswer = R.string.answer_eighteenth_century_47,
            score = 3,
        ),
        Quiz(
            question = R.string.question_eighteenth_century_48,
            rightAnswer = R.string.answer_eighteenth_century_48,
            score = 4,
        ),
        Quiz(
            question = R.string.question_eighteenth_century_49,
            rightAnswer = R.string.answer_eighteenth_century_49,
            score = 4,
        ),
        Quiz(
            question = R.string.question_eighteenth_century_50,
            rightAnswer = R.string.answer_eighteenth_century_50,
            score = 3,
        )
    )
    val quizzes_nineteenth_century = listOf(
        Quiz(
            question = R.string.question_nineteenth_century_1,
            rightAnswer = R.string.answer_nineteenth_century_1,
            score = 3,
        ),
        Quiz(
            question = R.string.question_nineteenth_century_2,
            rightAnswer = R.string.answer_nineteenth_century_2,
            score = 3,
        ),
        Quiz(
            question = R.string.question_nineteenth_century_3,
            rightAnswer = R.string.answer_nineteenth_century_3,
            score = 4,
        ),
        Quiz(
            question = R.string.question_nineteenth_century_4,
            rightAnswer = R.string.answer_nineteenth_century_4,
            score = 4,
        ),
        Quiz(
            question = R.string.question_nineteenth_century_5,
            rightAnswer = R.string.answer_nineteenth_century_5,
            score = 3,
        ),
        Quiz(
            question = R.string.question_nineteenth_century_6,
            rightAnswer = R.string.answer_nineteenth_century_6,
            score = 4,
        ),
        Quiz(
            question = R.string.question_nineteenth_century_7,
            rightAnswer = R.string.answer_nineteenth_century_7,
            score = 3,
        ),
        Quiz(
            question = R.string.question_nineteenth_century_8,
            rightAnswer = R.string.answer_nineteenth_century_8,
            score = 3,
        ),
        Quiz(
            question = R.string.question_nineteenth_century_9,
            rightAnswer = R.string.answer_nineteenth_century_9,
            score = 2,
        ),
        Quiz(
            question = R.string.question_nineteenth_century_10,
            rightAnswer = R.string.answer_nineteenth_century_10,
            score = 5,
        ),
        Quiz(
            question = R.string.question_nineteenth_century_11,
            rightAnswer = R.string.answer_nineteenth_century_11,
            score = 3,
        ),
        Quiz(
            question = R.string.question_nineteenth_century_12,
            rightAnswer = R.string.answer_nineteenth_century_12,
            score = 4,
        ),
        Quiz(
            question = R.string.question_nineteenth_century_13,
            rightAnswer = R.string.answer_nineteenth_century_13,
            score = 4,
        ),
        Quiz(
            question = R.string.question_nineteenth_century_14,
            rightAnswer = R.string.answer_nineteenth_century_14,
            score = 4,
        ),
        Quiz(
            question = R.string.question_nineteenth_century_15,
            rightAnswer = R.string.answer_nineteenth_century_15,
            score = 3,
        ),
        Quiz(
            question = R.string.question_nineteenth_century_16,
            rightAnswer = R.string.answer_nineteenth_century_16,
            score = 3,
        ),
        Quiz(
            question = R.string.question_nineteenth_century_17,
            rightAnswer = R.string.answer_nineteenth_century_17,
            score = 5,
        ),
        Quiz(
            question = R.string.question_nineteenth_century_18,
            rightAnswer = R.string.answer_nineteenth_century_18,
            score = 4,
        ),
        Quiz(
            question = R.string.question_nineteenth_century_19,
            rightAnswer = R.string.answer_nineteenth_century_19,
            score = 4,
        ),
        Quiz(
            question = R.string.question_nineteenth_century_20,
            rightAnswer = R.string.answer_nineteenth_century_20,
            score = 5,
        ),
        Quiz(
            question = R.string.question_nineteenth_century_21,
            rightAnswer = R.string.answer_nineteenth_century_21,
            score = 3,
        ),
        Quiz(
            question = R.string.question_nineteenth_century_22,
            rightAnswer = R.string.answer_nineteenth_century_22,
            score = 3,
        ),
        Quiz(
            question = R.string.question_nineteenth_century_23,
            rightAnswer = R.string.answer_nineteenth_century_23,
            score = 3,
        ),
        Quiz(
            question = R.string.question_nineteenth_century_24,
            rightAnswer = R.string.answer_nineteenth_century_24,
            score = 4,
        ),
        Quiz(
            question = R.string.question_nineteenth_century_25,
            rightAnswer = R.string.answer_nineteenth_century_25,
            score = 4,
        ),
        Quiz(
            question = R.string.question_nineteenth_century_26,
            rightAnswer = R.string.answer_nineteenth_century_26,
            score = 4,
        ),
        Quiz(
            question = R.string.question_nineteenth_century_27,
            rightAnswer = R.string.answer_nineteenth_century_27,
            score = 5,
        ),
        Quiz(
            question = R.string.question_nineteenth_century_28,
            rightAnswer = R.string.answer_nineteenth_century_28,
            score = 3,
        ),
        Quiz(
            question = R.string.question_nineteenth_century_29,
            rightAnswer = R.string.answer_nineteenth_century_29,
            score = 3,
        ),
        Quiz(
            question = R.string.question_nineteenth_century_30,
            rightAnswer = R.string.answer_nineteenth_century_30,
            score = 4,
        ),
        Quiz(
            question = R.string.question_nineteenth_century_31,
            rightAnswer = R.string.answer_nineteenth_century_31,
            score = 4,
        ),
        Quiz(
            question = R.string.question_nineteenth_century_32,
            rightAnswer = R.string.answer_nineteenth_century_32,
            score = 3,
        ),
        Quiz(
            question = R.string.question_nineteenth_century_33,
            rightAnswer = R.string.answer_nineteenth_century_33,
            score = 3,
        ),
        Quiz(
            question = R.string.question_nineteenth_century_34,
            rightAnswer = R.string.answer_nineteenth_century_34,
            score = 4,
        ),
        Quiz(
            question = R.string.question_nineteenth_century_35,
            rightAnswer = R.string.answer_nineteenth_century_35,
            score = 4,
        ),
        Quiz(
            question = R.string.question_nineteenth_century_36,
            rightAnswer = R.string.answer_nineteenth_century_36,
            score = 3,
        ),
        Quiz(
            question = R.string.question_nineteenth_century_37,
            rightAnswer = R.string.answer_nineteenth_century_37,
            score = 4,
        ),
        Quiz(
            question = R.string.question_nineteenth_century_38,
            rightAnswer = R.string.answer_nineteenth_century_38,
            score = 3,
        ),
        Quiz(
            question = R.string.question_nineteenth_century_39,
            rightAnswer = R.string.answer_nineteenth_century_39,
            score = 4,
        ),
        Quiz(
            question = R.string.question_nineteenth_century_40,
            rightAnswer = R.string.answer_nineteenth_century_40,
            score = 5,
        ),
        Quiz(
            question = R.string.question_nineteenth_century_41,
            rightAnswer = R.string.answer_nineteenth_century_41,
            score = 3,
        ),
        Quiz(
            question = R.string.question_nineteenth_century_42,
            rightAnswer = R.string.answer_nineteenth_century_42,
            score = 4,
        ),
        Quiz(
            question = R.string.question_nineteenth_century_43,
            rightAnswer = R.string.answer_nineteenth_century_43,
            score = 4,
        ),
        Quiz(
            question = R.string.question_nineteenth_century_44,
            rightAnswer = R.string.answer_nineteenth_century_44,
            score = 4,
        ),
        Quiz(
            question = R.string.question_nineteenth_century_45,
            rightAnswer = R.string.answer_nineteenth_century_45,
            score = 4,
        ),
        Quiz(
            question = R.string.question_nineteenth_century_46,
            rightAnswer = R.string.answer_nineteenth_century_46,
            score = 3,
        ),
        Quiz(
            question = R.string.question_nineteenth_century_47,
            rightAnswer = R.string.answer_nineteenth_century_47,
            score = 5,
        ),
        Quiz(
            question = R.string.question_nineteenth_century_48,
            rightAnswer = R.string.answer_nineteenth_century_48,
            score = 3,
        ),
        Quiz(
            question = R.string.question_nineteenth_century_49,
            rightAnswer = R.string.answer_nineteenth_century_49,
            score = 4,
        ),
        Quiz(
            question = R.string.question_nineteenth_century_50,
            rightAnswer = R.string.answer_nineteenth_century_50,
            score = 5,
        )
    )
    val quizzes_twentieth_century = listOf(
        Quiz(
            question = R.string.question_twentieth_century_1,
            rightAnswer = R.string.answer_twentieth_century_1,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twentieth_century_2,
            rightAnswer = R.string.answer_twentieth_century_2,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twentieth_century_3,
            rightAnswer = R.string.answer_twentieth_century_3,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twentieth_century_4,
            rightAnswer = R.string.answer_twentieth_century_4,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twentieth_century_5,
            rightAnswer = R.string.answer_twentieth_century_5,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twentieth_century_6,
            rightAnswer = R.string.answer_twentieth_century_6,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twentieth_century_7,
            rightAnswer = R.string.answer_twentieth_century_7,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twentieth_century_8,
            rightAnswer = R.string.answer_twentieth_century_8,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twentieth_century_9,
            rightAnswer = R.string.answer_twentieth_century_9,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twentieth_century_10,
            rightAnswer = R.string.answer_twentieth_century_10,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twentieth_century_11,
            rightAnswer = R.string.answer_twentieth_century_11,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twentieth_century_12,
            rightAnswer = R.string.answer_twentieth_century_12,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twentieth_century_13,
            rightAnswer = R.string.answer_twentieth_century_13,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twentieth_century_14,
            rightAnswer = R.string.answer_twentieth_century_14,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twentieth_century_15,
            rightAnswer = R.string.answer_twentieth_century_15,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twentieth_century_16,
            rightAnswer = R.string.answer_twentieth_century_16,
            score = 5,
        ),
        Quiz(
            question = R.string.question_twentieth_century_17,
            rightAnswer = R.string.answer_twentieth_century_17,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twentieth_century_18,
            rightAnswer = R.string.answer_twentieth_century_18,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twentieth_century_19,
            rightAnswer = R.string.answer_twentieth_century_19,
            score = 5,
        ),
        Quiz(
            question = R.string.question_twentieth_century_20,
            rightAnswer = R.string.answer_twentieth_century_20,
            score = 5,
        ),
        Quiz(
            question = R.string.question_twentieth_century_21,
            rightAnswer = R.string.answer_twentieth_century_21,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twentieth_century_22,
            rightAnswer = R.string.answer_twentieth_century_22,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twentieth_century_23,
            rightAnswer = R.string.answer_twentieth_century_23,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twentieth_century_24,
            rightAnswer = R.string.answer_twentieth_century_24,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twentieth_century_25,
            rightAnswer = R.string.answer_twentieth_century_25,
            score = 5,
        ),
        Quiz(
            question = R.string.question_twentieth_century_26,
            rightAnswer = R.string.answer_twentieth_century_26,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twentieth_century_27,
            rightAnswer = R.string.answer_twentieth_century_27,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twentieth_century_28,
            rightAnswer = R.string.answer_twentieth_century_28,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twentieth_century_29,
            rightAnswer = R.string.answer_twentieth_century_29,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twentieth_century_30,
            rightAnswer = R.string.answer_twentieth_century_30,
            score = 5,
        ),
        Quiz(
            question = R.string.question_twentieth_century_31,
            rightAnswer = R.string.answer_twentieth_century_31,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twentieth_century_32,
            rightAnswer = R.string.answer_twentieth_century_32,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twentieth_century_33,
            rightAnswer = R.string.answer_twentieth_century_33,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twentieth_century_34,
            rightAnswer = R.string.answer_twentieth_century_34,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twentieth_century_35,
            rightAnswer = R.string.answer_twentieth_century_35,
            score = 5,
        ),
        Quiz(
            question = R.string.question_twentieth_century_36,
            rightAnswer = R.string.answer_twentieth_century_36,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twentieth_century_37,
            rightAnswer = R.string.answer_twentieth_century_37,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twentieth_century_38,
            rightAnswer = R.string.answer_twentieth_century_38,
            score = 5,
        ),
        Quiz(
            question = R.string.question_twentieth_century_39,
            rightAnswer = R.string.answer_twentieth_century_39,
            score = 5,
        ),
        Quiz(
            question = R.string.question_twentieth_century_40,
            rightAnswer = R.string.answer_twentieth_century_40,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twentieth_century_41,
            rightAnswer = R.string.answer_twentieth_century_41,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twentieth_century_42,
            rightAnswer = R.string.answer_twentieth_century_42,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twentieth_century_43,
            rightAnswer = R.string.answer_twentieth_century_43,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twentieth_century_44,
            rightAnswer = R.string.answer_twentieth_century_44,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twentieth_century_45,
            rightAnswer = R.string.answer_twentieth_century_45,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twentieth_century_46,
            rightAnswer = R.string.answer_twentieth_century_46,
            score = 5,
        ),
        Quiz(
            question = R.string.question_twentieth_century_47,
            rightAnswer = R.string.answer_twentieth_century_47,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twentieth_century_48,
            rightAnswer = R.string.answer_twentieth_century_48,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twentieth_century_49,
            rightAnswer = R.string.answer_twentieth_century_49,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twentieth_century_50,
            rightAnswer = R.string.answer_twentieth_century_50,
            score = 4,
        )
    )
    val quizzes_twenty_first_century = listOf(
        Quiz(
            question = R.string.question_twenty_first_century_1,
            rightAnswer = R.string.answer_twenty_first_century_1,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twenty_first_century_2,
            rightAnswer = R.string.answer_twenty_first_century_2,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twenty_first_century_3,
            rightAnswer = R.string.answer_twenty_first_century_3,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twenty_first_century_4,
            rightAnswer = R.string.answer_twenty_first_century_4,
            score = 5,
        ),
        Quiz(
            question = R.string.question_twenty_first_century_5,
            rightAnswer = R.string.answer_twenty_first_century_5,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twenty_first_century_6,
            rightAnswer = R.string.answer_twenty_first_century_6,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twenty_first_century_7,
            rightAnswer = R.string.answer_twenty_first_century_7,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twenty_first_century_8,
            rightAnswer = R.string.answer_twenty_first_century_8,
            score = 2,
        ),
        Quiz(
            question = R.string.question_twenty_first_century_9,
            rightAnswer = R.string.answer_twenty_first_century_9,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twenty_first_century_10,
            rightAnswer = R.string.answer_twenty_first_century_10,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twenty_first_century_11,
            rightAnswer = R.string.answer_twenty_first_century_11,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twenty_first_century_12,
            rightAnswer = R.string.answer_twenty_first_century_12,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twenty_first_century_13,
            rightAnswer = R.string.answer_twenty_first_century_13,
            score = 5,
        ),
        Quiz(
            question = R.string.question_twenty_first_century_14,
            rightAnswer = R.string.answer_twenty_first_century_14,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twenty_first_century_15,
            rightAnswer = R.string.answer_twenty_first_century_15,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twenty_first_century_16,
            rightAnswer = R.string.answer_twenty_first_century_16,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twenty_first_century_17,
            rightAnswer = R.string.answer_twenty_first_century_17,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twenty_first_century_18,
            rightAnswer = R.string.answer_twenty_first_century_18,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twenty_first_century_19,
            rightAnswer = R.string.answer_twenty_first_century_19,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twenty_first_century_20,
            rightAnswer = R.string.answer_twenty_first_century_20,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twenty_first_century_21,
            rightAnswer = R.string.answer_twenty_first_century_21,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twenty_first_century_22,
            rightAnswer = R.string.answer_twenty_first_century_22,
            score = 5,
        ),
        Quiz(
            question = R.string.question_twenty_first_century_23,
            rightAnswer = R.string.answer_twenty_first_century_23,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twenty_first_century_24,
            rightAnswer = R.string.answer_twenty_first_century_24,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twenty_first_century_25,
            rightAnswer = R.string.answer_twenty_first_century_25,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twenty_first_century_26,
            rightAnswer = R.string.answer_twenty_first_century_26,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twenty_first_century_27,
            rightAnswer = R.string.answer_twenty_first_century_27,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twenty_first_century_28,
            rightAnswer = R.string.answer_twenty_first_century_28,
            score = 5,
        ),
        Quiz(
            question = R.string.question_twenty_first_century_29,
            rightAnswer = R.string.answer_twenty_first_century_29,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twenty_first_century_30,
            rightAnswer = R.string.answer_twenty_first_century_30,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twenty_first_century_31,
            rightAnswer = R.string.answer_twenty_first_century_31,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twenty_first_century_32,
            rightAnswer = R.string.answer_twenty_first_century_32,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twenty_first_century_33,
            rightAnswer = R.string.answer_twenty_first_century_33,
            score = 5,
        ),
        Quiz(
            question = R.string.question_twenty_first_century_34,
            rightAnswer = R.string.answer_twenty_first_century_34,
            score = 2,
        ),
        Quiz(
            question = R.string.question_twenty_first_century_35,
            rightAnswer = R.string.answer_twenty_first_century_35,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twenty_first_century_36,
            rightAnswer = R.string.answer_twenty_first_century_36,
            score = 5,
        ),
        Quiz(
            question = R.string.question_twenty_first_century_37,
            rightAnswer = R.string.answer_twenty_first_century_37,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twenty_first_century_38,
            rightAnswer = R.string.answer_twenty_first_century_38,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twenty_first_century_39,
            rightAnswer = R.string.answer_twenty_first_century_39,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twenty_first_century_40,
            rightAnswer = R.string.answer_twenty_first_century_40,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twenty_first_century_41,
            rightAnswer = R.string.answer_twenty_first_century_41,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twenty_first_century_42,
            rightAnswer = R.string.answer_twenty_first_century_42,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twenty_first_century_43,
            rightAnswer = R.string.answer_twenty_first_century_43,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twenty_first_century_44,
            rightAnswer = R.string.answer_twenty_first_century_44,
            score = 5,
        ),
        Quiz(
            question = R.string.question_twenty_first_century_45,
            rightAnswer = R.string.answer_twenty_first_century_45,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twenty_first_century_46,
            rightAnswer = R.string.answer_twenty_first_century_46,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twenty_first_century_47,
            rightAnswer = R.string.answer_twenty_first_century_47,
            score = 3,
        ),
        Quiz(
            question = R.string.question_twenty_first_century_48,
            rightAnswer = R.string.answer_twenty_first_century_48,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twenty_first_century_49,
            rightAnswer = R.string.answer_twenty_first_century_49,
            score = 4,
        ),
        Quiz(
            question = R.string.question_twenty_first_century_50,
            rightAnswer = R.string.answer_twenty_first_century_50,
            score = 5,
        )
    )
}
