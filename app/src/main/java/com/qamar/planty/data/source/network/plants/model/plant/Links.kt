package com.qamar.planty.data.source.network.plants.model.plant


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Links(
    @SerializedName("division_order")
    val divisionOrder: String = "",
    @SerializedName("genus")
    val genus: String = "",
    @SerializedName("self")
    val self: String = ""
)