package com.elvis.receta.ui.buscar.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elvis.receta.dominio.casoUso.ObtenerPlatosBuscadosCasoUso
import com.elvis.receta.ui.buscar.estados.EstadoBusqueda
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update

class BusquedaPlatoViewModel(
    private val obtenerPlatosBuscadosCasoUso: ObtenerPlatosBuscadosCasoUso
): ViewModel() {
    private val _estadoBusqueda = MutableStateFlow(EstadoBusqueda(defecto = true))
    val estadoBusqueda: StateFlow<EstadoBusqueda> = _estadoBusqueda

    private val _cuadroBusqueda = mutableStateOf("")
    val cuadroBusqueda: State<String> = _cuadroBusqueda

    fun guardarBusqueda(buscar: String){
        _cuadroBusqueda.value = buscar
    }

    fun obtenerPlatosPorBusqueda(busqueda: String) =
        obtenerPlatosBuscadosCasoUso.invoke(busqueda)
            .onStart {
                _estadoBusqueda.update { EstadoBusqueda(cargando = true) }
            }.onEach { resultado ->
                resultado.onSuccess { data ->
                    _estadoBusqueda.update { EstadoBusqueda(exito = data) }
                }.onFailure { error ->
                    _estadoBusqueda.update { EstadoBusqueda(error = error.message.toString()) }
                }
            }.launchIn(viewModelScope)
}