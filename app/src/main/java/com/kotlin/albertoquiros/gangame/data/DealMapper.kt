package com.kotlin.albertoquiros.gangame.data

import com.kotlin.albertoquiros.gangame.Deal

object DealMapper {

    fun fromSdk(deal: com.amqo.sdk.Deal): Deal =
            Deal(deal.title,
                    deal.salePrice,
                    deal.normalPrice,
                    deal.metacriticScore,
                    deal.steamRating,
                    deal.thumb)
}