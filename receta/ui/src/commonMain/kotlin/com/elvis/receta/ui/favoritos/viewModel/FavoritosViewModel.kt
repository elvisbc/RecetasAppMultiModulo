package com.elvis.receta.ui.favoritos.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elvis.receta.dominio.casoUso.AgregarPlatoFavoritoCasoUso
import com.elvis.receta.dominio.casoUso.ObtenerPlatosFavoritosCasoUso
import com.elvis.receta.dominio.model.PlatoInformacion
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class FavoritosViewModel(
    private val obtenerPlatosFavoritosCasoUso: ObtenerPlatosFavoritosCasoUso,
    private val agregarPlatoFavoritoCasoUso: AgregarPlatoFavoritoCasoUso
): ViewModel() {

    val favoritos = obtenerPlatosFavoritosCasoUso.invoke()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = emptyList()
    )
    fun agregarPlatoFavorito(platoInformacion: PlatoInformacion){
        viewModelScope.launch {
            agregarPlatoFavoritoCasoUso.invoke(platoInformacion)
        }

    }
}