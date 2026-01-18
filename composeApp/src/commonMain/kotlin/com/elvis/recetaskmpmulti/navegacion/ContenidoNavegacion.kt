package com.elvis.recetaskmpmulti.navegacion

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.elvis.coreNavegacion.items2
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun ContenidoNavegacion(
    navController: NavController,
    estadoDrawer: DrawerState,
    scope: CoroutineScope
){
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(16.dp)
    ) {
        Text(
            text = "Menu"
        )
        HorizontalDivider()

        items2.forEach { i ->

            NavigationDrawerItem(
                label = {Text(i.titulo)},
                modifier = Modifier.padding(vertical = 8.dp),
                selected = true,
                onClick = {
                    navController.navigate(i){
                        popUpTo(0)
                        launchSingleTop = true
                    }
                    scope.launch { estadoDrawer.close() }
                }
            )
        }

    }

}