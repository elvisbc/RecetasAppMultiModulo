package com.elvis.coreNetwork.model.receta


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlatosDto(
    @SerialName("meals")
    val platosDto: List<PlatoDto>
)