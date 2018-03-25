package com.amqo.sdk

import junit.framework.Assert
import org.junit.Test

class RequestTest {

    @Test
    fun dealsRequest_success() {
        val apiService = GangameApiService()
        val response = apiService.apiClient.getDeals().execute()
        val deals = response.body()

        Assert.assertTrue(response.isSuccessful)

        deals?.let {
            Assert.assertEquals(deals.size, 4)
        }
    }
}