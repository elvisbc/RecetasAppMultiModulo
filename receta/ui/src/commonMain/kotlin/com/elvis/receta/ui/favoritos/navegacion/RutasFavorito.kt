package com.elvis.receta.ui.favoritos.navegacion

import kotlinx.serialization.Serializable

@Serializable
sealed interface RutasFavorito {
    @Serializable
    data object ListaPlatosFavoritos: RutasFavorito
    @Serializable
    data class PlatoInformacionFavorito(val platoId: String): RutasFavorito
}