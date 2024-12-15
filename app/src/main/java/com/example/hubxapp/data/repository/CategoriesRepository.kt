package com.example.hubxapp.data.repo

import com.example.hubxapp.data.datasource.CategoriesDataSource
import com.example.hubxapp.data.entity.Categories

class CategoriesRepository(var categoriesDataSource: CategoriesDataSource) {
    suspend fun loadCategories() : List<Categories> = categoriesDataSource.loadCategories()
}