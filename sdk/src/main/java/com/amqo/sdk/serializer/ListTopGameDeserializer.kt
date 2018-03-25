package com.amqo.sdk.serializer

import com.amqo.sdk.TopGame
import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class ListTopGameDeserializer : JsonDeserializer<ArrayList<TopGame>> {

    override fun deserialize(json: JsonElement, typeOfT: Type?, context: JsonDeserializationContext?): ArrayList<TopGame> {
        val gson = GsonBuilder().registerTypeAdapter(TopGame::class.java, TopGameDeserializer()).create()
        val topGames = json.asJsonObject.entrySet().map { (_, json) ->
            gson.fromJson(json.asJsonObject, TopGame::class.java)
        }
        return ArrayList(topGames)
    }
}