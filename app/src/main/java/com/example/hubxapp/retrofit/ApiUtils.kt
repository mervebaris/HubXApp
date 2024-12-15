package com.example.hubxapp.retrofit

class ApiUtils {
    companion object{
        val BASE_URL = "https://dummy-api-jtg6bessta-ey.a.run.app "

        fun getCategoriesDao() : CategoriesDao {
            return RetrofitClient.getClient(BASE_URL).create(CategoriesDao::class.java)
        }

        fun getQuestionsDao() : QuestionsDao {
            return RetrofitClient.getClient(BASE_URL).create(QuestionsDao::class.java)
        }

    }
}