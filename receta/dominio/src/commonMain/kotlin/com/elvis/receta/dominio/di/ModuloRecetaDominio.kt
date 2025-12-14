package com.elvis.receta.dominio.di

import com.elvis.receta.dominio.casoUso.ObtenerCategoriasRecetaCasoUso
import com.elvis.receta.dominio.casoUso.ObtenerInformacionPlatoCasoUso
import com.elvis.receta.dominio.casoUso.ObtenerPlatosPorCategoriaCasoUso
import org.koin.dsl.module

fun obtenerModuloRecetaDominio() = module {
    factory { ObtenerCategoriasRecetaCasoUso( recetaRepositorio = get()) }
    factory { ObtenerPlatosPorCategoriaCasoUso( recetaRepositorio = get()) }
    factory { ObtenerInformacionPlatoCasoUso( recetaRepositorio = get()) }
}