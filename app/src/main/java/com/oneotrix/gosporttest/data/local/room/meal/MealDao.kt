package com.oneotrix.gosporttest.data.local.room.meal

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MealDao {
    @Query("SELECT * FROM meal")
    fun getAll(): Flow<List<Meal>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(meals: List<Meal>)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMeal(meal: Meal)
    @Query("SELECT * FROM meal WHERE category =:category")
    fun filterByCategory(category: String): Flow<List<Meal>>
}