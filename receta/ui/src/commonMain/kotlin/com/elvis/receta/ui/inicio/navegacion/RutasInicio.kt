package com.elvis.receta.ui.inicio.navegacion

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface RutasInicio: NavKey {
    @Serializable
    data object Categorias: RutasInicio, NavKey
    @Serializable
    data class ListaPlatos(val categoria: String): RutasInicio, NavKey
    @Serializable
    data class PlatoInformacion(val platoId: String): RutasInicio, NavKey
    @Serializable
    data object Error: RutasInicio, NavKey
}