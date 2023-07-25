package com.example.proyectodashboard.pages

import android.content.Context
import android.graphics.BitmapFactory
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.proyectodashboard.R
import com.example.proyectodashboard.components.CreateChannelNotification
import com.example.proyectodashboard.components.notificacionExtensa
import com.example.proyectodashboard.components.notificacionImagen
import com.example.proyectodashboard.components.notificacionSencilla
import com.example.proyectodashboard.components.notificationProgramada
import com.example.proyectodashboard.pages.login.CarouselCard

@Composable
fun Page_Informacion(){
    Column() {
        CarouselCard()
    }
}
/*val idNotification: Int = 0
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
    val modifier = Modifier
        .padding(18.dp)
        .fillMaxWidth()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(18.dp)
            .fillMaxSize()
    ) {
        Text(
            text = "Informacion de Notificaciones",
            style = MaterialTheme.typography.h3,
            modifier = Modifier.padding(bottom = 100.dp)
        )
        Button(
            onClick = {
                notificacionSencilla(
                    context,
                    idChannel,
                    idNotification,
                    "Notificacion Sencilla",
                    textShort
                )
            },
            modifier = modifier
        ){
            Text(
                text = "Notificacion Sencilla"
            )
        }

        Button(onClick = {
            notificacionExtensa(
                context,
                idChannel,
                idNotification + 1,
                "Notificacion Extensa",
                textLong,
                iconoBig
            )
        },
            modifier = modifier
        ){
            Text(
                text = "Notificaiones Extensa"
            )
        }
        Button(
            onClick = {
                notificacionImagen(
                    context,
                    idChannel,
                    idNotification +2,
                    "Notificacion de Imagen",
                    textLong,
                    iconoBig,
                    imagenBig
                )
            },
            modifier = modifier
        ){
            Text(
                text = "Notificacion con Imagen"
            )
        }
        Button(
            onClick = {
                notificationProgramada(
                    context
                )
            },
            modifier = modifier
        ){
            Text(
                text = "Notificaciones Programada")

        }
    }*/


