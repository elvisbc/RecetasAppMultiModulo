package com.elvis.receta.ui.favoritos.estado

import com.elvis.receta.dominio.model.PlatoInformacion

data class PlatoInformacionLocalEstado(
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
