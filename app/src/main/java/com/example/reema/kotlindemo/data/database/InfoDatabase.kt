package com.example.reema.kotlindemo.data.database

import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.Database
import com.example.reema.kotlindemo.data.dao.InfoDao
import com.example.reema.kotlindemo.data.entity.Info


/**
 * Created by reema on 4/5/18.
 */
@Database(entities = arrayOf(Info::class), version = 1, exportSchema = false)
abstract class InfoDatabase : RoomDatabase() {
    abstract fun daoAccess(): InfoDao
}