package com.elvis.coreNetwork.model.receta


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Categoria(
    @SerialName("idCategory")
    val idCategory: String,
    @SerialName("strCategory")
    val strCategory: String,
    @SerialName("strCategoryDescription")
    val strCategoryDescription: String,
    @SerialName("strCategoryThumb")
    val strCategoryThumb: String
)