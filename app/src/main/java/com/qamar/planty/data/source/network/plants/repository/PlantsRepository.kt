package com.qamar.planty.data.source.network.plants.repository

import com.qamar.planty.data.source.network.Resource
import com.qamar.planty.data.source.network.plants.model.Plant
import com.qamar.planty.data.source.network.plants.service.PlantsServiceApi
import com.qamar.planty.util.handleExceptions
import com.qamar.planty.util.handleSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PlantsRepository @Inject constructor(
    private val api: PlantsServiceApi,
) {
    suspend fun getPlants(): Flow<Resource<List<Plant>>> = withContext(Dispatchers.IO) {
        val data: Flow<Resource<List<Plant>>> = try {
            val response = api.getPlants()
            if (response.isSuccessful) {
                handleSuccess(
                    response.body()?.plants,
                    response.message()
                )
            }else{
                handleExceptions(response.errorBody())
            }
        } catch (e: Exception) {
            e.printStackTrace()
            handleExceptions(e)
        }
        data
    }
}