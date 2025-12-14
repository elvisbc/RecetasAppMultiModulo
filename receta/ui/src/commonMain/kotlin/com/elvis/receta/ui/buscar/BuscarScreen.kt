package com.elvis.receta.ui.buscar

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import com.elvis.comun.navegacion.navegarA
import com.elvis.comun.navegacion.retroceder
import com.elvis.receta.ui.buscar.navegacion.RutasBuscar
import com.elvis.receta.ui.buscar.screens.BusquedaPlatoScreen
import com.elvis.receta.ui.buscar.viewModel.BusquedaPlatoViewModel
import com.elvis.receta.ui.inicio.screens.PlatoInformacionScreen
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun BuscarScreen(){
    val viewModel = koinViewModel<BusquedaPlatoViewModel>()
    val backStack = rememberNavBackStack(
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
    )

}