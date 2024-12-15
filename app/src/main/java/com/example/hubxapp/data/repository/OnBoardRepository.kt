package com.example.hubxapp.data.repository

import com.example.hubxapp.data.datasource.OnBoardDataSource
import com.example.hubxapp.data.entity.OnBoardView

class OnBoardRepository(var onBoardDataSource:OnBoardDataSource) {
    suspend fun checkViewedStatus() : OnBoardView = onBoardDataSource.checkViewedStatus()
    suspend fun confirmViewedStatus() = onBoardDataSource.confirmViewedStatus()
}