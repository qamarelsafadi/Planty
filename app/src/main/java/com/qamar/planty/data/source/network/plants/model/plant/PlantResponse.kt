package com.qamar.planty.data.source.network.plants.model.plant


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import com.qamar.planty.data.source.network.plants.model.plants.Plant

@Keep
data class PlantResponse(
    @SerializedName("data")
    val plant: FullPlant? = null
)