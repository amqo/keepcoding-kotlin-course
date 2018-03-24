package com.amqo.sdk

import com.amqo.sdk.serializer.TopGameDeserializer
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GangameApiService {

    private val apiClient: RetrofitGangameApi

    init {
        val gson = GsonBuilder().registerTypeAdapter(TopGame::class.java, TopGameDeserializer()).create()
        val apiClientConfig = Retrofit.Builder()
                .baseUrl(Routes.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

        apiClient = apiClientConfig.create(RetrofitGangameApi::class.java)
    }
}
