package com.example.hubxapp.data.datasource

import com.example.hubxapp.data.entity.Questions
import com.example.hubxapp.retrofit.QuestionsDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class QuestionsDataSource(var questionsDao: QuestionsDao) {
    suspend fun loadQuestions() : List<Questions> = withContext(Dispatchers.IO){
        return@withContext questionsDao.loadQuestions()
    }
}