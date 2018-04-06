package com.example.reema.kotlindemo.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by reema on 4/5/18.
 */
@Entity(tableName = "info")
public class Info {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "person_id")
    var person_id: Int = 0

    @ColumnInfo(name = "name")
    var name: String = ""

    @ColumnInfo(name = "address")
    var address: String = ""

    @ColumnInfo(name = "file_path")
    var file_path = ""

    constructor(name: String, address: String, file_path: String) {
//        this.person_id = person_id
        this.name = name
        this.address = address
        this.file_path = file_path
    }
}
