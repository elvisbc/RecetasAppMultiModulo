package com.elvis.comun.ui.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.elvis.receta.dominio.model.Plato

@Composable
fun ItemPlatos(
    plato: Plato,
    alSeleccionar: (String) -> Unit
){
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = Modifier.clickable(
            onClick = { alSeleccionar(plato.id) }
        )
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier.size(100.dp)
            ){
                AsyncImage(
                    model = plato.imagen,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
            Text(
                text = plato.nombre,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold

            )
        }

    }
}