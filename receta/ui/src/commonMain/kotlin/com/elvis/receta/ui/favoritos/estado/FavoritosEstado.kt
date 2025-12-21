package com.elvis.receta.ui.favoritos.estado

import com.elvis.receta.dominio.model.PlatoInformacion

data class FavoritosEstado(
    val cargando: Boolean = false,
    val error: String = "",
    val data: List<PlatoInformacion> ? = null
)