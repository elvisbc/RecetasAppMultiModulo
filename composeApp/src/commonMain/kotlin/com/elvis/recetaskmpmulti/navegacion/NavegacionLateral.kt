package com.elvis.recetaskmpmulti.navegacion

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import recetaskmpmulti.composeapp.generated.resources.Res

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavegacionLateral(){
    val estadoDrawer = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val navHostController = rememberNavController()

    ModalNavigationDrawer(
        drawerState = estadoDrawer,
        drawerContent = {
            ModalDrawerSheet {
                ContenidoNavegacion(
                    navController = navHostController,
                    estadoDrawer = estadoDrawer,
                    scope = scope
                )
            }
        }
    ){
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = { scope.launch { estadoDrawer.open() } }
                        ){
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = null
                            )
                        }
                    }
                )
            }
        ) { pv ->

            Box(
                modifier = Modifier
                    .padding(pv)
                    .padding(horizontal = 10.dp)
                    .fillMaxSize()
            ){
                AppNavHostMenuLaterial(navHostController)
            }
        }
    }

}