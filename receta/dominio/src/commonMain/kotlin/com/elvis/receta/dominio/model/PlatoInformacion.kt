package com.elvis.receta.dominio.model

data class PlatoInformacion(
    val idPlato: String,
    val nombre: String,
    val categoria: String,
    val instruccion: String,
    val imagen: String,
    val video: String,
    val ingredientes: List<Ingrediente>
)
