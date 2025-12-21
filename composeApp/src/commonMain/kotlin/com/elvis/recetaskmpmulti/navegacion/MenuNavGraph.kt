package com.elvis.recetaskmpmulti.navegacion

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.elvis.comun.navegacion.BaseNavGraph
import com.elvis.receta.ui.buscar.BuscarScreen
import com.elvis.receta.ui.favoritos.FavoritosScreen
import com.elvis.receta.ui.inicio.InicioScreen

object MenuNavGraph: BaseNavGraph {
    override val rutaGraph: String = "menuGraph"


    sealed class Destino(
        val ruta: String,
        val titulo: String
    ){
        data object Inicio: Destino("/inicio", "Inicio")
        data object Buscar: Destino("/buscar", "Buscar")
        data object RecetasGuardadas: Destino("/recetas_guardadas","Recetas Guardadas")
    }
    val items = listOf(
        Destino.Inicio,
        Destino.Buscar,
        Destino.RecetasGuardadas
    )
    override fun contruir(
        modifier: Modifier,
        navHostController: NavHostController,
        navGraphBuilder: NavGraphBuilder
    ) {
        navGraphBuilder.navigation(
            route = rutaGraph,
            startDestination = Destino.Inicio.ruta
        ){
            //pantalla de categorias
            composable(
                route = Destino.Inicio.ruta
            ) {
                InicioScreen()
            }
            composable(
                route = Destino.Buscar.ruta
            ) {
                BuscarScreen()
            }
            composable(
                route = Destino.RecetasGuardadas.ruta
            ) {
                FavoritosScreen()
            }

        }
    }

}