package com.elvis.coreNetwork.model.receta


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlatoDto(
    @SerialName("idMeal")
    val idMeal: String,
    @SerialName("strMeal")
    val strMeal: String,
    @SerialName("strMealThumb")
    val strMealThumb: String
)