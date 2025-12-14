package com.elvis.receta.ui.inicio.estados

import com.elvis.receta.dominio.model.Plato

data class PlatosEstado(
    val cargando: Boolean = false,
    val error: String = "",
    val exito: List<Plato> = emptyList()
)