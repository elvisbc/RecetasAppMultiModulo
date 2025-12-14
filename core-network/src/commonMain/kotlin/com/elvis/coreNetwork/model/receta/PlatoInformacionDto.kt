package com.elvis.coreNetwork.model.receta


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlatoInformacionDto(
    @SerialName("meals")
    val mealDtos: List<MealDto>
)