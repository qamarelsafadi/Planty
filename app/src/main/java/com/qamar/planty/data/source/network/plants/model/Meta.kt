package com.qamar.planty.data.source.network.plants.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Meta(
    @SerializedName("total")
    val total: Int = 0
)