package com.elvis.receta.data.repositorio

import com.elvis.coreNetwork.apiServicio.ApiServicio
import com.elvis.receta.data.mappers.aDominioListaRecetaCategorias
import com.elvis.receta.dominio.model.RecetaCategoria
import com.elvis.receta.dominio.repositorio.RecetaRepositorio

class RecetaRepositorioImp(
    private val apiServicio: ApiServicio
): RecetaRepositorio {
    override suspend fun obtenerCategoriasReceta(): Result<List<RecetaCategoria>> {
        val resultado = apiServicio.obtenerCategoriasRecetas()
        return if (resultado.isSuccess){
            Result.success(resultado.getOrThrow().categories.aDominioListaRecetaCategorias())
        }else{
            Result.failure(resultado.exceptionOrNull()!!)
        }
    }
}