package com.example.reema.kotlindemo.data.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by reema on 4/5/18.
 */
@Entity(tableName = "info")
data class Info(@ColumnInfo(name = "name") var name: String, @ColumnInfo(name = "address") var address: String, @ColumnInfo(name = "file_path") var file_path: String) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "person_id")
    var person_id: Int = 0

}
