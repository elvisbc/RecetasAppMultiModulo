package com.elvis.recetaskmpmulti

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.elvis.recetaskmpmulti.navegacion.NavegacionPantallas
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun App() {
    val navHostController = rememberNavController()
    MaterialTheme {
        Scaffold {
            NavegacionPantallas(navHostController)
        }
    }
}