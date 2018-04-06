package com.example.reema.kotlindemo

import android.arch.persistence.room.Room
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.BottomSheetDialog
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import com.example.reema.kotlindemo.database.InfoDatabase
import com.example.reema.kotlindemo.entity.Info
import com.facebook.stetho.Stetho
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_bottom_sheet.view.*

class MainActivity : AppCompatActivity(), View.OnClickListener {


    private val DATABASE_NAME = "info_database"
    var name = ""
    var address = ""
    var imageUri = ""
    lateinit var view: View
    lateinit var infoDatabase: InfoDatabase
    lateinit var dialog : BottomSheetDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Stetho.initializeWithDefaults(this);
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        setUpLayout()
        setUpRecyclerView()

        infoDatabase = getDatabase(applicationContext)
//        insertData(infoDatabase)
    }

    override fun onClick(p0: View?) {
        if (p0 == view.image_add) {
            Log.d("Activity", "Clicked")
            var intent = Intent()
            intent.setType("image/*")
            intent.setAction(Intent.ACTION_GET_CONTENT)
            startActivityForResult(Intent.createChooser(intent, "SELECT PICTURE"), 1)
        }

        if (p0 == view.button_add) {
            name = view.text_name.text.toString()
            address = view.text_address.text.toString()
            infoDatabase.daoAccess().insertInfo(Info(name, address, imageUri))
            dialog.dismiss()
        }
    }

    fun setUpRecyclerView(){

    }

    fun setUpLayout() {
        view = LayoutInflater.from(this).inflate(R.layout.layout_bottom_sheet, null)
        dialog = BottomSheetDialog(this)
        dialog.setContentView(view)
        fab.setOnClickListener { view ->
            dialog.show()
        }
        view.image_add.setOnClickListener(this)
        view.button_add.setOnClickListener(this)

//        view.image_add.setOnClickListener({
//
//        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            if (requestCode == 1) {
                var currImageURI: Uri = data!!.getData()
                imageUri = currImageURI.toString()
            }
        }
    }

    fun getDatabase(context: Context): InfoDatabase {
        var infoDatabase: InfoDatabase = Room
                .databaseBuilder(
                        context,
                        InfoDatabase::class.java, DATABASE_NAME
                )
                .allowMainThreadQueries()
                .build()
        return infoDatabase
    }

    fun insertData(infoDatabase: InfoDatabase): Unit {
        infoDatabase.daoAccess().insertInfo(Info("fasd", "adf", "afdsa"))
    }
}
