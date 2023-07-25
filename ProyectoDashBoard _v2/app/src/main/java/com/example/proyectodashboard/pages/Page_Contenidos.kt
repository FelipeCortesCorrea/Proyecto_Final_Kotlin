package com.example.proyectodashboard.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.proyectodashboard.R
import com.example.proyectodashboard.components.Contenidos
import com.example.proyectodashboard.components.Frutas_Verduras
import com.example.proyectodashboard.components.notificacionImagen
import com.example.proyectodashboard.components.notificacionSencilla
import com.example.proyectodashboard.pages.login.CarouselCard

@Composable
fun  Page_Contenidos(){
    LazyColumn(
        modifier = Modifier
    ){
        items(listaProductosContenidos){ producto ->
            Page_Contenidos1(producto = producto)
        }
    }
}


val listaProductosContenidos = listOf(
    Contenidos.noticia01,
    Contenidos.noticia02,
    Contenidos.noticia03,
    Contenidos.noticia04,


    )
@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun Page_Contenidos1(
    producto:Contenidos){
    var showDialog by remember { mutableStateOf(false) }

 Card(
     onClick = { showDialog = true},
     modifier = Modifier
         .padding(8.dp)
         .clickable { },
     elevation = 8.dp,
     shape = RoundedCornerShape(8.dp)
    ){
     Column(
         modifier = Modifier
             .padding(bottom = 60.dp)
     ) {
         Image(painter = painterResource(producto.image),
             contentDescription = null,
             modifier = Modifier
                 .fillMaxWidth()
         )
         Column(
             modifier = Modifier
                 .padding(16.dp)
         ){
             Text(text = producto.name,
                 style = MaterialTheme.typography.h5,
                 modifier = Modifier.padding(bottom = 8.dp)
             )
             Button(
                 onClick = {showDialog = true},
                 modifier = Modifier
                     .fillMaxWidth()
                     .fillMaxHeight()
             ) {
                 Text(
                     text = "Detalles"
                 )
             }
         }



         
     }

 }
    if (showDialog)
        Dialog(onDismissRequest = {showDialog = false},
        ){
            Card(
                backgroundColor = Color.White
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Image(painter = painterResource(producto.image),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        contentScale = ContentScale.Crop
                    )
                    Row() {
                        Column() {
                            Text(text = producto.name)
                            Text(text = producto.descripcion)
                        }

                    }
                    Row (
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Button(
                            modifier = Modifier.padding(top = 16.dp),
                            onClick = {
                                showDialog = false

                            }
                        ) {
                            Text(text = "Cerrar")
                        }
                        Spacer(
                            modifier = Modifier
                                .weight(1f)
                        )

                    }
                }
            }

        }
}