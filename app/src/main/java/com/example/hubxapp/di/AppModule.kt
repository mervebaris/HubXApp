package com.example.hubxapp.di

import android.content.Context
import androidx.room.Room
import com.example.hubxapp.data.datasource.CategoriesDataSource
import com.example.hubxapp.data.datasource.OnBoardDataSource
import com.example.hubxapp.data.datasource.QuestionsDataSource
import com.example.hubxapp.data.repo.CategoriesRepository
import com.example.hubxapp.data.repo.QuestionsRepository
import com.example.hubxapp.data.repository.OnBoardRepository
import com.example.hubxapp.retrofit.ApiUtils
import com.example.hubxapp.retrofit.CategoriesDao
import com.example.hubxapp.retrofit.QuestionsDao
import com.example.hubxapp.room.Database
import com.example.hubxapp.room.OnBoardViewDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideOnBoardRepository(onBoardDataSource: OnBoardDataSource) : OnBoardRepository {
        return OnBoardRepository(onBoardDataSource)
    }

    @Provides
    @Singleton
    fun provideOnBoardDataSource(onBoardViewDao: OnBoardViewDao) : OnBoardDataSource {
        return OnBoardDataSource(onBoardViewDao)
    }

    @Provides
    @Singleton
    fun provideOnBoardViewDao(@ApplicationContext context: Context) : OnBoardViewDao {
        val db = Room.databaseBuilder(context,Database::class.java,"hubx_app.sqlite")
            .createFromAsset("hubx_app.sqlite").build()
        return db.getOnBoardViewDao()
    }
    @Provides
    @Singleton
    fun provideQuestionsRepository (questionsDataSource: QuestionsDataSource) : QuestionsRepository {
        return  QuestionsRepository(questionsDataSource)
    }

    @Provides
    @Singleton
    fun provideQuestionsDataSource(questionsDao: QuestionsDao) : QuestionsDataSource {
        return  QuestionsDataSource(questionsDao)
    }
    @Provides
    @Singleton
    fun provideQuestionsDao() : QuestionsDao {
        return ApiUtils.getQuestionsDao()
    }
    @Provides
    @Singleton
    fun provideCategoriesRepository (categoriesDataSource: CategoriesDataSource) : CategoriesRepository {
        return  CategoriesRepository(categoriesDataSource)
    }

    @Provides
    @Singleton
    fun provideCategoriesDataSource(categoriesDao: CategoriesDao) : CategoriesDataSource {
        return  CategoriesDataSource(categoriesDao)
    }
    @Provides
    @Singleton
    fun provideCategoriesDao() : CategoriesDao {
        return ApiUtils.getCategoriesDao()
    }
}