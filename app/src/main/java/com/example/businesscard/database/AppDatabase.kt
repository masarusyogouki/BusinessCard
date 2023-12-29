package com.example.businesscard.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
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

    companion object{
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if(instance==null){
            instance = Room.databaseBuilder(context, AppDatabase::class.java, "DatabaseUser")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
            }
            return instance!!
        }
    }
}