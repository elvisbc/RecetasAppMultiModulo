package com.elvis.recetaskmpmulti

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.elvis.recetaskmpmulti.navegacion.MenuNavGraph
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import recetaskmpmulti.composeapp.generated.resources.Res
import recetaskmpmulti.composeapp.generated.resources.ic_menu

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun App() {
    val estadoDrawer = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val navHostController = rememberNavController()
    MaterialTheme {
        ModalNavigationDrawer(
            drawerState = estadoDrawer,
            drawerContent = {
                ModalDrawerSheet {
                    Text(
                        text = "Menu"
                    )
                    MenuNavGraph.items.forEach { i ->

                        NavigationDrawerItem(
                            label = {Text(i.titulo)},
                            modifier = Modifier.padding(vertical = 8.dp),
                            selected = true,
                            onClick = {
                                navHostController.navigate(i.ruta){
                                    popUpTo(MenuNavGraph.rutaGraph)
                                    launchSingleTop = true
                                }
                                scope.launch { estadoDrawer.close() }
                            }
                        )
                    }
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
                                   painter = painterResource(Res.drawable.ic_menu),
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
                        .fillMaxSize()
                ){
                    NavHost(
                        navController = navHostController,
                        startDestination = MenuNavGraph.rutaGraph
                    ){
                        MenuNavGraph.contruir(
                            modifier = Modifier.fillMaxSize(),
                            navHostController = navHostController,
                            navGraphBuilder = this
                        )
                    }
                }
            }
        }
    }
}