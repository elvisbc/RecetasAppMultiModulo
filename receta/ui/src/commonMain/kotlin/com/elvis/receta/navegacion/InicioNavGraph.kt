package com.elvis.receta.navegacion
/*
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.elvis.comun.navegacion.BaseNavGraph
import com.elvis.receta.ui.screens.CategoriasScreen
import com.elvis.receta.ui.screens.PlatosScreen

object InicioNavGraph: BaseNavGraph {
    override val rutaGraph: String = "inicioGraph"

    sealed class Destino(
        val ruta: String,
        val titulo: String
    ){
        data object Categorias: Destino("inicio/categorias","Recetas deliciosas")
        data object ListaPlatos: Destino("inicio/lista_Platos/{categoria}","Recetas"){
            fun crearRuta(categoria: String) = "inicio/lista_Platos/${categoria}"
        }


    }

    override fun contruir(
        modifier: Modifier,
        navHostController: NavHostController,
        navGraphBuilder: NavGraphBuilder
    ) {
        navGraphBuilder.navigation(
            route = rutaGraph,
            startDestination = Destino.Categorias.ruta
        ){
            composable(
                route = Destino.Categorias.ruta
            ) {
                CategoriasScreen(
                    alSeleccionarCategoria = { categoria ->
                        navHostController.navigate(Destino.ListaPlatos.crearRuta(categoria))
                    }
                )
            }
            composable(
                route = Destino.ListaPlatos.ruta,
                arguments = listOf(
                    navArgument("categoria") {
                        type = NavType.StringType
                        defaultValue = ""
                        nullable = false
                    }
                )
            ) {
                PlatosScreen(
                    categoria = i
                )
            }
            composable(
                route = "ListaPlatos/{id}"
            ){
                val i = it
            }
        }
    }
}*/