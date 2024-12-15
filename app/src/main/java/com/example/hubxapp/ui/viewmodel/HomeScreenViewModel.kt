package com.example.hubxapp.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hubxapp.data.entity.Categories
import com.example.hubxapp.data.entity.Questions
import com.example.hubxapp.data.repo.CategoriesRepository
import com.example.hubxapp.data.repo.QuestionsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(var categoriesRepository: CategoriesRepository,var questionsRepository: QuestionsRepository) : ViewModel() {
    var categoriesList = MutableLiveData<List<Categories>>()
    var questionsList = MutableLiveData<List<Questions>>()

    init {
        loadCategories()
        loadQuestions()
    }

    fun loadCategories(){
        CoroutineScope(Dispatchers.Main).launch {
            categoriesList.value = categoriesRepository.loadCategories()
        }
    }

    fun searchCategories(searchWord:String){
        CoroutineScope(Dispatchers.Main).launch {
            categoriesList.value = categoriesRepository.searchCategories(searchWord)
        }
    }

    fun loadQuestions(){
        CoroutineScope(Dispatchers.Main).launch {
            questionsList.value = questionsRepository.loadQuestions()
        }
    }
}
