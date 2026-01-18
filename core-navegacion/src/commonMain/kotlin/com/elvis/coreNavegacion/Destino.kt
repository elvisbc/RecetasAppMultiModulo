package com.elvis.coreNavegacion

import kotlinx.serialization.Serializable


sealed class Destino{
    @Serializable object MenuLateral: Destino()
}
