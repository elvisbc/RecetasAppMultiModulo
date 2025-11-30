package com.elvis.coreNetwork.apiServicio

import com.elvis.coreNetwork.model.receta.CategoriasDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

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
}