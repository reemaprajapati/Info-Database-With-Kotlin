package com.example.reema.kotlindemo.adapter

import android.databinding.BindingAdapter
import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide
import java.io.File

/**
 * Created by reema on 4/25/18.
 */

@BindingAdapter("app:imagepath")
fun getImage(imageView: ImageView, filePath: String) {
    Glide.with(imageView.context)
            .load(Uri.parse(filePath))
            .into(imageView);
}
