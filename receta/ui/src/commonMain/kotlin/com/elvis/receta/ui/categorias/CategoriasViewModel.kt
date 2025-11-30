package com.elvis.receta.ui.categorias

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elvis.receta.dominio.casoUso.ObtenerCategoriasRecetaCasoUso
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update

class CategoriasViewModel(
    private val  obtenerCategoriasRecetaCasoUso: ObtenerCategoriasRecetaCasoUso
): ViewModel() {
    private val _estadoCategorias = MutableStateFlow(CategoriasEstado())
    val estadoCategorias: StateFlow<CategoriasEstado> = _estadoCategorias.asStateFlow()

    init {
        obtenerCategorias()
    }
    fun obtenerCategorias() =
        obtenerCategoriasRecetaCasoUso.invoke()
            .onStart {
                _estadoCategorias.update { CategoriasEstado(cargando = true) }
            }.onEach { resultado ->
                resultado.onSuccess { data ->
                    _estadoCategorias.update { CategoriasEstado(exito = data) }
                }.onFailure { error ->
                    _estadoCategorias.update { CategoriasEstado(error = error.message.toString()) }
                }

            }.launchIn(viewModelScope)
}