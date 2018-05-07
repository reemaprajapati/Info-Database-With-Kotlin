package com.example.reema.kotlindemo.model

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.example.reema.kotlindemo.data.entity.Info

/**
 * Created by reema on 4/20/18.
 */
class InfoViewModel : BaseObservable() {

    lateinit var info: Info

    @Bindable
    fun getName(): String{
        return info.name
    }

    @Bindable
    fun getAddress(): String{
        return info.address
    }

    @Bindable
    fun getImagePath(): String{
        return info.file_path
    }

}