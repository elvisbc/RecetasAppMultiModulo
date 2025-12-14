package com.elvis.comun.navegacion

import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey

fun NavBackStack<NavKey>.navegarA(screen: NavKey){
    add(screen)
}
fun NavBackStack<NavKey>.retroceder(){
    if (isEmpty()) return
    removeLastOrNull()
}