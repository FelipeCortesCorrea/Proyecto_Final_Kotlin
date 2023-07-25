package com.example.proyectodashboard.components

import com.example.proyectodashboard.R

sealed class Flores (
    val image: Int,
    val name: String,
    val descripcion: String,
    val precio: String

    ){
    object Flor01: Flores(R.drawable.ic_flores,"Amelia","Hortensias colombianas con calidad tipo exportación","2000")
    object Flor02: Flores(R.drawable.ic_rosas,"Rosas","grupo de arbustos generalmente espinosos y floridos","2500")
    object Flor03: Flores(R.drawable.ic_margarita,"Margarita","muy utilizada a efectos decorativos mezclada con el césped","3000")
    object Flor04: Flores(R.drawable.ic_azalea,"Azalea"," las azaleas son los arbustos de flores del género Rhododendron","5000")





}
