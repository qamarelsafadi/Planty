package com.qamar.planty.data.source.network.plants.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Links(
    @SerializedName("genus")
    val genus: String = "",
    @SerializedName("plant")
    val plant: String = "",
    @SerializedName("self")
    val self: String = ""
)