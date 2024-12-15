package com.example.hubxapp.data.entity

//Her sayfa için içerik modeli
//Bu modelden içerikler gösterilecek tabi bütün sayfalar aynı tasarımdaysa
data class OnBoardModel(
    val title: String,
    val subtitle: String,
    val image: Int,
    val buttonTitle: String,
    val description: String
)
