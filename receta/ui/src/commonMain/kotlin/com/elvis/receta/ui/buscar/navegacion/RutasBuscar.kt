package com.elvis.receta.ui.buscar.navegacion

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface RutasBuscar: NavKey {
    @Serializable
    data object ListaPlatosBusqueda: RutasBuscar, NavKey
    @Serializable
    data class PlatoInformacion(val platoId: String): RutasBuscar, NavKey
    @Serializable
    data object Error: RutasBuscar, NavKey
}