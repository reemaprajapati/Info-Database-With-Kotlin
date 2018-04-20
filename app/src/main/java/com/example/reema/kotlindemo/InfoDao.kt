package com.example.reema.kotlindemo

import android.arch.persistence.room.*
import com.example.reema.kotlindemo.entity.Info

/**
 * Created by reema on 4/5/18.
 */
@Dao
interface InfoDao {
    @Query("SELECT * from info")
    fun getAll(): List<Info>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertInfo(info: Info)

    @Delete
    fun deleteInfo(info: Info)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun UpdateInfo(info: Info)

}