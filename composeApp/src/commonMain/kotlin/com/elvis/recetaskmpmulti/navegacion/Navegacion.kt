package com.elvis.recetaskmpmulti.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.elvis.coreNavegacion.Destino
import com.elvis.coreNavegacion.DestinoNavegacionLateral
import com.elvis.receta.ui.buscar.BuscarScreen
import com.elvis.receta.ui.favoritos.FavoritosScreen
import com.elvis.receta.ui.inicio.InicioScreen

@Composable
fun NavegacionPantallas(navHostController: NavHostController){
    NavHost(
        navController = navHostController,
        startDestination = Destino.MenuLateral
    ){
        composable<Destino.MenuLateral> {
            NavegacionLateral()
        }
    }

}
@Composable
fun AppNavHostMenuLaterial(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = DestinoNavegacionLateral.Inicio
    ){
        composable<DestinoNavegacionLateral.Inicio> {
            InicioScreen()
        }
        composable<DestinoNavegacionLateral.Buscar> {
            BuscarScreen()
        }
        composable<DestinoNavegacionLateral.Favoritos>{
            FavoritosScreen()
        }
    }
}