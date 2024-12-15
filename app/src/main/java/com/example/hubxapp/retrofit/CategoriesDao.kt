package com.example.hubxapp.retrofit

import com.example.hubxapp.data.entity.CategoriesResponse
import retrofit2.http.GET

interface CategoriesDao {
    //https://dummy-api-jtg6bessta-ey.a.run.app/getCategories
    //https://dummy-api-jtg6bessta-ey.a.run.app -> base url
    //getCategories -> api url

    @GET("getCategories")
    suspend fun loadCategories() : CategoriesResponse
}