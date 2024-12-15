package com.example.hubxapp.data.entity

data class Image(var id:Int,
                 var name:String,
                 var alternativeText: String? = null,
                 var caption: String? = null,
                 var width: Int,
                 var height: Int,
                 var formatS: String? = null,
                 var hash:String,
                 var ext: String,
                 var mime: String,
                 var size: Double,
                 var url:String,
                 var previewUrl:String? = null,
                 var provider: String,
                 var provider_metadata: String? = null,
                 var createdAt: String,
                 var updatedAt: String) {

}