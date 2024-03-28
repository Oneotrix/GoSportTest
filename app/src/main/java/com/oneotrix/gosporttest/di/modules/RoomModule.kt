package com.oneotrix.gosporttest.di.modules

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.oneotrix.gosporttest.data.local.room.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {

    private lateinit var db: AppDatabase

    @Provides
    @Singleton
    fun provideDatabase(
        context: Context
    ): AppDatabase {
        synchronized(AppDatabase::class) {
            db = Room.databaseBuilder(
                context = context,
                AppDatabase::class.java,
                "go-sport")
                .build()
        }

        return db
    }

}