package com.example.reema.kotlindemo.ui

import android.arch.lifecycle.Observer
import android.arch.persistence.room.Room
import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.BottomSheetDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import com.bumptech.glide.Glide
import com.example.reema.kotlindemo.R
import com.example.reema.kotlindemo.ui.adapter.InfoListAdapter
import com.example.reema.kotlindemo.data.database.InfoDatabase
import com.example.reema.kotlindemo.databinding.ActivityMainBinding
import com.example.reema.kotlindemo.data.entity.Info
import com.facebook.stetho.Stetho
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.view.*
import kotlinx.android.synthetic.main.layout_bottom_sheet.view.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val DATABASE_NAME = "info_database"
    var name = ""
    var address = ""
    var imageUri = ""
    lateinit var view: View
    lateinit var infoDatabase: InfoDatabase
    lateinit var dialog: BottomSheetDialog
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: InfoListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Stetho.initializeWithDefaults(this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar(toolbar)
        infoDatabase = getDatabase(applicationContext)
        setUpLayout()
        setUpRecyclerView()
        getData()
//        infoDatabase = getDatabase(applicationContext)
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
            getData()
        }
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            if (requestCode == 1) {
                var currentImage: Uri = data!!.data
                imageUri = currentImage.toString()
            }
            setImage()
        }
    }

    fun setUpRecyclerView() {
        content_main.recyclerview.layoutManager = LinearLayoutManager(this)
        adapter = InfoListAdapter(this)
        content_main.recyclerview.adapter = adapter
    }

//    fun insertData(infoDatabase: InfoDatabase): Unit {
//        infoDatabase.daoAccess().insertInfo(Info(0, "fasd", "adf", "afdsa"))
//    }

    fun getData() {
//           adapter.setData(infoDatabase.daoAccess().getAll().d)
        infoDatabase.daoAccess().getAll().observe(this, Observer<List<Info>> { list ->
            setAdapter(list!!)
        })
    }


    fun setAdapter(list: List<Info>) {
        adapter.setData(list)
    }


    fun setImage() {
        Glide.with(this).load(Uri.parse(imageUri)).into(view.image_preview)
    }
}
