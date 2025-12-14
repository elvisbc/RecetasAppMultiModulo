package com.elvis.receta.ui.inicio.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.elvis.receta.ui.inicio.viewModel.CategoriasViewModel
import com.elvis.receta.ui.inicio.composable.ItemCategoria
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun CategoriasScreen(
    alSeleccionarCategoria: (String) -> Unit
){

    val viewModel = koinViewModel<CategoriasViewModel>()
    val estadoCategorias = viewModel.estadoCategorias.collectAsStateWithLifecycle()
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        Column {

            Text(
                text = "¿Qué cocinamos hoy?",
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                fontWeight = FontWeight.SemiBold,
            )
            if (estadoCategorias.value.cargando){
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){
                    CircularProgressIndicator()
                }
            }
            if (estadoCategorias.value.error.isNotBlank()){
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){
                    Text(estadoCategorias.value.error)
                    Button(
                        onClick = {
                            viewModel.obtenerCategorias()
                        }
                    ){
                        Text("Reintentar")
                    }
                }
            }
            estadoCategorias.value.exito?.let { categorias ->
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(8.dp)
                ) {
                    items(categorias){ categoria ->
                        ItemCategoria(
                            recetaCategoria = categoria,
                            alSeleccionar = alSeleccionarCategoria
                        )
                    }

                }
            }
        }


    }

}