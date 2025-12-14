package com.elvis.coreNetwork.apiServicio

import com.elvis.coreNetwork.model.receta.CategoriasDto
import com.elvis.coreNetwork.model.receta.PlatoInformacionDto
import com.elvis.coreNetwork.model.receta.PlatosDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class ApiServicio(
    val httpClient: HttpClient
) {
    suspend fun obtenerCategoriasRecetas(): Result<CategoriasDto>{
        return try {
            val respuesta = httpClient
                .get("v1/1/categories.php")
                .body<CategoriasDto>()
            Result.success(respuesta)
        }catch (e: Exception){
            Result.failure(e)
        }
    }
    suspend fun obtenerPlatosPorCategoria(categoria: String): Result<PlatosDto>{
        return try {
            val respuesta = httpClient
                .get("v1/1/filter.php"){
                    parameter("c",categoria)
                }
                .body<PlatosDto>()
            Result.success(respuesta)
        }catch (e: Exception){
            Result.failure(e)
        }
    }
    suspend fun obtenerRecetaPlato(idPlato: String): Result<PlatoInformacionDto>{
        return try {
            val respuesta = httpClient
                .get("v1/1/lookup.php") {
                    parameter("i",idPlato.toInt())
                }
                .body<PlatoInformacionDto>()
            Result.success(respuesta)
        }catch (e: Exception){
            Result.failure(e)
        }
    }
}