package com.example.proyectodashboard.components

import android.content.Context
import android.graphics.BitmapFactory
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.proyectodashboard.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun TopBar(
    scope: CoroutineScope,
    scaffoldState: ScaffoldState,
    navController: NavHostController,
    menuItem: List<MenuItem>
){
    val idNotification: Int = 0
    val context: Context = LocalContext.current
    val idChannel: String =  ("CanalTienda")
    val name:String= ("CanalTienda")
    val descriptionText: String = stringResource( R.string.canal_Notifi)

    val textShort: String = "Ejemplo de notificacion sencilla con prioridad por omision (default)"
    val textLong: String =
        "Saludos! Esta es una prueba de notificaciones. Debe aparecer"+
                "un icono a la derecha y el texto puede tener una longitud de 200 caracterer"+
                "El tamaño de la notificacion puede colapsar y/o expandirse"+
                "Gracias y hasta pronto"

    val iconoBig = BitmapFactory.decodeResource(
        context.resources,
        R.drawable.ic_sena
    )
    val imagenBig = BitmapFactory.decodeResource(
        context.resources,
        R.drawable.bg_tienda_cba
    )

    //Funcion de creacion propia como corrutina
    LaunchedEffect(Unit){
        CreateChannelNotification(
            idChannel,
            context,
            name,
            descriptionText
        )
    }
    var showMenu by remember{
        mutableStateOf(false)
    }
    var currentRoute = Current_Route(navController = navController)
    var myTytle = "Tienda sena CBA"
    menuItem.forEach{ item ->
        if (currentRoute == item.ruta) myTytle = item.title

    }
    TopAppBar(
        title = { Text(text = myTytle)},
        navigationIcon = {
            IconButton(
                onClick = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Icono de menu"
                )
            }
        },
        actions = {
            IconButton(onClick = {
                notificationProgramada(
                context
                )
            }
            ){
                Icon(imageVector = Icons.Filled.Refresh,
                    contentDescription = "Refrescar"
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Settings ,
                    contentDescription = "Configurar"
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.MoreVert,
                    contentDescription = "Más Opciones"
                )
            }
            DropdownMenu(
                expanded = showMenu,
                onDismissRequest = { showMenu = false},
                modifier = Modifier.width(150.dp)
            ){
                DropdownMenuItem(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = "Idioma"
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = "Idioma")
                }
                DropdownMenuItem(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Share,
                        contentDescription ="Compartir"
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = "Compartir")

                }

            }
        }
    )
}

