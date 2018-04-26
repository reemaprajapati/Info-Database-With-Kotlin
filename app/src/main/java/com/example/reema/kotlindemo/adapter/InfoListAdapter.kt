package com.example.reema.kotlindemo.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.reema.kotlindemo.R
import com.example.reema.kotlindemo.databinding.ItemInfoListBinding
import com.example.reema.kotlindemo.entity.Info
import com.example.reema.kotlindemo.model.InfoViewModel
import java.util.*


/**
 * Created by reema on 4/20/18.
 */
class InfoListAdapter(var context: Context) : RecyclerView.Adapter<InfoListAdapter.InfoViewHolder>() {

    private var data: List<Info> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoViewHolder {
        val binding: ItemInfoListBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_info_list, parent, false);
        return InfoViewHolder(binding)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: InfoViewHolder, position: Int) = holder.setViewModel(data[position])

    fun setData(data: List<Info>) {
        this.data = data
        notifyDataSetChanged()
    }

    inner class InfoViewHolder(internal var binding: ItemInfoListBinding) : RecyclerView.ViewHolder(binding.getRoot()) {
        private val viewModel: InfoViewModel

        init {
            viewModel = InfoViewModel()
            binding.viewmodel = viewModel
        }

        fun setViewModel(info: Info) {
            viewModel.info = info
            Log.e("ViewModel", info.name)
        }
    }


}

