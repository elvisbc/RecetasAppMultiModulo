package com.elvis.receta.dominio.repositorio

import com.elvis.receta.dominio.model.Meal
import com.elvis.receta.dominio.model.Plato
import com.elvis.receta.dominio.model.PlatoInformacion
import com.elvis.receta.dominio.model.RecetaCategoria

interface RecetaRepositorio {
    suspend fun obtenerCategoriasReceta(): Result<List<RecetaCategoria>>
    suspend fun obtenerPlatosPorCategoria(categoria: String): Result<List<Plato>>
    suspend fun obtenerRecetaPlato(idPlato: String): Result<PlatoInformacion>
    suspend fun obtenerPlatosPorBusqueda(busqueda: String): Result<List<Plato>>
}