package com.example.qaydlar.Db

import com.example.qaydlar.Models.User

interface DbServiceInterface {

    fun addContact(user: User)
    fun deleteContact(user: User)
    fun updateContact(user: User):Int
    fun getAllContact():List<User>
}