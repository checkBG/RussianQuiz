package com.example.russianquiz.bars

import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import com.example.russianquiz.R
import com.example.russianquiz.model.LocalAppContext
import com.example.russianquiz.model.MainViewModel
import com.example.russianquiz.model.UserAction
import com.example.russianquiz.model.localizedString
import com.example.russianquiz.ui.theme.QuizAppTheme

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
                        mainViewModel.onUserAction(action = UserAction.ShowDialog)
                    } else if (isResultScreen) {
                        mainViewModel.onUserAction(
                            action = UserAction.ResetResult(
                                navController = navController,
                                route = NavigationScreen.ChooseScreen.route
                            )
                        )
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
                enter = expandHorizontally(
                    initialWidth = { -it },
                    animationSpec = tween(800),
                ) + fadeIn(),
                exit = shrinkHorizontally(
                    targetWidth = { it },
                    animationSpec = tween(800),
                ) + fadeOut(),
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
                enter = expandHorizontally(
                    initialWidth = { it },
                    animationSpec = tween(800),
                ) + fadeIn(),
                exit = shrinkHorizontally(
                    targetWidth = { -it },
                    animationSpec = tween(400),
                ) + fadeOut()
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
}


@Composable
fun CustomAlertDialog(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
    @StringRes title: Int,
    @StringRes description: Int,
) {
    val scale = remember { Animatable(0.8f) }

    // Animate of dialog's appearance
    LaunchedEffect(Unit) {
        scale.animateTo(
            targetValue = 1.2f,
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = 350f,
            )
        )
    }

    Dialog(onDismissRequest = onDismiss) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
                .scale(scale.value) // Animate the scale
        ) {
            Column(
                modifier = Modifier
                    .background(Color(0xFF292B3A), shape = RoundedCornerShape(24.dp))
                    .padding(24.dp)
            ) {
                // title
                Text(
                    text = localizedString(id = title),
                    fontSize = 20.sp,
                    letterSpacing = 0.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Description
                Text(
                    text = localizedString(id = description),
                    fontSize = 14.sp,
                    color = Color(0xFFCCCCCC),
                    letterSpacing = 1.5.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Buttons
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // the button Cancel
                    Button(
                        onClick = onDismiss,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF44475A)
                        ),
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp),
                        shape = RoundedCornerShape(12.dp),
                        contentPadding = PaddingValues()
                    ) {
                        Text(
                            localizedString(R.string.cancel),
                            color = Color.White,
                            fontSize = 16.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Visible,
                        )
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    // the button Continue with a gradiant
                    Button(
                        onClick = onConfirm,
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                        contentPadding = PaddingValues()
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(RoundedCornerShape(12.dp))
                                .background(
                                    brush = Brush.horizontalGradient(
                                        colors = listOf(Color(0xFF7CFC00), Color(0xFF32CD32))
                                    )
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                localizedString(R.string.continue_string),
                                color = Color.White,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                overflow = TextOverflow.Visible
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CustomAlertDialogPreview(modifier: Modifier = Modifier) {
    QuizAppTheme {
        CompositionLocalProvider(value = LocalAppContext provides LocalContext.current) {
            CustomAlertDialog(
                onDismiss = { /*TODO*/ },
                onConfirm = { /*TODO*/ },
                title = R.string.finish_quiz,
                description = R.string.no_progress_finish_quiz_details,
            )
        }
    }
}