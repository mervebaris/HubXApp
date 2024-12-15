package com.example.hubxapp.ui.onboarding

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hubxapp.R
import com.example.hubxapp.data.entity.FeatureModel
import com.example.hubxapp.data.entity.OnBoardModel
import com.example.hubxapp.ui.anim.FreeTrialAnimation
import com.example.hubxapp.ui.theme.Black
import com.example.hubxapp.ui.theme.DarkGray
import com.example.hubxapp.ui.theme.DarkGreen
import com.example.hubxapp.ui.theme.MainColor
import com.example.hubxapp.ui.theme.White
import com.example.hubxapp.ui.theme.WhiteTransparent
import com.example.hubxapp.ui.viewmodel.OnBoardScreenViewModel

@Composable
fun PaywallItem(onBoardModel: OnBoardModel, navController: NavController, onBoardScreenViewModel: OnBoardScreenViewModel) {
    val featureModels = listOf(
        FeatureModel(
            title = "Unlimited",
            subtitle = "Plant Identify",
            image = R.drawable.scanner,
        ),
        FeatureModel(
            title = "Faster",
            subtitle = "Process",
            image = R.drawable.speedometer,
        ),
        FeatureModel(
            title = "Detailed",
            subtitle = "Plant care",
            image = R.drawable.scanner,
        ),
    )

    //RadioButton seçenekleri state değişkeni
    val premiumOption = remember { mutableStateOf(2) }
    val freeTrialAlertVisible = remember { mutableStateOf(false) }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(DarkGray)) {

        //Resim Üzerindeki Tasarım Alanı
        //Başlık,Altbaşlık,LazyRow,RadioButton
        //%80 yer kaplıyor
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(80f),
            contentAlignment = Alignment.BottomCenter
        ) {

            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = onBoardModel.image),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.weight(1f)
                )
            }

            Column(
                modifier = Modifier.fillMaxSize().padding(all = 32.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.End) {
                Box(
                    modifier = Modifier
                        .background(
                            color = DarkGray,
                            shape = CircleShape
                        )
                        .clickable {
                            onBoardScreenViewModel.confirmViewedStatus()
                            navController.navigate("bottomBarScreen")
                        }
                ){
                    Image(
                        painter = painterResource(id = R.drawable.close_icon),
                        contentDescription = "",
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp, start = 32.dp, end = 32.dp),
                horizontalAlignment = Alignment.Start
            ) {

                Text(
                    text = onBoardModel.title, style = TextStyle(
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = White,
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = onBoardModel.subtitle,
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = WhiteTransparent,
                    )
                )

                LazyRow(modifier = Modifier.padding(top = 16.dp)) {
                    items(
                        count = featureModels.size,
                        itemContent = {
                            val feature = featureModels[it]
                            Card(
                                modifier = Modifier
                                    .padding(all = 3.dp)
                                    .size(150.dp, 100.dp),
                                colors = CardDefaults.cardColors(containerColor = DarkGreen),
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(start = 16.dp),
                                    verticalArrangement = Arrangement.SpaceEvenly,
                                    horizontalAlignment = Alignment.Start) {

                                    Card(
                                        modifier = Modifier.size(30.dp, 30.dp),
                                        colors = CardDefaults.cardColors(containerColor = Black),
                                        shape = RoundedCornerShape(5.dp),
                                    ) {
                                        Column(
                                            modifier = Modifier.fillMaxSize(),
                                            verticalArrangement = Arrangement.Center,
                                            horizontalAlignment = Alignment.CenterHorizontally) {
                                            Image(
                                                painter = painterResource(id = feature.image),
                                                contentDescription = "",
                                                modifier = Modifier.size(15.dp, 15.dp),
                                            )
                                        }

                                    }

                                    Text(
                                        text = feature.title, style = TextStyle(
                                            fontSize = 18.sp,
                                            color = White,
                                        )
                                    )

                                    Text(
                                        text = feature.subtitle, style = TextStyle(
                                            fontSize = 14.sp,
                                            color = WhiteTransparent,
                                        )
                                    )
                                }
                            }
                        }
                    )
                }

                Column {
                    Card(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .size(350.dp, 60.dp)
                            .clickable { premiumOption.value = 1 },
                        border = BorderStroke(2.dp, if(premiumOption.value == 1) MainColor else DarkGreen),
                        colors = CardDefaults.cardColors(containerColor = DarkGreen),
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start) {
                            RadioButton(
                                selected = (premiumOption.value == 1),
                                onClick = { premiumOption.value = 1 },
                                colors = RadioButtonDefaults.colors(
                                    selectedColor = MainColor
                                ))
                            Column {
                                Text(
                                    text = "1 Month", style = TextStyle(
                                        fontSize = 18.sp,
                                        color = White,
                                    )
                                )

                                Text(
                                    text = "$2.99/month, auto renewable", style = TextStyle(
                                        fontSize = 14.sp,
                                        color = WhiteTransparent,
                                    )
                                )
                            }
                        }
                    }

                    Card(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .size(350.dp, 60.dp)
                            .clickable { premiumOption.value = 2 },
                        border = BorderStroke(2.dp, if(premiumOption.value == 2) MainColor else DarkGreen),
                        colors = CardDefaults.cardColors(containerColor = DarkGreen),
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start) {
                            RadioButton(
                                selected = (premiumOption.value == 2),
                                onClick = { premiumOption.value = 2 },
                                colors = RadioButtonDefaults.colors(
                                    selectedColor = MainColor
                                ))
                            Column {
                                Text(
                                    text = "1 Year", style = TextStyle(
                                        fontSize = 18.sp,
                                        color = White,
                                    )
                                )

                                Text(
                                    text = "First 3 days free, then $529,99/year", style = TextStyle(
                                        fontSize = 14.sp,
                                        color = WhiteTransparent,
                                    )
                                )
                            }
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.Top,
                                horizontalAlignment = Alignment.End
                            ) {
                                Card(
                                    colors = CardDefaults.cardColors(containerColor = MainColor),
                                    shape = RoundedCornerShape(6.dp),
                                ) {
                                    Text(
                                        text = "Save %50", style = TextStyle(
                                            fontSize = 12.sp,
                                            color = White,
                                        ),
                                        modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp),
                                    )
                                }
                            }
                        }
                    }
                }

            }
        }

        //Altta kalan alan Button ve Açıklama yer alıyor
        //%20 yer kaplıyor
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(20f),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Button(
                onClick = {
                    freeTrialAlertVisible.value = true
                },
                colors = ButtonDefaults.buttonColors(containerColor = MainColor),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .padding(all = 10.dp)
                    .width(380.dp)
                    .height(60.dp)
            ) {
                Text(text = onBoardModel.buttonTitle, color = White, fontSize = 16.sp)
            }

            Text(text = onBoardModel.description,
                style = TextStyle(
                    fontSize = 11.sp,
                    color = WhiteTransparent,
                    textAlign = TextAlign.Center,
                ),
                modifier = Modifier
                    .padding(start = 32.dp, end = 32.dp)
            )
        }
        if(freeTrialAlertVisible.value){
            AlertDialog(
                onDismissRequest = { freeTrialAlertVisible.value = false },
                title = {
                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                        FreeTrialAnimation(animationResource = R.raw.free_trial_animation1)
                        FreeTrialAnimation(animationResource = R.raw.free_trial_animation2)
                    }
                },
                text = {
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                        Text(
                            text = stringResource(id = R.string.freeTrialAlertDescription),
                            style = TextStyle(
                                fontSize = 16.sp,
                                color = Black,
                            ),
                            textAlign = TextAlign.Center
                        )
                    }
                },
                confirmButton = {
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                        Button(
                            onClick = {
                                freeTrialAlertVisible.value = false
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = MainColor),
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier
                                .padding(all = 10.dp)
                                .width(250.dp)
                                .height(60.dp)
                        ) {
                            Text(text = stringResource(id = R.string.freeTrialAlertButton), color = White, fontSize = 16.sp)
                        }
                    }
                }
            )
        }
    }
}