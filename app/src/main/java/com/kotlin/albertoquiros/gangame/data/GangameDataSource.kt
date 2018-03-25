package com.kotlin.albertoquiros.gangame.data

import com.amqo.sdk.GangameApiService
import com.kotlin.albertoquiros.gangame.TopGame
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object GangameDataSource {

    val apiService = GangameApiService()

    fun getDeals() : Observable<ArrayList<com.kotlin.albertoquiros.gangame.Deal>> =
            apiService.apiClient.getDealsObservable()
                    .map { listDeal -> ArrayList(listDeal.map { deal -> DealMapper.fromSdk(deal) })}
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())

    fun getTopRatedGames() : Observable<ArrayList<TopGame>> =
            apiService.apiClient.getTopRatedGamesObservable()
                    .map { listGames -> ArrayList(listGames.mapIndexed { index, game ->
                        TopGameMapper.fromSdk(game, index + 1) })}
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())

    fun getMostOwnedGames() : Observable<ArrayList<TopGame>> =
            apiService.apiClient.getMostOwnedGamesObservable()
                    .map { listGames -> ArrayList(listGames.mapIndexed { index, game ->
                        TopGameMapper.fromSdk(game, index + 1) })}
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
}