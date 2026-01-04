package com.elvis.receta.dominio.casoUso

import com.elvis.receta.dominio.repositorio.RecetaRepositorio

class EliminarPlatoFavoritoCasoUso(
    private val recetaRepositorio: RecetaRepositorio
) {
    suspend operator fun invoke(idPlato: String) =
        recetaRepositorio.eliminarPlatoFavorito(idPlato)
}