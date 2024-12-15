package com.example.hubxapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hubxapp.data.entity.OnBoardView
import com.example.hubxapp.data.repository.OnBoardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardScreenViewModel @Inject constructor(var onBoardRepository:OnBoardRepository) : ViewModel() {
    var onBoardView = MutableLiveData<OnBoardView>()

    init {
        checkViewedStatus()
    }

    fun checkViewedStatus(){
        CoroutineScope(Dispatchers.Main).launch {
            onBoardView.value = onBoardRepository.checkViewedStatus()
        }
    }

    fun confirmViewedStatus(){
        CoroutineScope(Dispatchers.Main).launch {
            onBoardRepository.confirmViewedStatus()
        }
    }
}