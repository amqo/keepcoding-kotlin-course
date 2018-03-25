package com.kotlin.albertoquiros.gangame.rated

import android.support.v7.widget.RecyclerView
import com.amqo.commons.BR
import com.amqo.commons.BaseListFragment
import com.amqo.commons.DataBindingRecyclerAdapter
import com.kotlin.albertoquiros.gangame.Deal
import com.kotlin.albertoquiros.gangame.R
import com.kotlin.albertoquiros.gangame.TopGame
import com.kotlin.albertoquiros.gangame.data.GangameDataSource

class TopRatedFragment : BaseListFragment() {

    override fun getAdapter(): RecyclerView.Adapter<*> =
            DataBindingRecyclerAdapter<Deal>(BR.topGame, R.layout.item_top_game)

    override fun onResume() {
        super.onResume()
        showTopOwnedGames()
    }

    private fun showTopOwnedGames() {
        GangameDataSource.getTopRatedGames().subscribe({ topRatedGames ->
            replaceItems(topRatedGames)
        }, { error ->
            showError(error)
        })
    }

    private fun replaceItems(topRatedGames: List<TopGame>) {
        with(listAdapter as DataBindingRecyclerAdapter<TopGame>) {
            items.clear()
            items.addAll(topRatedGames)
            notifyDataSetChanged()
        }
    }

    private fun showError(error: Throwable) {
        error.printStackTrace()
    }
}
