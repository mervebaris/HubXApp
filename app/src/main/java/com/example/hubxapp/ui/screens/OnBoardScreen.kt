package com.example.hubxapp.ui.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.hubxapp.R
import com.example.hubxapp.ui.onboarding.OnBoardItem
import com.example.hubxapp.data.entity.OnBoardModel
import com.example.hubxapp.ui.onboarding.PaywallItem
import com.example.hubxapp.ui.viewmodel.OnBoardScreenViewModel


@Composable
fun OnboardingScreen(navController: NavController,onBoardScreenViewModel: OnBoardScreenViewModel) {
    val onBoardView = onBoardScreenViewModel.onBoardView.observeAsState()
    val screenVisible = remember { mutableStateOf(false) }

    LaunchedEffect(onBoardView.value) {
        onBoardView.value?.let {
            if(it.status == 1){//1 : Kullanıcı tarafından daha önce OnboardingScreen'i görüldü.
                navController.navigate("bottomBarScreen")
                screenVisible.value = false//Sayfa geçişinde OnboardingScreen'in görünmemesini sağlar.
            }else{
                screenVisible.value = true
            }
        }
    }

    //Sayfa içerikleri listesi
    val pages = listOf(
        OnBoardModel(
            title = "Welcome to PlantApp",
            subtitle = "Identify more than 3000+ plants and 88% accuracy.",
            image = R.drawable.get_started,
            buttonTitle = "Get Started",
            description = "By tapping next,you are agreeing to PlantID \nTerms of Use & Privacy Policy",
        ),
        OnBoardModel(
            title = "Take a photo to identify the plant!",
            subtitle = "",
            image = R.drawable.on_boarding1,
            buttonTitle = "Continue",
            description = "",
        ),
        OnBoardModel(
            title = "Get plant care guides",
            subtitle = "",
            image = R.drawable.on_boarding2,
            buttonTitle = "Continue",
            description = "",
        ),
        OnBoardModel(
            title = "PlantApp Premium",
            subtitle = "Access All Features",
            image = R.drawable.pay_wall,
            buttonTitle = "Try free for 3 days",
            description = "After the 3-day free trial period you’ll be charged ₺274.99 per year unless you cancel before the trial expires. Yearly Subscription is Auto-Renewable \nTerms  •  Privacy  •  Restore",
        )
    )
    //Sayfaların hareketini yöneten tanımlama
    //initialPage : başlanılacak sayfa
    //pageCount : toplam sayfa sayısı
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { 4 })
    //Button benzeri bir tıklama ile sayfa geçişini sağlayan kodlama
    val lastPageIndex = pagerState.pageCount-1

    if (screenVisible.value){
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxWidth()
        ) { page ->
            if (page < lastPageIndex) {
                OnBoardItem(pages[page],pagerState)
            }else{
                PaywallItem(pages[page],navController,onBoardScreenViewModel)
            }
        }
    }
}









