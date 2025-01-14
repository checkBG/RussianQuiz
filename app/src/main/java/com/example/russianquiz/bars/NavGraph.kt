package com.example.russianquiz.bars

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.russianquiz.fundamental.ChooseCentury
import com.example.russianquiz.fundamental.QuizCard
import com.example.russianquiz.fundamental.StatisticCentury
import com.example.russianquiz.model.Century
import com.example.russianquiz.model.MainViewModel
import com.example.russianquiz.model.WrongAnswers

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    widthSize: WindowWidthSizeClass,
    mainViewModel: MainViewModel,
) {
    val chosenCentury by mainViewModel.chosenCentury.collectAsState()

    NavHost(
        navController = navController,
        startDestination = NavigationScreen.ChooseScreen.route,
        modifier = modifier.fillMaxSize(),
        enterTransition = { slideInHorizontally(initialOffsetX = { it }) + fadeIn() },
        exitTransition = { slideOutHorizontally(targetOffsetX = { -it }) + fadeOut() },
    ) {
        composable(route = NavigationScreen.ChooseScreen.route) {
            ChooseCentury(
                centuries = mainViewModel.centuries,
                widthSize = widthSize,
                navController = navController,
                mainViewModel = mainViewModel,
            )
        }

        composable(route = NavigationScreen.StatisticCenturyScreen.route) {
            StatisticCentury(
                widthSize = widthSize,
                century = chosenCentury.chosenCentury
                    ?: throw NullPointerException("An incorrect century"),
                navController = navController,
            )
        }

        composable(route = NavigationScreen.CenturyQuiz.route) {
            QuizCard(
                quiz = mainViewModel.chosenCentury.value.chosenCentury?.quizzes?.first()
                    ?: Century.NINTH.quizzes.first(),
                countOfQuestions = 20,
                quizWrongAnswers = WrongAnswers.generateWrongAnswers(
                    mainViewModel.chosenCentury.value.chosenCentury ?: Century.NINTH,
                    rightAnswer = mainViewModel.chosenCentury.value.chosenCentury?.quizzes?.first()?.rightAnswer
                        ?: Century.NINTH.quizzes.first().rightAnswer
                )
            )
        }

        composable(route = NavigationScreen.SettingsScreen.route) {

        }

        composable(route = NavigationScreen.ProfileScreen.route) {

        }
    }
}