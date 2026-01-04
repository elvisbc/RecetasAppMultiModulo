package com.elvis.receta.ui.favoritos.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elvis.receta.dominio.casoUso.EliminarPlatoFavoritoCasoUso
import com.elvis.receta.dominio.casoUso.ObtenerInformacionPlatoLocalCasoUso
import com.elvis.receta.ui.favoritos.estado.PlatoInformacionLocalEstado
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PlatoInformacionFavoritoViewModel(
    private val obtenerInformacionPlatoLocalCasoUso: ObtenerInformacionPlatoLocalCasoUso,
    private val eliminarPlatoFavoritoCasoUso: EliminarPlatoFavoritoCasoUso
): ViewModel() {
    private val _estadoRecetaLocal = MutableStateFlow(PlatoInformacionLocalEstado())
    val estadoRecetaLocal: StateFlow<PlatoInformacionLocalEstado> = _estadoRecetaLocal

    fun obtenerInformacionLocalReceta(idPlato: String) =
        obtenerInformacionPlatoLocalCasoUso.invoke(idPlato)
            .onStart {
                _estadoRecetaLocal.update { PlatoInformacionLocalEstado(cargando = true) }
            }.onEach { resultado ->
                resultado.onSuccess { data ->
                    _estadoRecetaLocal.update { PlatoInformacionLocalEstado(exito = data) }

                }.onFailure { error ->
                    _estadoRecetaLocal.update { PlatoInformacionLocalEstado(error = error.message.toString()) }
                }
            }.launchIn(viewModelScope)

    fun eliminarPlatoFavorito(idPlato: String){
        viewModelScope.launch {
            eliminarPlatoFavoritoCasoUso.invoke(idPlato)
        }
    }
}