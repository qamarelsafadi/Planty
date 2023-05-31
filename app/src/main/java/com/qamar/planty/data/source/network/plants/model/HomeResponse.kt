package com.qamar.planty.data.source.network.plants.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class HomeResponse(
    @SerializedName("data")
    val plants: List<Plant> = listOf(),
    @SerializedName("links")
    val links: LinksX = LinksX(),
    @SerializedName("meta")
    val meta: Meta = Meta()
)