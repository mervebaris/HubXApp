package com.example.hubxapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.hubxapp.ui.screens.BottomBarScreen
import com.example.hubxapp.ui.screens.ScreenNavigations
import com.example.hubxapp.ui.viewmodel.HomeScreenViewModel
import com.example.hubxapp.ui.theme.HubXAppTheme
import com.example.hubxapp.ui.viewmodel.OnBoardScreenViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val homeScreenViewModel : HomeScreenViewModel by viewModels()
    val onBoardScreenViewModel: OnBoardScreenViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HubXAppTheme {
                ScreenNavigations(
                    onBoardScreenViewModel = onBoardScreenViewModel,
                    homeScreenViewModel = homeScreenViewModel)
            }
        }
    }
}



