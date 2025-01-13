package com.example.russianquiz.bars

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.russianquiz.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopAppBar(
    navController: NavHostController,
    isStartScreen: Boolean,
    isSettingsScreen: Boolean,
    isProfileScreen: Boolean,
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        title = { },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent.copy(alpha = 0.4f)
        ),
        navigationIcon = {
            AnimatedVisibility(
                visible = !isStartScreen,
                enter = slideInHorizontally(initialOffsetX = { -it }) + fadeIn(),
                exit = slideOutHorizontally(targetOffsetX = { -it }) + fadeOut(),
            ) {
                IconButton(onClick = {
                    navController.navigateUp()
                }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.navigate_up),
                        modifier = Modifier.size(35.dp),
                        tint = Color.White,
                    )
                }
            }
        },
        actions = {
            AnimatedVisibility(
                visible = !isSettingsScreen,
            ) {
                IconButton(onClick = {
                    navController.navigate(NavigationScreen.SettingsScreen.route)
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.settings_icon),
                        contentDescription = stringResource(R.string.settings),
                        modifier = Modifier.size(35.dp),
                        tint = Color.White,
                    )
                }
            }
            AnimatedVisibility(
                visible = !isProfileScreen,
            ) {
                IconButton(onClick = {
                    navController.navigate(NavigationScreen.ProfileScreen.route)
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.profile_icon),
                        contentDescription = stringResource(R.string.profile),
                        modifier = Modifier.size(35.dp),
                        tint = Color.White,
                    )
                }
            }
        },
        modifier = modifier.windowInsetsPadding(WindowInsets.statusBars)
    )
}