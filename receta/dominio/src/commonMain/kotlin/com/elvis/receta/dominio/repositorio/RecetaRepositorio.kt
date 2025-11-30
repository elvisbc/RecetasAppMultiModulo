package com.elvis.receta.dominio.repositorio

import com.elvis.receta.dominio.model.RecetaCategoria
import kotlinx.coroutines.flow.Flow

interface RecetaRepositorio {
    suspend fun obtenerCategoriasReceta(): Result<List<RecetaCategoria>>
}