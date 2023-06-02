package com.qamar.planty.data.source.network.plants.model.plants


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class LinksX(
    @SerializedName("first")
    val first: String = "",
    @SerializedName("last")
    val last: String = "",
    @SerializedName("next")
    val next: String = "",
    @SerializedName("self")
    val self: String = ""
)