package com.example.hubxapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hubxapp.ui.viewmodel.HomeScreenViewModel
import com.example.hubxapp.ui.viewmodel.OnBoardScreenViewModel

@Composable
fun ScreenNavigations(
    onBoardScreenViewModel: OnBoardScreenViewModel,
    homeScreenViewModel: HomeScreenViewModel,
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "onBoardScreen") {
        composable("onBoardScreen") {
            OnboardingScreen(
                navController = navController,
                onBoardScreenViewModel = onBoardScreenViewModel
            )
        }
        composable("bottomBarScreen") {
            BottomBarScreen(homeScreenViewModel = homeScreenViewModel)
        }
        composable("homeScreen") {
            HomeScreen(homeScreenViewModel = homeScreenViewModel)
        }
    }
}