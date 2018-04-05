package com.example.reema.kotlindemo

import android.arch.persistence.room.Room
import android.content.Context
import android.os.Bundle
import android.support.design.widget.BottomSheetDialog
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import com.example.reema.kotlindemo.database.InfoDatabase
import com.example.reema.kotlindemo.entity.Info
import com.facebook.stetho.Stetho
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val DATABASE_NAME = "info_database"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Stetho.initializeWithDefaults(this);

        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        setUpLayout()

        val infoDatabase = getDatabase(applicationContext)
        insertData(infoDatabase)
    }

    fun setUpLayout() {
        val view = LayoutInflater.from(this).inflate(R.layout.layout_bottom_sheet, null)
        val dialog = BottomSheetDialog(this)
        dialog.setContentView(view)
        fab.setOnClickListener { view ->
            dialog.show()
        }
    }

    fun getDatabase(context: Context): InfoDatabase {
        val infoDatabase: InfoDatabase = Room
                .databaseBuilder(
                        context,
                        InfoDatabase::class.java, DATABASE_NAME
                )
                .allowMainThreadQueries()
                .build()
        return infoDatabase
    }

    fun insertData(infoDatabase: InfoDatabase): Unit {
        infoDatabase.daoAccess().insertInfo(Info(0, "fasd", "adf", "afdsa"))
    }


}
