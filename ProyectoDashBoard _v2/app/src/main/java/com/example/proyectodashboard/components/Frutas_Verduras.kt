package com.example.proyectodashboard.components

import com.example.proyectodashboard.R

sealed class Frutas_Verduras (
    val image: Int,
    val name: String,
    val descripcion: String,
    val precio: String
        ){
    object Fruta01: Frutas_Verduras(R.drawable.ic_manzana,"Manzana","es el fruto comestible de la especie Malus domestica, el manzano común. Es una fruta pomácea de forma redonda y sabor muy dulce","3000")
    object Fruta02: Frutas_Verduras(R.drawable.ic_lechuga,"Lechuga","es una planta anual de la familia Asteraceae. Se cultiva sobre todo como verdura de hoja, pero a veces también por su tallo y sus semillas","1000")
    object Fruta03: Frutas_Verduras(R.drawable.ic_pera,"Pera"," fruto de distintas especies del género Pyrus, integrado por árboles caducifolios conocidos comúnmente como perales","3000")
    object Fruta04: Frutas_Verduras(R.drawable.ic_tomate,"Tomate","una especie herbácea que pertenece a la familia de las solanáceas y es nativa del continente americano","3500")
    object Fruta05: Frutas_Verduras(R.drawable.ic_banano,"Banana","conocido también como banano, plátano, guineo maduro, guineo, cambur o gualele, es un fruto comestible","4000")
    object Fruta06: Frutas_Verduras(R.drawable.ic_brocoli,"Brocoli","es una planta de la familia de las brasicáceas. Existen otras variedades de la misma especie, tales como: repollo, la coliflor, el colinabo","5000")
}
