package com.elvis.coreNavegacion

import kotlinx.serialization.Serializable

@Serializable
sealed class DestinoNavegacionLateral(
    val titulo: String
){
    @Serializable object Inicio: DestinoNavegacionLateral("Inicio")
    @Serializable object Buscar: DestinoNavegacionLateral("Buscar")
    @Serializable object Favoritos: DestinoNavegacionLateral("Favoritos")
}
val items2 = listOf(
    DestinoNavegacionLateral.Inicio,
    DestinoNavegacionLateral.Buscar,
    DestinoNavegacionLateral.Favoritos
)
