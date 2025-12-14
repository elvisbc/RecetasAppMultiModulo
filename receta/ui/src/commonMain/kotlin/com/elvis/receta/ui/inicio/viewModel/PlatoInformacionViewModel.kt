package com.elvis.receta.ui.inicio.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elvis.receta.dominio.casoUso.ObtenerInformacionPlatoCasoUso
import com.elvis.receta.ui.inicio.estados.PlatoInformacionEstado
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update

class PlatoInformacionViewModel(
    private val obtenerInformacionPlatoCasoUso: ObtenerInformacionPlatoCasoUso
): ViewModel() {
    private val _estadoReceta = MutableStateFlow(PlatoInformacionEstado())
    val estadoReceta: StateFlow<PlatoInformacionEstado> = _estadoReceta.asStateFlow()

    fun obtenerInformacionReceta(idPlato: String) =
        obtenerInformacionPlatoCasoUso.invoke(idPlato)
            .onStart {
                _estadoReceta.update { PlatoInformacionEstado(cargando = true) }
            }.onEach { resultado ->
                resultado.onSuccess { data ->
                    _estadoReceta.update { PlatoInformacionEstado(exito = data) }
                }.onFailure { error->
                    _estadoReceta.update { PlatoInformacionEstado(error = error.message.toString()) }
                }
            }.launchIn(viewModelScope)
}