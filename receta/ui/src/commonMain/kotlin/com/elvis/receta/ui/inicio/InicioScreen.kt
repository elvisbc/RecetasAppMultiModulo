package com.elvis.receta.ui.inicio


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.elvis.receta.ui.inicio.navegacion.RutasInicio
import com.elvis.receta.ui.inicio.navegacion.RutasInicio.Categorias
import com.elvis.receta.ui.inicio.navegacion.RutasInicio.ListaPlatos
import com.elvis.receta.ui.inicio.navegacion.RutasInicio.PlatoInformacion
import com.elvis.receta.ui.inicio.screens.CategoriasScreen
import com.elvis.receta.ui.inicio.screens.PlatoInformacionScreen
import com.elvis.receta.ui.inicio.screens.PlatosScreen


@Composable
fun InicioScreen(){
    /*val backStack = rememberNavBackStack(
        configuration = SavedStateConfiguration {
            serializersModule = SerializersModule {
                polymorphic(NavKey::class){
                    subclass(subclass = Categorias::class, serializer = Categorias.serializer())
                    subclass(subclass = ListaPlatos::class, serializer = ListaPlatos.serializer())
                    subclass(subclass = PlatoInformacion::class, serializer = PlatoInformacion.serializer())

                }
            }
        },
        Categorias
    )*/

    val navHostController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        NavHost(
            navController = navHostController,
            startDestination = Categorias
        ){
            composable <Categorias>{
                CategoriasScreen{ categoria ->
                    navHostController.navigate(ListaPlatos(categoria))
                }
            }
            composable <ListaPlatos>{
                val categoria = it.toRoute<ListaPlatos>()
                PlatosScreen(categoria.categoria){ categoria ->
                    navHostController.navigate(PlatoInformacion(categoria))
                }
            }
            composable <PlatoInformacion>{
                val plato = it.toRoute<PlatoInformacion>()
                PlatoInformacionScreen(plato.platoId)
            }
        }

    }

    /*NavDisplay(
        backStack = backStack,
        onBack = { backStack.retroceder()},
        entryProvider = entryProvider {
            entry<Categorias>{
                CategoriasScreen {categoria ->
                    backStack.navegarA(ListaPlatos(categoria))
                }
            }
            entry<ListaPlatos> {
                PlatosScreen(it.categoria){ idPlato ->
                    backStack.navegarA(PlatoInformacion(idPlato))
                }
            }
            entry<PlatoInformacion> {
                PlatoInformacionScreen(it.platoId)
            }
            entry<Error> {
                Text("")
            }
        }
    )*/
}