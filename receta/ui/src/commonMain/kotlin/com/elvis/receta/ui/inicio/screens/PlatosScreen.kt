package com.elvis.receta.ui.inicio.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.elvis.receta.ui.inicio.composable.ItemPlatos
import com.elvis.receta.ui.inicio.viewModel.PlatosViewModel
import org.koin.compose.viewmodel.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlatosScreen(
    categoria: String,
    alSeleccionar: (String) -> Unit
){
    val viewModel = koinViewModel<PlatosViewModel>()
    val estadoPlatos = viewModel.estadoPlatos.collectAsStateWithLifecycle()

    LaunchedEffect(Unit){
        viewModel.obtenerPlatosPorCategoria(categoria)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn {
            items(estadoPlatos.value.exito){ plato ->
                ItemPlatos(
                    plato = plato,
                    alSeleccionar = alSeleccionar
                )
            }
        }
    }
}