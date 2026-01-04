package com.elvis.receta.ui.favoritos

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import com.elvis.comun.navegacion.navegarA
import com.elvis.comun.navegacion.retroceder
import com.elvis.receta.ui.favoritos.navegacion.RutasFavorito
import com.elvis.receta.ui.favoritos.screens.PlatoInformacionFavoritoScreen
import com.elvis.receta.ui.favoritos.screens.PlatosFavoritosScreen
import com.elvis.receta.ui.favoritos.viewModel.FavoritosViewModel
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun FavoritosScreen(){
    val viewModel = koinViewModel<FavoritosViewModel>()
    val backStack = rememberNavBackStack(
        configuration = SavedStateConfiguration{
            serializersModule = SerializersModule {
                polymorphic(NavKey::class){
                    subclass(
                        subclass = RutasFavorito.ListaPlatosFavoritos::class,
                        serializer = RutasFavorito.ListaPlatosFavoritos.serializer()
                    )
                    subclass(
                        subclass = RutasFavorito.PlatoInformacionFavorito::class,
                        serializer = RutasFavorito.PlatoInformacionFavorito.serializer()
                    )
                }
            }
        },
        RutasFavorito.ListaPlatosFavoritos
    )
    NavDisplay(
        backStack = backStack,
        onBack = { backStack.retroceder() },
        entryProvider = entryProvider {
            entry<RutasFavorito.ListaPlatosFavoritos>{
                PlatosFavoritosScreen(
                    viewModel = viewModel
                ){
                    backStack.navegarA(RutasFavorito.PlatoInformacionFavorito(it))
                }
            }
            entry<RutasFavorito.PlatoInformacionFavorito>{
                PlatoInformacionFavoritoScreen(it.platoId)
            }
        }
    )
}