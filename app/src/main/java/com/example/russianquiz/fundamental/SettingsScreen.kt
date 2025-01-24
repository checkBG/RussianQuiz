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
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.russianquiz.R
import com.example.russianquiz.model.Languages
import com.example.russianquiz.model.MainViewModel
import com.example.russianquiz.model.localizedString
import com.example.russianquiz.ui.theme.QuizAppTheme

@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier,
    mainViewModel: MainViewModel
) {
    Column(
        modifier = modifier.padding(top = 20.dp),
    ) {
        SelectLanguage(mainViewModel = mainViewModel)
    }
}

@Composable
fun SelectLanguage(
    modifier: Modifier = Modifier,
    mainViewModel: MainViewModel
) {
    val currentLanguage by mainViewModel.language.collectAsState()

    var dropdownMenu by remember { mutableStateOf(false) }
    val rotation by animateFloatAsState(
        targetValue = if (dropdownMenu) 180f else 0f,
        animationSpec = tween(100),
        label = ""
    )
    Column {
        Card(
            modifier = modifier
                .padding(start = 15.dp, end = 15.dp),
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
                    fontSize = 20.sp
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
            LazyColumn {
                items(items = Languages.entries) { language ->
                    LanguageOption(
                        language = language,
                        currentLanguage = currentLanguage,
                        onChoosingClick = {
                            mainViewModel.changeLanguage(languageCode = language.locale)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun LanguageOption(
    modifier: Modifier = Modifier,
    language: Languages,
    currentLanguage: String = Languages.ENGLISH.locale,
    onChoosingClick: () -> Unit,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 20.dp, start = 10.dp, end = 10.dp),
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
            modifier = Modifier.padding(start = 20.dp, end = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = language.flagIcon),
                contentDescription = null,
                modifier = Modifier.size(60.dp)
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

@Preview
@Composable
private fun SettingsScreenPreview() {
    QuizAppTheme {
        SettingsScreen(
            mainViewModel = MainViewModel()
        )
    }
}