package com.amqo.sdk

import com.google.gson.Gson
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ModelUnitTest {

    val JSON_DEAL = "{" +
            "\"internalName\": \"TOKITORI\"," +
            "\"title\": \"Toki Tori\"," +
            "\"metacriticLink\": \"/game/pc/toki-tori\"," +
            "\"dealID\": \"Ws%2B0c2sUsDPpqLQB7ToTCNhVsyc5uBSRe50G3FFDt58%3D\"," +
            "\"storeID\": \"1\"," +
            "\"gameID\": \"574\"," +
            "\"salePrice\": \"0.49\"," +
            "\"normalPrice\": \"4.99\"," +
            "\"isOnSale\": \"1\"," +
            "\"savings\": \"90.180361\"," +
            "\"metacriticScore\": \"80\"," +
            "\"steamRatingText\": \"Very Positive\"," +
            "\"steamRatingPercent\": \"88\"," +
            "\"steamRatingCount\": \"1289\"," +
            "\"releaseDate\": 1264636800," +
            "\"lastChange\": 1499708988," +
            "\"dealRating\": \"9.2\"," +
            "\"thumb\": \"http://cdn.akamai.steamstatic.com/steam/apps/38700/capsule_sm_120.jpg?t=1488471030\"" +
            "}"

    private var gson: Gson = Gson()

    @Before
    fun setUp() {
        gson = Gson()
    }

    @Test
    fun dealParsingTest() {
        val deal = gson.fromJson(JSON_DEAL, Deal::class.java)

        Assert.assertEquals(deal.title, "Toki Tori")
        Assert.assertEquals(deal.metacriticScore, 80)
        Assert.assertEquals(deal.steamRating, 88)
        Assert.assertEquals(deal.salePrice, 0.49F)
        Assert.assertEquals(deal.normalPrice, 4.99F)
        Assert.assertEquals(deal.thumb, "http://cdn.akamai.steamstatic.com/steam/apps/38700/capsule_sm_120.jpg?t=1488471030")
    }
}
