package com.example.businesscard.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.businesscard.entity.User

@Dao
interface UserDao {
    // ユーザー登録
    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertUser(user: User): Long
    // 電話番号とパスワードが存在するか確認
    @Query("SELECT * FROM User WHERE phone LIKE :phone AND password LIKE :password")
    fun readLoginData(phone: String, password: String):User
    // ユーザーの情報取得
    @Query("select * from user where id Like :id")
    fun getUserDataDetails(id:Long):User
    // ユーザー情報を消す
    @Query("DELETE FROM User WHERE id = :id")
    fun deleteUser(id: Long): Int
}