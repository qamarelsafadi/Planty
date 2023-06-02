package com.qamar.planty.data.source.network.plants.model.plant


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class LinksX(
    @SerializedName("family")
    val family: String = "",
    @SerializedName("plants")
    val plants: String = "",
    @SerializedName("self")
    val self: String = "",
    @SerializedName("species")
    val species: String = ""
)