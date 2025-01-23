package com.example.russianquiz.model

import androidx.annotation.ArrayRes
import androidx.annotation.StringRes
import com.example.russianquiz.R

data class Quiz(
    @StringRes val question: Int,
    @ArrayRes val options: Int,
    @StringRes val explanation: Int,
    val rightAnswer: Int,
)

object Quizzes {
    val firstLevelQuizzes = listOf(
        Quiz(
            question = R.string.question_vocabulary_1,
            rightAnswer = R.string.answer_vocabulary_1_3,
            options = R.array.quiz_options_vocabulary_1,
            explanation = R.string.explanation_vocabulary_1,
        ),
        Quiz(
            question = R.string.question_grammar_10,
            options = R.array.options_grammar_10,
            explanation = R.string.explanation_grammar_10,
            rightAnswer = R.string.all_correct,
        ),
        Quiz(
            question = R.string.question_grammar_15,
            options = R.array.options_grammar_15,
            explanation = R.string.explanation_grammar_15,
            rightAnswer = R.string.answer_grammar_15_3,
        ),
        Quiz(
            question = R.string.question_pronunciation_1,
            options = R.array.options_pronunciation_1,
            explanation = -1,
            rightAnswer = R.string.answer_pronunciation_1_3,
        ),
        Quiz(
            question = R.string.question_pronunciation_2,
            options = R.array.options_pronunciation_2,
            explanation = -1,
            rightAnswer = R.string.answer_pronunciation_2_1,
        ),
        Quiz(
            question = R.string.question_prepositions_6,
            options = R.array.options_prepositions_6,
            explanation = R.string.explanation_prepositions_6,
            rightAnswer = R.string.answer_prepositions_6_1,
        ),
        Quiz(
            question = R.string.question_tenses_1,
            options = R.array.options_tenses_1,
            explanation = R.string.explanation_tenses_1,
            rightAnswer = R.string.answer_tenses_1_1,
        ),
        Quiz(
            question = R.string.question_tenses_3,
            options = R.array.options_tenses_3,
            explanation = R.string.explanation_tenses_3,
            rightAnswer = R.string.answer_tenses_3_2,
        ),
        Quiz(
            question = R.string.question_verb_forms_1,
            options = R.array.options_verb_forms_1,
            explanation = R.string.explanation_verb_forms_1,
            rightAnswer = R.string.answer_verb_forms_1_2,
        ),
        Quiz(
            question = R.string.question_idioms_1,
            options = R.array.options_idioms_1,
            explanation = R.string.explanation_idioms_1,
            rightAnswer = R.string.all_correct,
        ),
    )
    val secondLevelQuizzes = listOf(
        Quiz(
            question = R.string.question_vocabulary_14,
            options = R.array.options_vocabulary_14,
            explanation = R.string.explanation_vocabulary_14,
            rightAnswer = R.string.answer_vocabulary_14_2,
        ),
        Quiz(
            question = R.string.question_phrasal_verbs_1,
            options = R.array.quiz_options_phrasal_verbs_1,
            explanation = R.string.explanation_phrasal_verbs_1,
            rightAnswer = R.string.answer_phrasal_verbs_1_2,
        ),
        Quiz(
            question = R.string.question_phrasal_verbs_4,
            options = R.array.quiz_options_phrasal_verbs_4,
            explanation = R.string.explanation_phrasal_verbs_4,
            rightAnswer = R.string.answer_phrasal_verbs_4_3,
        ),
        Quiz(
            question = R.string.question_grammar_4,
            options = R.array.options_grammar_4,
            explanation = R.string.explanation_grammar_4,
            rightAnswer = R.string.answer_grammar_4_1,
        ),
        Quiz(
            question = R.string.question_grammar_19,
            options = R.array.options_grammar_19,
            explanation = R.string.explanation_grammar_19,
            rightAnswer = R.string.answer_grammar_19_2,
        ),
        Quiz(
            question = R.string.question_tenses_4,
            options = R.array.options_tenses_4,
            explanation = R.string.explanation_tenses_4,
            rightAnswer = R.string.answer_tenses_4_1,
        ),
    )
    val thirdLevelQuizzes = listOf(
        Quiz(
            question = R.string.question_vocabulary_2,
            rightAnswer = R.string.all_correct,
            options = R.array.quiz_options_vocabulary_2,
            explanation = R.string.explanation_vocabulary_2,
        ),
        Quiz(
            question = R.string.question_vocabulary_4,
            options = R.array.options_vocabulary_4,
            explanation = R.string.explanation_vocabulary_4,
            rightAnswer = R.string.answer_vocabulary_4_3,
        ),
        Quiz(
            question = R.string.question_vocabulary_5,
            options = R.array.options_vocabulary_5,
            explanation = R.string.explanation_vocabulary_5,
            rightAnswer = R.string.answer_vocabulary_5_5,
        ),
        Quiz(
            question = R.string.question_vocabulary_9,
            options = R.array.options_vocabulary_9,
            explanation = R.string.explanation_vocabulary_9,
            rightAnswer = R.string.answer_vocabulary_9_2,
        ),
        Quiz(
            question = R.string.question_vocabulary_10,
            options = R.array.options_vocabulary_10,
            explanation = R.string.explanation_vocabulary_10,
            rightAnswer = R.string.answer_vocabulary_10_1,
        ),
        Quiz(
            question = R.string.question_vocabulary_12,
            options = R.array.options_vocabulary_12,
            explanation = R.string.explanation_vocabulary_12,
            rightAnswer = R.string.answer_vocabulary_12_2,
        ),
        Quiz(
            question = R.string.question_grammar_7,
            options = R.array.options_grammar_7,
            explanation = R.string.explanation_grammar_7,
            rightAnswer = R.string.all_correct,
        ),
        Quiz(
            question = R.string.question_grammar_16,
            options = R.array.options_grammar_16,
            explanation = R.string.explanation_grammar_16,
            rightAnswer = R.string.answer_grammar_16_3,
        ),
        Quiz(
            question = R.string.question_prepositions_3,
            options = R.array.options_prepositions_3,
            explanation = R.string.explanation_prepositions_3,
            rightAnswer = R.string.answer_prepositions_3_3,
        ),
        Quiz(
            question = R.string.question_prepositions_7,
            options = R.array.options_prepositions_7,
            explanation = R.string.explanation_prepositions_7,
            rightAnswer = R.string.all_correct,
        ),
        Quiz(
            question = R.string.question_idioms_2,
            options = R.array.options_idioms_2,
            explanation = R.string.explanation_idioms_2,
            rightAnswer = R.string.all_correct,
        ),
        Quiz(
            question = R.string.question_spelling_1,
            options = R.array.options_spelling_1,
            explanation = -1,
            rightAnswer = R.string.all_correct,
        ),
        Quiz(
            question = R.string.question_spelling_2,
            options = R.array.options_spelling_2,
            explanation = R.string.explanation_spelling_2,
            rightAnswer = R.string.answer_spelling_2_3,
        )
    )
    val fourthLevelQuizzes = listOf(
        Quiz(
            question = R.string.question_vocabulary_7,
            options = R.array.options_vocabulary_7,
            explanation = R.string.explanation_vocabulary_7,
            rightAnswer = R.string.answer_vocabulary_7_3,
        ),
        Quiz(
            question = R.string.question_vocabulary_13,
            options = R.array.options_vocabulary_13,
            explanation = R.string.explanation_vocabulary_13,
            rightAnswer = R.string.answer_vocabulary_13_3,
        ),
        Quiz(
            question = R.string.question_phrasal_verbs_2,
            options = R.array.quiz_options_phrasal_verbs_2,
            explanation = R.string.explanation_phrasal_verbs_2,
            rightAnswer = R.string.answer_phrasal_verbs_2_3,
        ),
        Quiz(
            question = R.string.question_phrasal_verbs_3,
            options = R.array.quiz_options_phrasal_verbs_3,
            explanation = R.string.explanation_phrasal_verbs_3,
            rightAnswer = R.string.answer_phrasal_verbs_3_1,
        ),
        Quiz(
            question = R.string.question_grammar_14,
            options = R.array.options_grammar_14,
            explanation = R.string.explanation_grammar_14,
            rightAnswer = R.string.answer_grammar_14_1,
        ),
        Quiz(
            question = R.string.question_prepositions_2,
            options = R.array.options_prepositions_2,
            explanation = R.string.explanation_prepositions_2,
            rightAnswer = R.string.answer_prepositions_2_3,
        ),
    )
    val fifthLevelQuizzes = listOf(
        Quiz(
            question = R.string.question_vocabulary_6,
            options = R.array.options_vocabulary_6,
            explanation = R.string.explanation_vocabulary_6,
            rightAnswer = R.string.answer_vocabulary_6_1,
        ),
        Quiz(
            question = R.string.question_vocabulary_8,
            options = R.array.options_vocabulary_8,
            explanation = R.string.explanation_vocabulary_8,
            rightAnswer = R.string.answer_vocabulary_8_4,
        ),
        Quiz(
            question = R.string.question_vocabulary_11,
            options = R.array.options_vocabulary_11,
            explanation = -1,
            rightAnswer = R.string.answer_vocabulary_11_1,
        ),
        Quiz(
            question = R.string.question_phrasal_verbs_5,
            options = R.array.options_phrasal_verbs_5,
            explanation = R.string.explanation_phrasal_verbs_5,
            rightAnswer = R.string.answer_phrasal_verbs_5_1,
        ),
        Quiz(
            question = R.string.question_phrasal_verbs_6,
            options = R.array.options_phrasal_verbs_6,
            explanation = R.string.explanation_phrasal_verbs_6,
            rightAnswer = R.string.answer_phrasal_verbs_6_3,
        ),
        Quiz(
            question = R.string.question_phrasal_verbs_8,
            options = R.array.options_phrasal_verbs_8,
            explanation = R.string.explanation_phrasal_verbs_8,
            rightAnswer = R.string.answer_phrasal_verbs_8_3,
        ),
        Quiz(
            question = R.string.question_phrasal_verbs_9,
            options = R.array.options_phrasal_verbs_9,
            explanation = R.string.explanation_phrasal_verbs_9,
            rightAnswer = 2,
        ),
        Quiz(
            question = R.string.question_phrasal_verbs_11,
            options = R.array.options_phrasal_verbs_11,
            explanation = R.string.explanation_phrasal_verbs_11,
            rightAnswer = R.string.answer_phrasal_verbs_11_2,
        ),
        Quiz(
            question = R.string.question_grammar_1,
            options = R.array.quiz_options_grammar_1,
            explanation = R.string.explanation_grammar_1,
            rightAnswer = R.string.answer_grammar_1_1,
        ),
        Quiz(
            question = R.string.question_grammar_5,
            options = R.array.options_grammar_5,
            explanation = R.string.explanation_grammar_5,
            rightAnswer = R.string.answer_grammar_5_1,
        ),
        Quiz(
            question = R.string.question_grammar_6,
            options = R.array.options_grammar_6,
            explanation = R.string.explanation_grammar_6,
            rightAnswer = R.string.all_correct,
        ),
        Quiz(
            question = R.string.question_grammar_11,
            options = R.array.options_grammar_11,
            explanation = R.string.explanation_grammar_11,
            rightAnswer = R.string.answer_grammar_11_4,
        ),
        Quiz(
            question = R.string.question_grammar_12,
            options = R.array.options_grammar_12,
            explanation = R.string.explanation_grammar_12,
            rightAnswer = R.string.answer_grammar_12_5,
        ),
        Quiz(
            question = R.string.question_grammar_18,
            options = R.array.options_grammar_18,
            explanation = R.string.explanation_grammar_18,
            rightAnswer = R.string.all_correct,
        ),
        Quiz(
            question = R.string.question_prepositions_1,
            options = R.array.options_prepositions_1,
            explanation = R.string.explanation_prepositions_1,
            rightAnswer = R.string.answer_prepositions_1_4,
        ),
        Quiz(
            question = R.string.question_prepositions_4,
            options = R.array.options_prepositions_4,
            explanation = R.string.explanation_prepositions_4,
            rightAnswer = R.string.answer_prepositions_4_1,
        ),
        Quiz(
            question = R.string.question_prepositions_5,
            options = R.array.options_prepositions_5,
            explanation = R.string.explanation_prepositions_5,
            rightAnswer = R.string.all_correct,
        ),
        Quiz(
            question = R.string.question_slang_2,
            options = R.array.options_slang_2,
            explanation = R.string.explanation_slang_2,
            rightAnswer = R.string.answer_slang_2_1,
        ),
    )
    val sixthLevelQuizzes = listOf(
        Quiz(
            question = R.string.question_phrasal_verbs_7,
            options = R.array.options_phrasal_verbs_7,
            explanation = R.string.explanation_phrasal_verbs_7,
            rightAnswer = R.string.answer_phrasal_verbs_7_2,
        ),
        Quiz(
            question = R.string.question_grammar_2,
            options = R.array.quiz_options_grammar_2,
            explanation = R.string.explanation_grammar_2,
            rightAnswer = R.string.answer_grammar_2_3,
        ),
        Quiz(
            question = R.string.question_grammar_13,
            options = R.array.options_grammar_13,
            explanation = R.string.explanation_grammar_13,
            rightAnswer = R.string.answer_grammar_13_7,
        ),
        Quiz(
            question = R.string.question_idioms_3,
            options = R.array.options_idioms_3,
            explanation = R.string.explanation_idioms_3,
            rightAnswer = R.string.answer_idioms_3_3,
        ),
    )
    val seventhLevelQuizzes = listOf(
        Quiz(
            question = R.string.question_grammar_3,
            options = R.array.quiz_options_grammar_3,
            explanation = R.string.explanation_grammar_3,
            rightAnswer = R.string.answer_grammar_3_2,
        ),
        Quiz(
            question = R.string.question_grammar_8,
            options = R.array.options_grammar_8,
            explanation = R.string.explanation_grammar_8,
            rightAnswer = R.string.answer_grammar_8_1,
        ),
        Quiz(
            question = R.string.question_grammar_17,
            options = R.array.options_grammar_17,
            explanation = R.string.explanation_grammar_17,
            rightAnswer = R.string.all_incorrect,
        ),
    )
    val eighthLevelQuizzes = listOf(
        Quiz(
            question = R.string.question_vocabulary_3,
            options = R.array.quiz_options_vocabulary_3,
            explanation = R.string.explanation_vocabulary_3,
            rightAnswer = R.string.answer_vocabulary_3_3,
        ),
        Quiz(
            question = R.string.question_phrasal_verbs_10,
            options = R.array.options_phrasal_verbs_10,
            explanation = R.string.explanation_phrasal_verbs_10,
            rightAnswer = R.string.answer_phrasal_verbs_10_3,
        ),
    )
    val ninthLevelQuizzes = listOf(
        Quiz(
            question = R.string.question_tenses_2,
            options = R.array.options_tenses_2,
            explanation = R.string.explanation_tenses_2,
            rightAnswer = R.string.all_correct,
        ),
    )
    val tenthLevelQuizzes = listOf(
        Quiz(
            question = R.string.question_tenses_5,
            options = R.array.options_tenses_5,
            explanation = R.string.explanation_tenses_5,
            rightAnswer = R.string.answer_tenses_5_9,
        ),
        Quiz(
            question = R.string.question_slang_1,
            options = R.array.options_slang_1,
            explanation = R.string.explanation_slang_1,
            rightAnswer = R.string.answer_slang_1_2,
        ),
    )
}