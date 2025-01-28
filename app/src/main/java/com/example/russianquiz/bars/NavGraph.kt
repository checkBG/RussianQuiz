package com.example.russianquiz.bars

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.russianquiz.fundamental.ChooseLevel
import com.example.russianquiz.fundamental.ProfileScreen
import com.example.russianquiz.fundamental.QuizScreen
import com.example.russianquiz.fundamental.ResultScreen
import com.example.russianquiz.fundamental.SettingsScreen
import com.example.russianquiz.model.MainViewModel

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    widthSize: WindowWidthSizeClass,
    mainViewModel: MainViewModel,
) {
    NavHost(
        navController = navController,
        startDestination = NavigationScreen.ChooseScreen.route,
        modifier = modifier.fillMaxSize(),
        enterTransition = { slideInHorizontally(initialOffsetX = { it }) + fadeIn() },
        exitTransition = { slideOutHorizontally(targetOffsetX = { -it }) + fadeOut() },
    ) {

        composable(route = NavigationScreen.ChooseScreen.route) {
            ChooseLevel(
                levels = mainViewModel.levels,
                widthSize = widthSize,
                navController = navController,
                mainViewModel = mainViewModel,
            )
        }

        composable(route = NavigationScreen.QuizScreen.route) {
            QuizScreen(
                mainViewModel = mainViewModel,
                widthSize = widthSize,
            )
        }

        composable(route = NavigationScreen.SettingsScreen.route) {
            SettingsScreen(
                mainViewModel = mainViewModel,
                widthSize = widthSize,
            )
        }

        composable(route = NavigationScreen.ProfileScreen.route) {
            ProfileScreen(
                mainViewModel = mainViewModel,
                widthSize = widthSize
            )
        }

        composable(route = NavigationScreen.ResultScreen.route) {
            ResultScreen(
                mainViewModel = mainViewModel,
                navController = navController
            )
        }
    }
}