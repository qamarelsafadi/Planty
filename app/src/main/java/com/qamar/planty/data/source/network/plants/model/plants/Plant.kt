package com.qamar.planty.data.source.network.plants.model.plants


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Plant(
    @SerializedName("author")
    val author: String = "",
    @SerializedName("bibliography")
    val bibliography: String = "",
    @SerializedName("common_name")
    val commonName: String? = "",
    @SerializedName("family")
    val family: String = "",
    @SerializedName("family_common_name")
    val familyCommonName: Any? = Any(),
    @SerializedName("genus")
    val genus: Any = "",
    @SerializedName("genus_id")
    val genusId: Int = 0,
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("links")
    val links: Links = Links(),
    @SerializedName("plant_id")
    val plantId: Int = 0,
    @SerializedName("rank")
    val rank: String = "",
    @SerializedName("scientific_name")
    val scientificName: String = "",
    @SerializedName("image_url")
    val imageUrl: String = "",
    @SerializedName("slug")
    val slug: String = "",
    @SerializedName("status")
    val status: String = "",
    @SerializedName("synonyms")
    val synonyms: List<String> = listOf(),
    @SerializedName("year")
    val year: Int = 0,
    val properties: List<Properties> =
        listOf(
            Properties("Light"),
            Properties("Food"),
            Properties("Water"),
        ),
)


data class Properties(
    val propertyName: String,
    val percent: Float = (0 until 100).random().toFloat()/100
)
