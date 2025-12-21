package com.elvis.receta.ui.favoritos.navegacion

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface RutasFavorito: NavKey {
    @Serializable
    data object ListaPlatosFavoritos: RutasFavorito, NavKey
    @Serializable
    data class PlatoInformacionFavorito(val platoId: String): RutasFavorito, NavKey
    @Serializable
    data object Error: RutasFavorito, NavKey
}