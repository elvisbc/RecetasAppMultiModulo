package com.elvis.receta.ui.favoritos

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.elvis.receta.ui.favoritos.navegacion.RutasFavorito
import com.elvis.receta.ui.favoritos.screens.PlatoInformacionFavoritoScreen
import com.elvis.receta.ui.favoritos.screens.PlatosFavoritosScreen
import com.elvis.receta.ui.favoritos.viewModel.FavoritosViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun FavoritosScreen(){
    val viewModel = koinViewModel<FavoritosViewModel>()
    /*val backStack = rememberNavBackStack(
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
    )*/
    /*NavDisplay(
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
    )*/
    val navHostController = rememberNavController()
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ){
        NavHost(
            navController = navHostController,
            startDestination = RutasFavorito.ListaPlatosFavoritos
        ){
            composable<RutasFavorito.ListaPlatosFavoritos>(){
                PlatosFavoritosScreen(
                    viewModel = viewModel
                ){plato ->
                    navHostController.navigate(RutasFavorito.PlatoInformacionFavorito(plato))
                }
            }
            composable<RutasFavorito.PlatoInformacionFavorito>(){
                val info = it.toRoute<RutasFavorito.PlatoInformacionFavorito>()
                PlatoInformacionFavoritoScreen(info.platoId)
            }
        }

    }
}