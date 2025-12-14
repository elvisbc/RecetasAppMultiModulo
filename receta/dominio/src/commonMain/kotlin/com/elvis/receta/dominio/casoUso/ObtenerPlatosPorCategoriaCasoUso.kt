package com.elvis.receta.dominio.casoUso

import com.elvis.receta.dominio.repositorio.RecetaRepositorio
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class ObtenerPlatosPorCategoriaCasoUso(
    private val recetaRepositorio: RecetaRepositorio
) {
    operator fun invoke(categoria: String) = flow {
        emit(recetaRepositorio.obtenerPlatosPorCategoria(categoria))
    }.catch { error ->
        emit(Result.failure(error))
    }.flowOn(Dispatchers.IO)
}