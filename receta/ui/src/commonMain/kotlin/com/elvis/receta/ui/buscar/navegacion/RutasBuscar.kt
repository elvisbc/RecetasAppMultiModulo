package com.elvis.receta.ui.buscar.navegacion

import kotlinx.serialization.Serializable

@Serializable
sealed interface RutasBuscar {
    @Serializable
    data object ListaPlatosBusqueda: RutasBuscar
    @Serializable
    data class PlatoInformacion(val platoId: String): RutasBuscar
}