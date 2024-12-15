package com.example.hubxapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "onBoardView")
data class OnBoardView(@PrimaryKey(autoGenerate = true)
                       @ColumnInfo(name = "id") @NotNull var id:Int,
                       @ColumnInfo(name = "status") @NotNull var status:Int) {
}



