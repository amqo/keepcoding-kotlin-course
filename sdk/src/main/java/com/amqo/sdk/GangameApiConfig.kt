package com.amqo.sdk

import retrofit2.Retrofit

interface GangameApiConfig {

    fun setupConfig(builder: Retrofit.Builder)
}