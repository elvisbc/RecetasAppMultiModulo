package com.elvis.receta.dominio.model

import kotlinx.serialization.SerialName

data class RecetaCategoria(
    val idCategoria: String,
    val nombreCategoria: String,
    val descripcion: String,
    val imagen: String
)
