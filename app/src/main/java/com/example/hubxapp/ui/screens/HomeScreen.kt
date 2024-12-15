package com.example.hubxapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.hubxapp.ui.components.CategoriesSection
import com.example.hubxapp.ui.components.HeaderSection
import com.example.hubxapp.ui.components.PromotionSection
import com.example.hubxapp.ui.components.QuestionsSection
import com.example.hubxapp.ui.viewmodel.HomeScreenViewModel


@Composable
fun HomeScreen(homeScreenViewModel: HomeScreenViewModel) {

    Column(modifier = Modifier.fillMaxSize()) {
        HeaderSection()
        PromotionSection()
        QuestionsSection(homeScreenViewModel = homeScreenViewModel)
        CategoriesSection(homeScreenViewModel = homeScreenViewModel)
    }
}
