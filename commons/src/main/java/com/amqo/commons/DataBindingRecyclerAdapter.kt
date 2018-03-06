package com.amqo.commons

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class DataBindingRecyclerAdapter<T>(val itemVariableId: Int, val layoutResId: Int)
    : RecyclerView.Adapter<DataBindingViewHolder<T>>() {

    val items: MutableList<T> = mutableListOf()

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBindingViewHolder<T> {
        val binding: ViewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                layoutResId, parent, false)
        return DataBindingViewHolder(itemVariableId, binding)
    }

    override fun onBindViewHolder(holder: DataBindingViewHolder<T>, position: Int) =
            holder.bindItem(items[position])
}
