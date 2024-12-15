package com.example.hubxapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hubxapp.data.entity.OnBoardView

@Database(entities = [OnBoardView::class], version = 1)
abstract class Database : RoomDatabase() {
    abstract fun getOnBoardViewDao() : OnBoardViewDao
}