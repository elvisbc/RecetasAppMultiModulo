package com.elvis.receta.dominio.di

import com.elvis.receta.dominio.casoUso.AgregarPlatoFavoritoCasoUso
import com.elvis.receta.dominio.casoUso.EliminarPlatoFavoritoCasoUso
import com.elvis.receta.dominio.casoUso.ObtenerCategoriasRecetaCasoUso
import com.elvis.receta.dominio.casoUso.ObtenerInformacionPlatoCasoUso
import com.elvis.receta.dominio.casoUso.ObtenerInformacionPlatoLocalCasoUso
import com.elvis.receta.dominio.casoUso.ObtenerPlatosBuscadosCasoUso
import com.elvis.receta.dominio.casoUso.ObtenerPlatosFavoritosCasoUso
import com.elvis.receta.dominio.casoUso.ObtenerPlatosPorCategoriaCasoUso
import org.koin.dsl.module

fun obtenerModuloRecetaDominio() = module {
    factory { ObtenerCategoriasRecetaCasoUso( recetaRepositorio = get()) }
    factory { ObtenerPlatosPorCategoriaCasoUso( recetaRepositorio = get()) }
    factory { ObtenerInformacionPlatoCasoUso( recetaRepositorio = get()) }

    factory { ObtenerPlatosBuscadosCasoUso(recetaRepositorio = get()) }

    factory { ObtenerPlatosFavoritosCasoUso(recetaRepositorio =  get()) }
    factory { AgregarPlatoFavoritoCasoUso(recetaRepositorio =  get()) }
    factory { ObtenerInformacionPlatoLocalCasoUso(recetaRepositorio = get()) }
    factory { EliminarPlatoFavoritoCasoUso(recetaRepositorio = get()) }
}