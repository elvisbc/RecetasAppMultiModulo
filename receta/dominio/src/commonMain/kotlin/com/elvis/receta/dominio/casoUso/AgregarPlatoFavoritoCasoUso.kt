package com.elvis.receta.dominio.casoUso

import com.elvis.receta.dominio.model.PlatoInformacion
import com.elvis.receta.dominio.repositorio.RecetaRepositorio

class AgregarPlatoFavoritoCasoUso(
    private val recetaRepositorio: RecetaRepositorio
) {
     suspend operator fun invoke(platoInformacion: PlatoInformacion) =
         recetaRepositorio.agregarPlatoFavorito(
             platoInformacion = platoInformacion
         )
}