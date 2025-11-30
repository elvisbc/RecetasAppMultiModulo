package com.elvis.receta.data.di

import com.elvis.receta.data.repositorio.RecetaRepositorioImp
import com.elvis.receta.dominio.repositorio.RecetaRepositorio
import org.koin.dsl.module

fun obtenerModuloRecetaData() = module{
    factory<RecetaRepositorio>{
        RecetaRepositorioImp(
            apiServicio = get()
        )
    }
}