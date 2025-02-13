package com.example.russianquiz.fundamental

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.russianquiz.R
import com.example.russianquiz.model.Languages
import com.example.russianquiz.model.MainViewModel
import com.example.russianquiz.model.localizedString

@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier,
    mainViewModel: MainViewModel,
    widthSize: WindowWidthSizeClass,
) {
    Column(
        modifier = modifier
            .padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SelectLanguage(
            mainViewModel = mainViewModel,
            widthSize = widthSize,
        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SelectLanguage(
    modifier: Modifier = Modifier,
    mainViewModel: MainViewModel,
    widthSize: WindowWidthSizeClass,
) {
    val settingsData by mainViewModel.settingsData.collectAsState()

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

    val countLanguagesInRow = when (widthSize) {
        WindowWidthSizeClass.Compact -> 1
        WindowWidthSizeClass.Medium -> 2
        WindowWidthSizeClass.Expanded -> 2
        else -> 1
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
                Text(
                    text = localizedString(R.string.choose_language),
                    fontSize = 30.sp,
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
            enter = slideInVertically(initialOffsetY = { -it }) + fadeIn(),
            exit = slideOutVertically(targetOffsetY = { -it }) + fadeOut()
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            FlowRow(
                maxItemsInEachRow = countLanguagesInRow,
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Languages.entries.forEach { language ->
                    LanguageOption(
                        language = language,
                        currentLanguage = settingsData.language.locale,
                        onChoosingClick = {
                            mainViewModel.changeLanguage(language = language)
                        },
                        countInRow = countLanguagesInRow
                    )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Composable
fun LanguageOption(
    modifier: Modifier = Modifier,
    language: Languages,
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
                    .size(60.dp)
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

//@Preview
//@Composable
//private fun SettingsScreenPreview() {
//    QuizAppTheme {
//        SettingsScreen(
//            mainViewModel = MainViewModel(),
//            widthSize = WindowWidthSizeClass.Compact
//        )
//    }
//}