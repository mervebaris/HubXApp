package com.example.hubxapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hubxapp.R
import com.example.hubxapp.ui.theme.LightGray
import com.example.hubxapp.ui.theme.MainColor
import com.example.hubxapp.ui.viewmodel.HomeScreenViewModel
import com.example.hubxapp.ui.viewmodel.OnBoardScreenViewModel

@Composable
fun BottomBarScreen(homeScreenViewModel: HomeScreenViewModel
) {
    val selectedItem = remember { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor = Color.White,
                modifier = Modifier.fillMaxWidth(),
            ) {
                Row(
                    modifier = Modifier.weight(1f),
                ) {
                    NavigationBarItem(
                        selected = selectedItem.value == 0,
                        onClick = { selectedItem.value = 0 },
                        icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.home),
                                contentDescription = ""
                            ) },
                        label = {
                            Text(
                                text = stringResource(id = R.string.home),
                                fontSize = 12.sp
                            )},
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = MainColor,
                            unselectedIconColor = LightGray,
                            selectedTextColor = MainColor,
                            unselectedTextColor = LightGray,
                            indicatorColor = Color.Transparent
                        )
                    )
                }
                Row(
                    modifier = Modifier.weight(1f),
                ) {
                    NavigationBarItem(
                        selected = selectedItem.value == 1,
                        onClick = { selectedItem.value = 1 },
                        icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.diagnose),
                                contentDescription = ""
                            ) },
                        label = {
                            Text(text = stringResource(id = R.string.diagnose),
                                fontSize = 12.sp
                            ) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = MainColor,
                            unselectedIconColor = LightGray,
                            selectedTextColor = MainColor,
                            unselectedTextColor = LightGray,
                            indicatorColor = Color.Transparent
                        )
                    )


                }

                Box(
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .offset(y = (-16).dp)
                ) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .background(
                                color = MainColor,
                                shape = CircleShape
                            )
                            .padding(8.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.camera),
                            contentDescription = "",
                            modifier = Modifier.size(30.dp)
                        )
                    }
                }


                Row(
                    modifier = Modifier.weight(1f),
                ) {
                    NavigationBarItem(
                        selected = selectedItem.value == 2,
                        onClick = { selectedItem.value = 2 },
                        icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.my_garden),
                                contentDescription = ""
                            ) },
                        label = {
                            Text(text = stringResource(id = R.string.myGarden),
                                fontSize = 12.sp
                            ) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = MainColor,
                            unselectedIconColor = LightGray,
                            selectedTextColor = MainColor,
                            unselectedTextColor = LightGray,
                            indicatorColor = Color.Transparent
                        )
                    )


                }
                Row(
                    modifier = Modifier.weight(1f),
                ) {
                    NavigationBarItem(
                        selected = selectedItem.value == 3,
                        onClick = { selectedItem.value = 3 },
                        icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.profile),
                                contentDescription = ""
                            ) },
                        label = {
                            Text(text = stringResource(id = R.string.profile),
                                fontSize = 12.sp
                            ) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = MainColor,
                            unselectedIconColor = LightGray,
                            selectedTextColor = MainColor,
                            unselectedTextColor = LightGray,
                            indicatorColor = Color.Transparent
                        )
                    )


                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HomeScreen(homeScreenViewModel = homeScreenViewModel)
        }
    }
}


