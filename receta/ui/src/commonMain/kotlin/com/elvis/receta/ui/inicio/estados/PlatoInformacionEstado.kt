package com.elvis.receta.ui.inicio.estados

import com.elvis.receta.dominio.model.PlatoInformacion

data class PlatoInformacionEstado(
    val cargando: Boolean = false,
    val error: String = "",
    val exito: PlatoInformacion =
        PlatoInformacion(
            "",
            "",
            "",
            "",
            "",
            "",
            emptyList()
        )
)