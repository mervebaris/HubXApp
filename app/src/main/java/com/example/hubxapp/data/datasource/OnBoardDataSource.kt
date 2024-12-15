package com.example.hubxapp.data.datasource


import com.example.hubxapp.data.entity.OnBoardView
import com.example.hubxapp.room.OnBoardViewDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class OnBoardDataSource(var onBoardViewDao: OnBoardViewDao) {
    suspend fun checkViewedStatus() : OnBoardView = withContext(Dispatchers.IO) {
        return@withContext onBoardViewDao.checkViewedStatus()
    }

    suspend fun confirmViewedStatus(){
        onBoardViewDao.confirmViewedStatus(OnBoardView(1,1))
    }
}