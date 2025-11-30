package com.elvis.receta.dominio.di

import com.elvis.receta.dominio.casoUso.ObtenerCategoriasRecetaCasoUso
import org.koin.dsl.module

fun obtenerModuloRecetaDominio() = module {
    factory { ObtenerCategoriasRecetaCasoUso( recetaRepositorio = get()) }
}