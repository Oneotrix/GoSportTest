package com.oneotrix.gosporttest.data.local.room.category

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Category(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String,
)