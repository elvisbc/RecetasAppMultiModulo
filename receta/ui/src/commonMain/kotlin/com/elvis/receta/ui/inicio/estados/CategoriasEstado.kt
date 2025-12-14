package com.elvis.receta.ui.inicio.estados

import com.elvis.receta.dominio.model.RecetaCategoria

data class CategoriasEstado(
    val cargando: Boolean = false,
    val error: String = "",
    val exito: List<RecetaCategoria> = emptyList()
)