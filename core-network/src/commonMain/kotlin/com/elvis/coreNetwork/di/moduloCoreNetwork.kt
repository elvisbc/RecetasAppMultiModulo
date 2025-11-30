package com.elvis.coreNetwork.di

import com.elvis.coreNetwork.apiServicio.ApiServicio
import com.elvis.coreNetwork.cliente.KtorCliente
import org.koin.dsl.module

fun obtenerModuloCoreNetwork() = module {
    single { ApiServicio( httpClient = KtorCliente.obtenerInstancia()) }
}