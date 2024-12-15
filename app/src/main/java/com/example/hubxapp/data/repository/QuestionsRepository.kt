package com.example.hubxapp.data.repo

import com.example.hubxapp.data.datasource.QuestionsDataSource

import com.example.hubxapp.data.entity.Questions

class QuestionsRepository(var questionsDataSource: QuestionsDataSource) {
    // QuestionsDataSource'dan veriyi alıyoruz
    suspend fun loadQuestions(): List<Questions> = questionsDataSource.loadQuestions()
}