package com.example.russianquiz

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.russianquiz.bars.MainTopAppBar
import com.example.russianquiz.bars.NavGraph
import com.example.russianquiz.bars.NavigationScreen
import com.example.russianquiz.model.MainViewModel

@Composable
fun MainScreen(
    mainViewModel: MainViewModel,
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()
    val backStack by navController.currentBackStackEntryAsState()
    val currentScreen = backStack?.destination

    Scaffold(
        topBar = {
            MainTopAppBar(
                navController = navController,
                isStartScreen = currentScreen?.route == NavigationScreen.ChooseScreen.route,
                isSettingsScreen = currentScreen?.route == NavigationScreen.SettingsScreen.route,
                isProfileScreen = currentScreen?.route == NavigationScreen.ProfileScreen.route,
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