package com.elvis.recetaskmpmulti.di

import com.elvis.coreBaseDatos.di.obtenerModuloCoreBaseDatos
import com.elvis.coreNetwork.di.obtenerModuloCoreNetwork
import com.elvis.receta.data.di.obtenerModuloRecetaData
import com.elvis.receta.dominio.di.obtenerModuloRecetaDominio
import com.elvis.receta.ui.di.obtenerModuloRecetaUI
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

fun initKoin(koinApplication: ((KoinApplication) -> Unit) ? = null){
    startKoin {
        koinApplication?.invoke(this)
        modules(
            modules = listOf(
                obtenerModuloCoreNetwork(),
                obtenerModuloCoreBaseDatos(),
                obtenerModuloRecetaData(),
                obtenerModuloRecetaDominio(),
                obtenerModuloRecetaUI()
            )
        )
    }

}