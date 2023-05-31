package com.qamar.planty.data.source.network.plants.service

import com.qamar.planty.BuildConfig
import com.qamar.planty.data.source.network.plants.model.HomeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PlantsServiceApi {

    @GET("plants")
    suspend fun getPlants(
        @Query("token") token: String = BuildConfig.apiKey
    ): Response<HomeResponse>

}