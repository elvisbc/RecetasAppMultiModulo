package com.elvis.coreNetwork.model.receta


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CategoriasDto(
    @SerialName("categories")
    val categories: List<Categoria>
)