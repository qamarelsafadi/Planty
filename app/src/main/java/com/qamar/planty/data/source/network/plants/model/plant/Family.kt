package com.qamar.planty.data.source.network.plants.model.plant


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Family(
    @SerializedName("common_name")
    val commonName: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("links")
    val links: Links = Links(),
    @SerializedName("name")
    val name: String = "",
    @SerializedName("slug")
    val slug: String = ""
)