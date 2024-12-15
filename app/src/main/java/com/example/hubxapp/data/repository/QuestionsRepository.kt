package com.example.hubxapp.data.repo

import com.example.hubxapp.data.datasource.QuestionsDataSource

import com.example.hubxapp.data.entity.Questions

class QuestionsRepository(var questionsDataSource: QuestionsDataSource) {
    //We are getting the data from QuestionsDataSource
    suspend fun loadQuestions(): List<Questions> = questionsDataSource.loadQuestions()
}