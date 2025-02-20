package com.example.russianquiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.russianquiz.model.LocalizedApp
import com.example.russianquiz.model.MainViewModel
import com.example.russianquiz.ui.theme.QuizAppTheme
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuizAppTheme {
                val mainViewModel = getViewModel<MainViewModel>()

                val windowSize = calculateWindowSizeClass(this)
                val settingsData by mainViewModel.settingsData.collectAsState()

                LocalizedApp(languagesCode = settingsData.language.locale) {
                    MainScreen(
                        windowSize = windowSize.widthSizeClass,
                        mainViewModel = mainViewModel,
                        modifier = Modifier,
                    )
                }
            }
        }
    }
}