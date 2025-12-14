package com.elvis.receta.ui.inicio


import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import com.elvis.comun.navegacion.navegarA
import com.elvis.comun.navegacion.retroceder
import com.elvis.receta.navegacion.RutasInicio
import com.elvis.receta.navegacion.RutasInicio.*
import com.elvis.receta.ui.inicio.screens.CategoriasScreen
import com.elvis.receta.ui.inicio.screens.PlatoInformacionScreen
import com.elvis.receta.ui.inicio.screens.PlatosScreen
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic


@Composable
fun InicioScreen(){
    val backStack = rememberNavBackStack(
        configuration = SavedStateConfiguration {
            serializersModule = SerializersModule {
                polymorphic(NavKey::class){
                    subclass(subclass = Categorias::class, serializer = Categorias.serializer())
                    subclass(subclass = ListaPlatos::class, serializer = ListaPlatos.serializer())

                }
            }
        },
        Categorias
    )

    /*val navHostController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        NavHost(
            navController = navHostController,
            startDestination = InicioNavGraph.rutaGraph
        ){
            InicioNavGraph.contruir(
                modifier = Modifier.fillMaxSize(),
                navHostController = navHostController,
                navGraphBuilder = this
            )
        }

    }*/

    NavDisplay(
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
    )
}