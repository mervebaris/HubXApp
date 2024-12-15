package com.example.hubxapp.retrofit

import com.example.hubxapp.data.entity.Questions
import retrofit2.http.GET

interface QuestionsDao {
    //https://dummy-api-jtg6bessta-ey.a.run.app/getQuestions
    //https://dummy-api-jtg6bessta-ey.a.run.app/ -> base url
    //getQuestions -> api url

    @GET("getQuestions")
    suspend fun loadQuestions(): List<Questions>

}
