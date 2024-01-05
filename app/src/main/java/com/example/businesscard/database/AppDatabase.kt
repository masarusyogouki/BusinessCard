package com.example.businesscard.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.businesscard.entity.User
import com.example.businesscard.dao.UserDao

@Database(
    entities = [User::class],
    version = 1,
    exportSchema = true,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}