package com.elvis.receta.ui.di

import com.elvis.receta.ui.buscar.viewModel.BusquedaPlatoViewModel
import com.elvis.receta.ui.favoritos.viewModel.FavoritosViewModel
import com.elvis.receta.ui.inicio.viewModel.CategoriasViewModel
import com.elvis.receta.ui.inicio.viewModel.PlatoInformacionViewModel
import com.elvis.receta.ui.inicio.viewModel.PlatosViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

fun obtenerModuloRecetaUI() = module {
    viewModel {
        CategoriasViewModel(
            obtenerCategoriasRecetaCasoUso = get()
        )
    }
    viewModel {
        PlatosViewModel(
            obtenerPlatosPorCategoriaCasoUso = get()
        )
    }
    viewModel {
        PlatoInformacionViewModel(
            obtenerInformacionPlatoCasoUso = get(),
            agregarPlatoFavoritoCasoUso = get()
        )
    }

    viewModel {
        BusquedaPlatoViewModel(
            obtenerPlatosBuscadosCasoUso = get()
        )
    }
    viewModel {
        FavoritosViewModel(
            obtenerPlatosFavoritosCasoUso = get(),
            agregarPlatoFavoritoCasoUso = get()
        )
    }
}