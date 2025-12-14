package com.elvis.receta.ui.buscar.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.elvis.comun.ui.composable.ItemPlatos
import com.elvis.receta.ui.buscar.viewModel.BusquedaPlatoViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun BusquedaPlatoScreen(
    viewModel: BusquedaPlatoViewModel,
    alSeleccionar: (String) -> Unit
){

    var busqueda by remember { mutableStateOf("") }


    val estadoBusqueda = viewModel.estadoBusqueda.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(){
            TextField(
                value = viewModel.cuadroBusqueda.value,
                onValueChange = {
                    busqueda = it
                    viewModel.guardarBusqueda(it)
                },
                keyboardActions = KeyboardActions(
                    onSearch  = {
                        viewModel.obtenerPlatosPorBusqueda(busqueda)
                    }
                ),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Search
                ),
                modifier = Modifier.fillMaxWidth()
            )

        }
        if (estadoBusqueda.value.cargando){
            CircularProgressIndicator()
        }
        if (estadoBusqueda.value.error != ""){
            Text(
                text = estadoBusqueda.value.error
            )
        }
        if (estadoBusqueda.value.exito.isNotEmpty() &&
            !estadoBusqueda.value.cargando
        ){

            LazyColumn {
                items(estadoBusqueda.value.exito){ plato ->
                    ItemPlatos(
                        plato = plato,
                        alSeleccionar = alSeleccionar
                    )
                }
            }
        }

    }

}