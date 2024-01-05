package com.example.businesscard.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Long=0,
    @ColumnInfo(name = "family_name")
    var familyName: String?="",
    @ColumnInfo(name = "last_name")
    var lastName: String?="",
    @ColumnInfo(name = "email")
    var email: String?="",
    @ColumnInfo(name = "password")
    var password: String?="",
    @ColumnInfo(name = "company")
    var company: String?="",
    @ColumnInfo(name = "address")
    var address: String?="",
    @ColumnInfo(name = "phone")
    var phone: String?="",
    @ColumnInfo(name = "position")
    var position: String?="",
)