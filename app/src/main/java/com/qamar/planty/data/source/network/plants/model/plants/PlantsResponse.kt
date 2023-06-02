package com.qamar.planty.data.source.network.plants.model.plants


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class PlantsResponse(
    @SerializedName("data")
    val plants: List<Plant> = listOf(),
    @SerializedName("links")
    val links: LinksX = LinksX(),
    @SerializedName("meta")
    val meta: Meta = Meta()
)