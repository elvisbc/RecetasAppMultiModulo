package com.elvis.receta.ui.inicio.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elvis.receta.dominio.casoUso.ObtenerPlatosPorCategoriaCasoUso
import com.elvis.receta.ui.inicio.estados.PlatosEstado
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update

class PlatosViewModel(
    private val obtenerPlatosPorCategoriaCasoUso: ObtenerPlatosPorCategoriaCasoUso
): ViewModel() {
    private val _estadoPlatos = MutableStateFlow(PlatosEstado())
    val estadoPlatos: StateFlow<PlatosEstado> = _estadoPlatos.asStateFlow()


    fun obtenerPlatosPorCategoria(categoria: String) =
        obtenerPlatosPorCategoriaCasoUso.invoke(categoria)
            .onStart {
                _estadoPlatos.update { PlatosEstado(cargando = true) }
            }.onEach { resultado ->
                resultado.onSuccess { data ->
                    _estadoPlatos.update { PlatosEstado(exito = data) }
                }.onFailure { error ->
                    _estadoPlatos.update { PlatosEstado(error = error.message.toString()) }
                }
            }.launchIn(viewModelScope)
}