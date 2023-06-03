package com.qamar.planty.data.source.network.plants.model.plant


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import com.qamar.planty.R

@Keep
data class FullPlant(
    @SerializedName("author")
    val author: String = "",
    @SerializedName("bibliography")
    val bibliography: String = "",
    @SerializedName("common_name")
    val commonName: Any? = Any(),
    @SerializedName("family")
    val family: Family = Family(),
    @SerializedName("family_common_name")
    val familyCommonName: String = "",
    @SerializedName("forms")
    val forms: List<Any> = listOf(),
    @SerializedName("genus_id")
    val genusId: Int = 0,
    @SerializedName("hybrids")
    val hybrids: List<Any> = listOf(),
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("image_url")
    val imageUrl: Any? = Any(),
    @SerializedName("main_species_id")
    val mainSpeciesId: Int = 0,
    @SerializedName("observations")
    val observations: String = "",
    @SerializedName("scientific_name")
    val scientificName: String = "",
    @SerializedName("slug")
    val slug: String = "",
    @SerializedName("subspecies")
    val subspecies: List<Any> = listOf(),
    @SerializedName("subvarieties")
    val subvarieties: List<Any> = listOf(),
    @SerializedName("varieties")
    val varieties: List<Any> = listOf(),
    @SerializedName("vegetable")
    val vegetable: Boolean = false,
    @SerializedName("year")
    val year: Int = 0
){
    val desription: Int
        get() = R.string.description
}