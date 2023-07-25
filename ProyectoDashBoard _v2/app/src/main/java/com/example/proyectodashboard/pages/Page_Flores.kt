package com.example.proyectodashboard.pages

import android.content.Context
import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.proyectodashboard.R
import com.example.proyectodashboard.components.Flores
import com.example.proyectodashboard.components.notificacionImagen
import com.example.proyectodashboard.components.notificacionSencilla


@Composable
fun Page_Flores() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),

    ){
       items(listaProductosflores){producto ->
           ProductCardFlore(producto = producto)
       }
    }
}
val listaProductosflores = listOf(
    Flores.Flor01,
    Flores.Flor02,
    Flores.Flor03,
    Flores.Flor04,

)

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun ProductCardFlore(producto: Flores){

    val idNotification: Int = 0
    val context: Context = LocalContext.current
    val idChannel: String = ("CanalTienda")
    val name: String = ("CanalTienda")
    val descriptionText: String = stringResource(R.string.canal_Notifi)
    val textShort: String = "El usuario vio el producto ${producto.name}"
    val textLong: String = "El usuario envio el producto al carrito"



    val iconoBig = BitmapFactory.decodeResource(
        context.resources,
        R.drawable.ic_sena
    )
    val imagenBig = BitmapFactory.decodeResource(
        context.resources,
        producto.image
    )
    var showDialog by remember { mutableStateOf(false) }

    Card(
        onClick = { showDialog = true},
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Image(painter = painterResource(producto.image), 
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Column {
                    Text(
                        text = producto.name,
                        style = MaterialTheme.typography.h6
                    )
                    Text(
                        text ="$ ${producto.precio}",
                        style = MaterialTheme.typography.body1
                    )
                    Row (
                        verticalAlignment = Alignment.CenterVertically

                            ) {
                        Button(
                            onClick = {showDialog = true},
                            modifier = Modifier
                        ) {
                            Text(
                                text = "Detalles"
                            )
                        }
                        Spacer(modifier = Modifier
                            .weight(1f)

                        )
                        IconButton(
                            onClick = {
                                notificacionImagen(
                                    context,
                                    idChannel,
                                    idNotification,
                                    "El usuario envio el producto al carrito",
                                    textLong,
                                    iconoBig,
                                    imagenBig
                                )

                            }
                        ){
                            Icon(
                                imageVector = Icons.Default.ShoppingCart,
                                contentDescription = null
                            )
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
                                        Text(text = "$ ${producto.precio}")
                                    }

                                }
                                Row (
                                    verticalAlignment = Alignment.CenterVertically
                                        ){
                                    Button(
                                        modifier = Modifier.padding(top = 16.dp),
                                        onClick = {
                                            showDialog = false
                                            notificacionSencilla(
                                                context,
                                                idChannel,
                                                idNotification,
                                                "El usuario vio el producto ${producto.name}",
                                                textShort
                                            )
                                        }
                                    ) {
                                        Text(text = "Cerrar")
                                    }
                                    Spacer(
                                        modifier = Modifier
                                            .weight(1f)
                                    )
                                    IconButton(
                                        onClick = {notificacionImagen(
                                            context,
                                            idChannel,
                                            idNotification,
                                            "El usuario envio el producto al carrito",
                                            textLong,
                                            iconoBig,
                                            imagenBig
                                           )
                                        }
                                    ){
                                        Icon(
                                            modifier = Modifier
                                                .padding(top = 16.dp)
                                                .size(36.dp),
                                            imageVector = Icons.Default.ShoppingCart,
                                            contentDescription = "Car",
                                            tint = Color.Black,
                                        )
                                    }
                                }
                            }
                        }

                    }

            }
        }
    }
}