package com.elvis.receta.ui.di

import com.elvis.receta.ui.categorias.CategoriasViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

fun obtenerModuloRecetaUI() = module {
    viewModel {
        CategoriasViewModel(
            obtenerCategoriasRecetaCasoUso = get()
        )
    }
}