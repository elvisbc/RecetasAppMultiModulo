package com.elvis.receta.ui.inicio.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.elvis.receta.ui.Anaranjado
import com.elvis.receta.ui.AnaranjadoOpaco
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun InformacionCategoria(
    categoria: String
){
    Card(
        modifier = Modifier
            .height(50.dp),
        colors = CardDefaults.cardColors(
            containerColor = AnaranjadoOpaco
        )
    ){
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            Text(
                text = categoria,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold,
                color = Anaranjado
            )
        }
    }
}