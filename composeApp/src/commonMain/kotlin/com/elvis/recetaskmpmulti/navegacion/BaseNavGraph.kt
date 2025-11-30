package com.elvis.recetaskmpmulti.navegacion

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

interface BaseNavGraph {
    val rutaGraph: String
    fun contruir(
        modifier: Modifier,
        navHostController: NavHostController,
        navGraphBuilder: NavGraphBuilder
    )
}