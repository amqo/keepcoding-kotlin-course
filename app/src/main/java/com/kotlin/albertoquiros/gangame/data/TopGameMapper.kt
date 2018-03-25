package com.kotlin.albertoquiros.gangame.data

import com.kotlin.albertoquiros.gangame.TopGame


object TopGameMapper {

    fun fromSdk(topGame: com.amqo.sdk.TopGame, position: Int): TopGame =
            TopGame(topGame.title,
                    topGame.owners,
                    topGame.steamRating,
                    topGame.publisher,
                    topGame.price,
                    position,
                    topGame.thumb)
}