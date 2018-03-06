package com.kotlin.albertoquiros.gangame.rated

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View
import com.amqo.commons.BR
import com.amqo.commons.BaseListFragment
import com.amqo.commons.DataBindingRecyclerAdapter
import com.kotlin.albertoquiros.gangame.Deal
import com.kotlin.albertoquiros.gangame.R
import com.kotlin.albertoquiros.gangame.TopGame

class TopRatedFragment : BaseListFragment() {

    override fun getAdapter(): RecyclerView.Adapter<*> =
            DataBindingRecyclerAdapter<Deal>(BR.topGame, R.layout.item_top_game)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (listAdapter as DataBindingRecyclerAdapter<TopGame>).items.addAll(getDummyTopOwned())
        listAdapter.notifyDataSetChanged()
    }

    private fun getDummyTopOwned(): ArrayList<TopGame> =
            arrayListOf(TopGame("Counter Strike", 13407338, 80,
                    "Valve", 9.99F, 1,"http://cdn.akamai.steamstatic.com/steam/apps/10/capsule_184x69.jpg"))
}
