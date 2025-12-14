package com.elvis.receta.ui.buscar.estados

import com.elvis.receta.dominio.model.Plato

data class EstadoBusqueda(
    val defecto: Boolean = false,
    val cargando: Boolean = false,
    val exito: List<Plato> = emptyList(),
    val error: String = ""
)
