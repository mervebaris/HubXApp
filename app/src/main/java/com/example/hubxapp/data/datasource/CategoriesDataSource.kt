package com.example.hubxapp.data.datasource

import com.example.hubxapp.data.entity.Categories
import com.example.hubxapp.retrofit.CategoriesDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CategoriesDataSource(var categoriesDao: CategoriesDao) {
    suspend fun loadCategories() : List<Categories> = withContext(Dispatchers.IO){
        return@withContext categoriesDao.loadCategories().data
    }

    suspend fun searchCategories(searchWord: String): List<Categories> = withContext(Dispatchers.IO) {
        val allCategories = categoriesDao.loadCategories().data
        return@withContext allCategories.filter {
            it.name.contains(searchWord, ignoreCase = true)
        }
    }
}