package com.amqo.commons

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView

class DataBindingViewHolder<in T>(private val itemVariableId: Int, private val binding: ViewDataBinding)
    : RecyclerView.ViewHolder(binding.root) {

    fun bindItem(item: T) {
        binding.setVariable(itemVariableId, item)
        binding.executePendingBindings()
    }
}
