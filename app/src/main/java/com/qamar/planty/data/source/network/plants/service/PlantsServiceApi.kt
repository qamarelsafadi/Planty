package com.qamar.planty.data.source.network.plants.service

import com.qamar.planty.BuildConfig
import com.qamar.planty.data.source.network.plants.model.plant.PlantResponse
import com.qamar.planty.data.source.network.plants.model.plants.PlantsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PlantsServiceApi {

    @GET("plants")
    suspend fun getPlants(
        @Query("token") token: String = BuildConfig.apiKey
    ): Response<PlantsResponse>

    @GET("plants/{id}")
    suspend fun getPlantDetails(
        @Path("id") id: Int,
        @Query("token") token: String = BuildConfig.apiKey,
    ): Response<PlantResponse>

}