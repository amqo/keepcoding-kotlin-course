package com.amqo.sdk

import com.amqo.sdk.serializer.TopGameDeserializer.Companion.BASE_IMAGE_URL
import com.google.gson.JsonParser
import junit.framework.Assert
import org.junit.Test

class RequestTest {

    @Test
    fun dealsRequest_success() {
        val apiService = GangameApiService()
        val response = apiService.apiClient.getDeals().execute()
        val deals = response.body()

        val parser = JsonParser()
        val jsonResponse = parser.parse(MockResponses.DEALS_RESPONSE).asJsonArray

        Assert.assertTrue(response.isSuccessful)

        deals?.let {
            Assert.assertEquals(deals.size, jsonResponse.size())

            deals.zip(jsonResponse).forEach {(deal,  jsonDeal) ->
                with(jsonDeal.asJsonObject) {
                    Assert.assertEquals(deal.title, this["title"].asString)
                    Assert.assertEquals(deal.salePrice, this["salePrice"].asFloat)
                    Assert.assertEquals(deal.normalPrice, this["normalPrice"].asFloat)
                    Assert.assertEquals(deal.metacriticScore, this["metacriticScore"].asInt)
                    Assert.assertEquals(deal.steamRating, this["steamRatingPercent"].asInt)
                    Assert.assertEquals(deal.thumb, this["thumb"].asString)
                }
            }
        }
    }

    @Test
    fun topRatedRequest_success() {
        val apiService = GangameApiService()
        val response = apiService.apiClient.getTopRatedGames().execute()
        val games = response.body()

        val parser = JsonParser()
        val jsonResponse = parser.parse(MockResponses.TOP_100_GAMES).asJsonObject
                .entrySet().map { (_, json) ->
                    json.asJsonObject
                }

        Assert.assertTrue(response.isSuccessful)

        games?.let {
            Assert.assertEquals(games.size, jsonResponse.size)

            games.zip(jsonResponse).forEach {(topGame,  jsonTopGame) ->
                with(jsonTopGame.asJsonObject) {
                    Assert.assertEquals(topGame.title, this["name"].asString)
                    Assert.assertEquals(topGame.publisher, this["publisher"].asString)
                    Assert.assertEquals(topGame.steamRating, this["score_rank"].asInt)
                    Assert.assertEquals(topGame.owners, this["owners"].asInt)
                    Assert.assertEquals(topGame.price, this["price"].asFloat)
                    Assert.assertEquals(topGame.thumb, String.format(BASE_IMAGE_URL, this["appid"]))
                }
            }
        }
    }
}