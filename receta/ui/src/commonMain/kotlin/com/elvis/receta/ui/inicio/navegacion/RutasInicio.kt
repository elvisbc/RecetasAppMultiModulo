package com.elvis.receta.ui.inicio.navegacion

import kotlinx.serialization.Serializable

@Serializable
sealed interface RutasInicio {
    @Serializable
    data object Categorias: RutasInicio
    @Serializable
    data class ListaPlatos(val categoria: String): RutasInicio
    @Serializable
    data class PlatoInformacion(val platoId: String): RutasInicio
}