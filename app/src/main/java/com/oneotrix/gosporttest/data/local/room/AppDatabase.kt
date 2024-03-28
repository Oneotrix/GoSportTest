package com.oneotrix.gosporttest.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.oneotrix.gosporttest.data.local.room.category.Category
import com.oneotrix.gosporttest.data.local.room.category.CategoryDao
import com.oneotrix.gosporttest.data.local.room.meal.Meal
import com.oneotrix.gosporttest.data.local.room.meal.MealDao

@Database(entities = [Meal::class, Category::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun mealDao(): MealDao
    abstract fun categoryDao(): CategoryDao

}