package com.example.hubxapp.room

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import com.example.hubxapp.data.entity.OnBoardView

@Dao
interface OnBoardViewDao {
    @Query("SELECT * FROM onBoardView WHERE id = 1")
    suspend fun checkViewedStatus() : OnBoardView

    @Update
    suspend fun confirmViewedStatus(onBoardView: OnBoardView)
}