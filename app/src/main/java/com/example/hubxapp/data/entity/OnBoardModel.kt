package com.example.hubxapp.data.entity

//Content model for each page
//Content will be displayed from this model, of course, if all pages have the same design.
data class OnBoardModel(
    val title: String,
    val subtitle: String,
    val image: Int,
    val buttonTitle: String,
    val description: String
)
