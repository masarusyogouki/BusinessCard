package com.example.businesscard.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    val uid: Int? = null,

    @ColumnInfo("username")
    var fullname: String? = null,

    @ColumnInfo("Email")
    var email: String? = null,

    @ColumnInfo("Password")
    var pass: String? = null,
)