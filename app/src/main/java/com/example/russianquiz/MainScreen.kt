package com.example.russianquiz

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.MediumFloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.russianquiz.bars.MainTopAppBar
import com.example.russianquiz.bars.NavGraph
import com.example.russianquiz.bars.NavigationScreen
import com.example.russianquiz.model.MainViewModel

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun MainScreen(
    mainViewModel: MainViewModel,
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()
    val backStack by navController.currentBackStackEntryAsState()
    val currentScreen = backStack?.destination
    val quizData by mainViewModel.quizData.collectAsState()

    Scaffold(
        floatingActionButton = {
            AnimatedVisibility(
                visible = (currentScreen?.route == NavigationScreen.QuizScreen.route) && quizData.isCompleted,
                enter = slideInHorizontally(initialOffsetX = { -it }) + fadeIn(),
                exit = slideOutHorizontally(targetOffsetX = { it }) + fadeOut(),
            ) {
                MediumFloatingActionButton(
                    onClick = {
                        mainViewModel.onNextQuestionClick(
                            navController = navController,
                        )
                    },
                    containerColor = Color(0xFF9400d3),
                    contentColor = Color.White,
                    modifier = Modifier
                        .size(65.dp)
                        .clip(shape = RoundedCornerShape(100))
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = stringResource(R.string.continue_string),
                        modifier = Modifier
                            .size(35.dp)
                    )
                }
            }
        },
        floatingActionButtonPosition = FabPosition.EndOverlay,
        topBar = {
            MainTopAppBar(
                navController = navController,
                isStartScreen = currentScreen?.route == NavigationScreen.ChooseScreen.route,
                isSettingsScreen = currentScreen?.route == NavigationScreen.SettingsScreen.route,
                isProfileScreen = currentScreen?.route == NavigationScreen.ProfileScreen.route,
                isQuizScreen = currentScreen?.route == NavigationScreen.QuizScreen.route,
                mainViewModel = mainViewModel,
            )
        },
        modifier = modifier,
    ) {
        Box(modifier = Modifier.background(color = colorResource(id = R.color.purple_700))) {
            Background(
                modifier = Modifier
            )

            NavGraph(
                widthSize = windowSize,
                mainViewModel = mainViewModel,
                navController = navController,
                modifier = Modifier.padding(it),
            )
        }
    }
}