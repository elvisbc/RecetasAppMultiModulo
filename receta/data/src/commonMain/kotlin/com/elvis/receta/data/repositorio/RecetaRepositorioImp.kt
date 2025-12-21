package com.elvis.receta.data.repositorio

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.elvis.coreBaseDatos.AppBaseDatos
import com.elvis.coreNetwork.apiServicio.ApiServicio
import com.elvis.receta.data.mappers.aDominioListaPlatoInformacion
import com.elvis.receta.data.mappers.aDominioListaPlatos
import com.elvis.receta.data.mappers.aDominioListaRecetaCategorias
import com.elvis.receta.data.mappers.aListaIngredientes
import com.elvis.receta.dominio.model.Meal
import com.elvis.receta.dominio.model.Plato
import com.elvis.receta.dominio.model.PlatoInformacion
import com.elvis.receta.dominio.model.RecetaCategoria
import com.elvis.receta.dominio.repositorio.RecetaRepositorio
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import recetaskmpmulti.receta.data.generated.resources.Res

class RecetaRepositorioImp(
    private val apiServicio: ApiServicio,
    private val appBaseDatos: AppBaseDatos
): RecetaRepositorio {
    override suspend fun obtenerCategoriasReceta(): Result<List<RecetaCategoria>> {
        val resultado = apiServicio.obtenerCategoriasRecetas()
        return if (resultado.isSuccess){
            Result.success(resultado.getOrThrow().categories.aDominioListaRecetaCategorias())
        }else{
            Result.failure(resultado.exceptionOrNull()!!)
        }
    }

    override suspend fun obtenerPlatosPorCategoria(categoria: String): Result<List<Plato>> {
        val resultado = apiServicio.obtenerPlatosPorCategoria(categoria)
        return if (resultado.isSuccess){
            Result.success(resultado.getOrThrow().platosDto.aDominioListaPlatos())
        }else{
            Result.failure(resultado.exceptionOrNull()!!)
        }
    }

    override suspend fun obtenerRecetaPlato(idPlato: String): Result<PlatoInformacion> {
        val resultado = apiServicio.obtenerRecetaPlato(idPlato)
        return if (resultado.isSuccess){
            val resultado2 = resultado.getOrThrow().mealDtos.aDominioListaPlatoInformacion()
            val platoInformacion = resultado2[0]
            Result.success(
                PlatoInformacion(
                    idPlato = platoInformacion.idMeal,
                    nombre = platoInformacion.strMeal,
                    categoria = platoInformacion.strCategory,
                    instruccion = platoInformacion.strInstructions,
                    imagen = platoInformacion.strMealThumb,
                    video = platoInformacion.strYoutube,
                    ingredientes = platoInformacion.aListaIngredientes()
                )
            )
        }else{
            Result.failure(resultado.exceptionOrNull()!!)
        }
    }

    override suspend fun obtenerPlatosPorBusqueda(busqueda: String): Result<List<Plato>> {
        val resultado = apiServicio.obtenerPlatosBuscados(busqueda)
        return if (resultado.isSuccess){
            Result.success(resultado.getOrThrow().platosDto.aDominioListaPlatos())
        }else{
            Result.failure(resultado.exceptionOrNull()!!)
        }
    }

    override fun obtenerPlatosFavoritos(): Flow<List<PlatoInformacion>> {
        return appBaseDatos.recetasQueries
            .obtener()
            .asFlow()
            .mapToList(Dispatchers.IO)
            .map {
                it.map { pi ->
                    PlatoInformacion(
                        idPlato = pi.ID,
                        nombre = pi.NOMBRE,
                        categoria = pi.CATEGORIA,
                        instruccion = pi.INSTRUCCION,
                        imagen = pi.IMAGEN,
                        video = pi.VIDEO,
                        ingredientes = emptyList(),
                    )

                }
            }
    }

    override suspend fun agregarPlatoFavorito(platoInformacion: PlatoInformacion) {
        appBaseDatos.recetasQueries.insertar(
            ID = platoInformacion.idPlato,
            NOMBRE = platoInformacion.nombre,
            CATEGORIA = platoInformacion.categoria,
            INSTRUCCION = platoInformacion.instruccion,
            IMAGEN = platoInformacion.imagen,
            VIDEO = platoInformacion.video,
            INGREDIENTES = ""
        )
    }


}