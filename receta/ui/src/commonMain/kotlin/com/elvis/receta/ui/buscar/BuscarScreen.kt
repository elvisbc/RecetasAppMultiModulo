package com.elvis.receta.ui.buscar

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.elvis.receta.ui.buscar.navegacion.RutasBuscar
import com.elvis.receta.ui.buscar.screens.BusquedaPlatoScreen
import com.elvis.receta.ui.buscar.viewModel.BusquedaPlatoViewModel
import com.elvis.receta.ui.inicio.screens.PlatoInformacionScreen
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun BuscarScreen(){
    val viewModel = koinViewModel<BusquedaPlatoViewModel>()
    /*val backStack = rememberNavBackStack(
        configuration = SavedStateConfiguration {
            serializersModule = SerializersModule {
                polymorphic(NavKey::class){
                    subclass(
                        subclass = RutasBuscar.ListaPlatosBusqueda::class,
                        serializer = RutasBuscar.ListaPlatosBusqueda.serializer()
                    )
                    subclass(
                        subclass = RutasBuscar.PlatoInformacion::class,
                        serializer = RutasBuscar.PlatoInformacion.serializer()
                    )
                }
            }
        },
        RutasBuscar.ListaPlatosBusqueda
    )
    NavDisplay(
        backStack = backStack,
        onBack = { backStack.retroceder() },
        entryProvider = entryProvider {
            entry<RutasBuscar.ListaPlatosBusqueda>{
                BusquedaPlatoScreen(
                    viewModel = viewModel
                ){ idPlato ->
                    backStack.navegarA(RutasBuscar.PlatoInformacion(idPlato))
                }
            }
            entry<RutasBuscar.PlatoInformacion>{
                PlatoInformacionScreen(it.platoId)
            }
        }
    )*/

    val navHostController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ){
        NavHost(
            navController = navHostController,
            startDestination = RutasBuscar.ListaPlatosBusqueda
        ){
            composable<RutasBuscar.ListaPlatosBusqueda>{
                BusquedaPlatoScreen(
                    viewModel = viewModel
                ){ idPlato ->
                    navHostController.navigate(RutasBuscar.PlatoInformacion(idPlato))
                }
            }
            composable<RutasBuscar.PlatoInformacion>{
                val plato = it.toRoute<RutasBuscar.PlatoInformacion>()
                PlatoInformacionScreen(plato.platoId)
            }
        }
    }

}