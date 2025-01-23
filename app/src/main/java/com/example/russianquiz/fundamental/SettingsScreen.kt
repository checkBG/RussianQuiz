package com.example.russianquiz.fundamental

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.russianquiz.ui.theme.QuizAppTheme

@Composable
fun SettingsScreen(modifier: Modifier = Modifier) {

}

@Composable
fun SettingOption(modifier: Modifier = Modifier) {
    val dropdownMenu by remember { mutableStateOf(false) }
    Column {
        Card(
            modifier = modifier,
        ) {

        }
        AnimatedVisibility(
            visible = dropdownMenu,
            enter = slideInVertically(initialOffsetY = { -it }) + fadeIn(),
            exit = slideOutVertically(targetOffsetY = { -it }) + fadeOut()
        ) {
            LazyColumn {

            }
        }
    }
}

@Preview
@Composable
private fun SettingsScreenPreview() {
    QuizAppTheme {
        SettingsScreen()
    }
}