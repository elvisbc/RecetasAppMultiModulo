package com.elvis.receta.ui.favoritos.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.elvis.comun.ui.composable.ItemPlatos
import com.elvis.receta.ui.favoritos.composable.ItemPlatoFavorito
import com.elvis.receta.ui.favoritos.viewModel.FavoritosViewModel

@Composable
fun PlatosFavoritosScreen(
    viewModel: FavoritosViewModel,
    alSeleccionar: (String) -> Unit
){
    val favoritos = viewModel.favoritos.collectAsStateWithLifecycle()
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        if (favoritos.value.isEmpty()){
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                Text("Sin Favoritos")
            }
        }else{
            LazyVerticalGrid(
                columns = GridCells.Fixed(2)
            ) {
                items(favoritos.value){ favorito ->
                    ItemPlatoFavorito(
                        platoInformacion = favorito
                    ){
                        alSeleccionar(favorito.idPlato)
                    }

                }
            }
        }

    }


}