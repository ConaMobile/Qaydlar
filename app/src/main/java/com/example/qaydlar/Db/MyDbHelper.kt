package com.example.qaydlar.Db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.qaydlar.Models.User

class MyDbHelper(context: Context): SQLiteOpenHelper(context, Constant.DB_NAME, null, Constant.TABLE_VERSION),
DbServiceInterface{
    override fun onCreate(db: SQLiteDatabase?) {
        val query = "create table ${Constant.TABLE_NAME} (${Constant.ID} integer not null primary key autoincrement unique, ${Constant.NAME} text not null)"
        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("drop table if exists ${Constant.TABLE_NAME}")
        onCreate(db)
    }

    override fun addContact(user: User) {
        val database = this.writableDatabase
        val contentValue = ContentValues()
        contentValue.put(Constant.NAME, user.name)
        database.insert(Constant.TABLE_NAME, null, contentValue)
        database.close()
    }

    override fun deleteContact(user: User) {
        val database = this.writableDatabase
        database.delete(Constant.TABLE_NAME, "${Constant.ID} =?", arrayOf("${user.id}"))
    }

    override fun updateContact(user: User): Int {
        return 0
    }

    override fun getAllContact(): List<User> {
        val list = ArrayList<User>()
        val query = "select * from ${Constant.TABLE_NAME}"
        val database = this.readableDatabase
        val cursor = database.rawQuery(query, null)

        if (cursor.moveToFirst()){
            do {
                val id = cursor.getInt(0)
                val name = cursor.getString(1)

                val user = User(id, name)
                list.add(user)
            }while (cursor.moveToNext())
        }
        return list
    }

}