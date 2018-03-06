package com.kotlin.albertoquiros.gangame.deals

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View
import com.amqo.commons.BR
import com.amqo.commons.BaseListFragment
import com.amqo.commons.DataBindingRecyclerAdapter
import com.kotlin.albertoquiros.gangame.Deal
import com.kotlin.albertoquiros.gangame.R

class DealsFragment : BaseListFragment() {

    override fun getAdapter(): RecyclerView.Adapter<*> =
            DataBindingRecyclerAdapter<Deal>(BR.deal, R.layout.item_deal)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (listAdapter as DataBindingRecyclerAdapter<Deal>).items.addAll(getDummyDeals())
        listAdapter.notifyDataSetChanged()
    }

    private fun getDummyDeals(): ArrayList<Deal> =
            arrayListOf(Deal("Counter Strike", 0.99F, 9.99F,
                    80, 80, "http://cdn.akamai.steamstatic.com/steam/apps/10/capsule_184x69.jpg"))
}
