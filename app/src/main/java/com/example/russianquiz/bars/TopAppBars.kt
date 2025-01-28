package com.example.russianquiz.bars

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.russianquiz.R
import com.example.russianquiz.model.MainViewModel
import com.example.russianquiz.model.localizedString

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopAppBar(
    navController: NavHostController,
    isStartScreen: Boolean,
    isQuizScreen: Boolean,
    isSettingsScreen: Boolean,
    isProfileScreen: Boolean,
    isResultScreen: Boolean,
    mainViewModel: MainViewModel,
    modifier: Modifier = Modifier,
) {
    var gonnaBeFinished by remember { mutableStateOf(false) }
    val quizData by mainViewModel.quizData.collectAsState()

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
                    if (isQuizScreen) {
                        gonnaBeFinished = true
                    } else if (isResultScreen) {
                        mainViewModel.resetResult()
                        navController.navigate(NavigationScreen.ChooseScreen.route)
                    } else {
                        navController.navigateUp()
                    }
                }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = localizedString(R.string.navigate_up),
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
                        contentDescription = localizedString(R.string.settings),
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
                        contentDescription = localizedString(R.string.profile),
                        modifier = Modifier.size(35.dp),
                        tint = Color.White,
                    )
                }
            }
        },
        modifier = modifier.windowInsetsPadding(WindowInsets.statusBars)
    )

    if (gonnaBeFinished) {
        AlertDialog(
            onDismissRequest = {
                gonnaBeFinished = false
            },
            dismissButton = {
                TextButton(
                    onClick = { gonnaBeFinished = false },
                    colors = ButtonDefaults.textButtonColors().copy(contentColor = Color.White),
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(100))
                        .border(
                            width = 1.dp,
                            color = Color.White,
                            shape = RoundedCornerShape(100)
                        )
                ) {
                    Text(
                        text = localizedString(R.string.cancel),
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        gonnaBeFinished = false
                        if (quizData.solvedQuestions == 0 && quizData.chosenOption == 0) {
                            navController.navigate(NavigationScreen.ChooseScreen.route)
                        } else {
                            mainViewModel.onNextQuestionClick(
                                navController = navController,
                                isFinished = true
                            )
                        }
                    },
                    colors = ButtonDefaults.textButtonColors().copy(contentColor = Color.White),
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(100))
                        .border(
                            width = 1.dp,
                            color = Color.White,
                            shape = RoundedCornerShape(100)
                        )
                ) {
                    Text(
                        text = localizedString(R.string.continue_string),
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }
            },
            title = {
                Text(
                    text = localizedString(R.string.finish_quiz),
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(align = Alignment.CenterHorizontally)
                )
            },
            text = {
                Text(
                    text = localizedString(
                        if (quizData.solvedQuestions == 0 && quizData.chosenOption == 0) {
                            R.string.no_progress_finish_quiz_details
                        } else {
                            R.string.finish_quiz_details
                        }
                    ),
                    textAlign = TextAlign.Justify
                )
            },
            containerColor = Color(0xE52E8B57),
            titleContentColor = Color.White,
            textContentColor = Color.White,
            shape = RoundedCornerShape(10),
            modifier = Modifier
                .border(width = 3.dp, color = Color.White, shape = RoundedCornerShape(10))
        )
    }
}