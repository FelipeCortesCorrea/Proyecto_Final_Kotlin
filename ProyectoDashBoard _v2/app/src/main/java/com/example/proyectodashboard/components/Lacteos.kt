package com.example.proyectodashboard.components

import com.example.proyectodashboard.R

sealed class Lacteos (
    val image: Int,
    val name: String,
    val descripcion: String,
    val precio: String
        ){
    object Lacteos01: Lacteos(R.drawable.ic_lechee,"Leche","Leche directamente de la vaca","3000, Lt")
    object Lacteos02: Lacteos(R.drawable.ic_queso,"Queso","El queso es un alimento sólido que se obtiene por maduración de la cuajada de la leche animal una vez eliminado el suero","10000")
    object Lacteos03: Lacteos(R.drawable.ic_yogurt,"Yogur","es un producto lácteo obtenido mediante la fermentación de la leche por medio de bacterias","2000, Lt")
    object Lacteos04: Lacteos(R.drawable.ic_quesocrema,"Queso Crema","El queso crema es un tipo de queso untable que se obtiene al cuajar mediante fermentos lácticos una mezcla de leche y nata","4500, 230 gr")
}

