package com.example.reema.kotlindemo

import android.os.Parcel
import android.os.Parcelable
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.reema.kotlindemo.entity.Info

/**
 * Created by reema on 4/6/18.
 */
public class InfoAdapter(var info: Info) : RecyclerView.Adapter<InfoAdapter.InfoViewHolder>() {


    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: ?, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class InfoViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    }

}