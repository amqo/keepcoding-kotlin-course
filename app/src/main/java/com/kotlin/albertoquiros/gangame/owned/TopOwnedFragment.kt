package com.kotlin.albertoquiros.gangame.owned

import android.support.v7.widget.RecyclerView
import com.amqo.commons.BR
import com.amqo.commons.BaseListFragment
import com.amqo.commons.DataBindingRecyclerAdapter
import com.kotlin.albertoquiros.gangame.Deal
import com.kotlin.albertoquiros.gangame.R
import com.kotlin.albertoquiros.gangame.TopGame
import com.kotlin.albertoquiros.gangame.data.GangameDataSource

class TopOwnedFragment : BaseListFragment() {

    override fun getAdapter(): RecyclerView.Adapter<*> =
            DataBindingRecyclerAdapter<Deal>(BR.topGame, R.layout.item_top_game)

    override fun onResume() {
        super.onResume()
        showTopOwnedGames()
    }

    private fun showTopOwnedGames() {
        GangameDataSource.getMostOwnedGames().subscribe({ topOwnedGames ->
            replaceItems(topOwnedGames)
        }, { error ->
            showError(error)
        })
    }

    private fun replaceItems(topOwnedGames: List<TopGame>) {
        with(listAdapter as DataBindingRecyclerAdapter<TopGame>) {
            items.clear()
            items.addAll(topOwnedGames)
            notifyDataSetChanged()
        }
    }

    private fun showError(error: Throwable) {
        error.printStackTrace()
    }
}
