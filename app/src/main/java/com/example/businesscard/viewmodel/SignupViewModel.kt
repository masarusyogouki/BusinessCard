package com.example.businesscard.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.businesscard.dao.UserDao
import com.example.businesscard.database.AppDatabase
import com.example.businesscard.entity.User
import kotlinx.coroutines.launch

class SignupViewModel(
    private val userDao: UserDao,
    var email: String = "",
    var phone: String = "",
    var password: String = "",
): ViewModel() {
    fun signup(
        email: String,
        phone: String,
        password: String,
    ) {
        val user = User(
            email = email,
            phone = phone,
            password = password
        )
        viewModelScope.launch {
            userDao.insertUser(user)
        }
    }
}