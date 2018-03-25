package com.amqo.sdk.serializer

import com.amqo.sdk.TopGame
import com.google.gson.*
import java.lang.reflect.Type

class TopGameDeserializer : JsonDeserializer<TopGame> {

    companion object {
        const val BASE_IMAGE_URL = "http://cdn.akamai.steamstatic.com/steam/apps/%s/capsule_184x69.jpg"
    }

    override fun deserialize(json: JsonElement, typeOfT: Type?, context: JsonDeserializationContext?): TopGame {
        val topGame = Gson().fromJson(json, TopGame::class.java)
        return with(json.asJsonObject) {
            topGame.thumb = String.format(BASE_IMAGE_URL, this["appid"].asInt.toString())
            topGame.steamRating = getSteamRating(this)
            topGame
        }
    }

    private fun getSteamRating(json: JsonObject): Int {
        return with(json["score_rank"]) {
            if (asString.isEmpty()) {
                0
            } else {
                asInt
            }
        }
    }
}
