package com.kotlin.albertoquiros.gangame.deals

import android.support.v7.widget.RecyclerView
import com.amqo.commons.BR
import com.amqo.commons.BaseListFragment
import com.amqo.commons.DataBindingRecyclerAdapter
import com.kotlin.albertoquiros.gangame.Deal
import com.kotlin.albertoquiros.gangame.R
import com.kotlin.albertoquiros.gangame.data.GangameDataSource

class DealsFragment : BaseListFragment() {

    override fun getAdapter(): RecyclerView.Adapter<*> =
            DataBindingRecyclerAdapter<Deal>(BR.deal, R.layout.item_deal)

    override fun onResume() {
        super.onResume()
        showDeals()
    }

    private fun showDeals() {
        GangameDataSource.getDeals().subscribe({ deals ->
            replaceItems(deals)
        }, { error ->
            showError(error)
        })
    }

    private fun replaceItems(deals: List<Deal>) {
        with(listAdapter as DataBindingRecyclerAdapter<Deal>) {
            items.clear()
            items.addAll(deals)
            notifyDataSetChanged()
        }
    }

    private fun showError(error: Throwable) {
        error.printStackTrace()
    }
}



