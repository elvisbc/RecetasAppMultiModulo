package com.elvis.receta.ui.inicio.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import com.elvis.receta.ui.Anaranjado
import com.elvis.receta.ui.inicio.composable.InformacionCategoria
import com.elvis.receta.ui.inicio.viewModel.PlatoInformacionViewModel
import org.koin.compose.viewmodel.koinViewModel


@Composable
fun PlatoInformacionScreen(
    idPlato: String
){
    val viewModel = koinViewModel<PlatoInformacionViewModel>()
    val estadoPlatoInformacion = viewModel.estadoReceta.collectAsStateWithLifecycle()
    LaunchedEffect(Unit){
        viewModel.obtenerInformacionReceta(idPlato)
    }
    if (estadoPlatoInformacion.value.cargando){
        CircularProgressIndicator()
    }
    if (estadoPlatoInformacion.value.error.isNotEmpty()){
        Text(estadoPlatoInformacion.value.error)
    }
    if (!estadoPlatoInformacion.value.cargando && estadoPlatoInformacion.value.exito.idPlato!= ""){

        val informacionPlato = estadoPlatoInformacion.value.exito
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {

            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){
                Box(
                    modifier = Modifier
                        .size(250.dp)
                ){
                    AsyncImage(
                        model = informacionPlato.imagen,
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
            }
            Row {
                Text(
                    text = informacionPlato.nombre,
                    modifier = Modifier.padding(vertical = 10.dp),
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            InformacionCategoria(
                categoria = informacionPlato.categoria
            )
            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Anaranjado
                )
            ){
                Text(
                    text = "Ver video de la receta"
                )
            }

            LazyColumn {
                item {
                    Text(
                        text = "Ingredientes:",
                        modifier = Modifier.padding(vertical = 10.dp),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                items(informacionPlato.ingredientes){
                    Row {
                        Text(it.medida)
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(it.ingrediente)
                    }
                }
                item {

                    Text(
                        text = "Preparacion:",
                        modifier = Modifier.padding(vertical = 10.dp),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                item{
                    Text(
                        text = informacionPlato.instruccion
                    )
                }

            }




        }
    }

}