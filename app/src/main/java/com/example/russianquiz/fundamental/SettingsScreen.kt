package com.example.russianquiz.fundamental

import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.russianquiz.R
import com.example.russianquiz.model.Language
import com.example.russianquiz.model.LocalAppContext
import com.example.russianquiz.model.MainViewModel
import com.example.russianquiz.model.UserAction
import com.example.russianquiz.model.database.dao.MockSettingsDataDao
import com.example.russianquiz.model.localizedString
import com.example.russianquiz.ui.theme.QuizAppTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier,
    mainViewModel: MainViewModel,
    widthSize: WindowWidthSizeClass,
) {
    val settingsData by mainViewModel.settingsData.collectAsState()

    val countLanguagesInRow = when (widthSize) {
        WindowWidthSizeClass.Compact -> 1
        WindowWidthSizeClass.Medium -> 2
        WindowWidthSizeClass.Expanded -> 2
        else -> 1
    }

    val sliderWidth = when (widthSize) {
        WindowWidthSizeClass.Compact -> 0.9f
        WindowWidthSizeClass.Medium -> 0.7f
        WindowWidthSizeClass.Expanded -> 0.6f
        else -> 0.9f
    }

    Column(
        modifier = modifier
            .padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Option(
            widthSize = widthSize,
            textOption = localizedString(R.string.choose_language),
            optionIcon = settingsData.language.flagIcon,
            optionElement = {
                FlowRow(
                    maxItemsInEachRow = countLanguagesInRow,
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Language.entries.forEach { language ->
                        LanguageOption(
                            language = language,
                            currentLanguage = settingsData.language.locale,
                            onChoosingClick = {
                                mainViewModel.onUserAction(
                                    action = UserAction.ChangeLanguage(
                                        language = language
                                    )
                                )
                            },
                            countInRow = countLanguagesInRow
                        )
                    }
                }
            }
        )

        Spacer(modifier = Modifier.height(10.dp))

        Option(
            widthSize = widthSize,
            textOption = localizedString(R.string.count_of_quizzes, settingsData.quizCount),
            optionIcon = R.drawable.quizzes,
            optionElement = {
                Slider(
                    value = settingsData.quizCount.toFloat(),
                    onValueChange = {
                        mainViewModel.onUserAction(
                            action = UserAction.ChangeQuizCount(
                                count = it.toInt()
                            )
                        )
                    },
                    valueRange = 10f..30f,
                    colors = SliderDefaults.colors(
                        thumbColor = Color(0xFF03DAC6),
                        activeTrackColor = Color(0xFF018786),
                        inactiveTrackColor = Color(0xFFE0E0E0)
                    ),
                    modifier = Modifier
                        .padding(start = 10.dp, end = 10.dp)
                        .fillMaxWidth(sliderWidth)
                )
            },
        )
    }
}

@Composable
fun Option(
    modifier: Modifier = Modifier,
    widthSize: WindowWidthSizeClass,
    textOption: String,
    @DrawableRes optionIcon: Int,
    optionElement: @Composable () -> Unit,
) {
    var dropdownMenu by remember { mutableStateOf(false) }
    val rotation by animateFloatAsState(
        targetValue = if (dropdownMenu) 180f else 0f,
        animationSpec = tween(100),
        label = ""
    )

    val optionWidthScale = when (widthSize) {
        WindowWidthSizeClass.Compact -> 1f
        WindowWidthSizeClass.Medium -> 0.8f
        WindowWidthSizeClass.Expanded -> 0.7f
        else -> 1f
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        Card(
            modifier = modifier
                .padding(start = 15.dp, end = 15.dp)
                .fillMaxWidth(optionWidthScale),
            onClick = { dropdownMenu = !dropdownMenu }
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .background(color = Color.White)
                    .padding(10.dp)
            ) {
                Image(
                    painter = painterResource(id = optionIcon),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(40.dp)
                        .clipToBounds()
                        .clip(shape = RoundedCornerShape(100))
                        .border(
                            3.dp,
                            brush = Brush.radialGradient(
                                colorStops = arrayOf(
                                    0.8f to Color.Transparent,
                                    1f to Color.Black,
                                )
                            ),
                            shape = RoundedCornerShape(100)
                        )
                )

                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = textOption,
                    fontSize = 25.sp,
                    fontFamily = FontFamily.Serif
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    painter = painterResource(id = R.drawable.arrow),
                    contentDescription = null,
                    modifier = Modifier
                        .size(25.dp)
                        .rotate(rotation)
                )
            }
        }
        AnimatedVisibility(
            visible = dropdownMenu,
            enter = expandVertically(animationSpec = tween(300))
                    + fadeIn(),
            exit = shrinkVertically(animationSpec = tween(300))
                    + fadeOut(),
        ) {
            Spacer(modifier = Modifier.height(10.dp))

            optionElement()

            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Composable
fun LanguageOption(
    modifier: Modifier = Modifier,
    language: Language,
    currentLanguage: String,
    countInRow: Int,
    onChoosingClick: () -> Unit,
) {
    Card(
        modifier = modifier
            .fillMaxWidth(1f / countInRow * 0.8f)
            .padding(top = 10.dp, start = 10.dp, end = 10.dp),
        onClick = onChoosingClick,
        colors = CardDefaults.cardColors(
            containerColor =
            if (currentLanguage == language.locale) {
                Color(0x44FFFFFF)
            } else {
                Color(0x12FFFFFF)
            }
        )
    ) {
        Row(
            modifier = Modifier.padding(start = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = language.flagIcon),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(50.dp)
                    .clipToBounds()
                    .clip(shape = RoundedCornerShape(100))
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = localizedString(id = language.text),
                fontSize = 30.sp,
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun SettingsScreenPreview() {
    CompositionLocalProvider(LocalAppContext provides LocalContext.current) {
        QuizAppTheme {
            SettingsScreen(
                mainViewModel = MainViewModel(MockSettingsDataDao()),
                widthSize = WindowWidthSizeClass.Compact
            )
        }
    }
}