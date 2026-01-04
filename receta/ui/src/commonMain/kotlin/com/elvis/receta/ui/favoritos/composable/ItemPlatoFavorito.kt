package com.elvis.receta.ui.favoritos.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.elvis.receta.dominio.model.PlatoInformacion
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ItemPlatoFavorito(
    platoInformacion: PlatoInformacion,
    alSeleccionar: (String) -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            shape = RoundedCornerShape(10.dp),
            onClick = {
                alSeleccionar(platoInformacion.idPlato)
            }
        ){

            Box(
                modifier = Modifier
                    .size(250.dp)
            ){
                AsyncImage(
                    model = platoInformacion.imagen,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
        }
        Text(
            text = platoInformacion.nombre,
            textAlign = TextAlign.Center,
            fontSize = 16.sp


        )
        
    }

}