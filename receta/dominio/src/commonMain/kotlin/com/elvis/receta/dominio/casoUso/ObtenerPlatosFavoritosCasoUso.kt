package com.elvis.receta.dominio.casoUso

import com.elvis.receta.dominio.repositorio.RecetaRepositorio

class ObtenerPlatosFavoritosCasoUso(
    private val recetaRepositorio: RecetaRepositorio
) {
    operator fun invoke() = recetaRepositorio.obtenerPlatosFavoritos()
}