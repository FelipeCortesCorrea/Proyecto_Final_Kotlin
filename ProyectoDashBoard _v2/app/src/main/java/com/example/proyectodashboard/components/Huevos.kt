package com.example.proyectodashboard.components

import com.example.proyectodashboard.R

sealed class Huevos (
    val image: Int,
    val name: String,
    val descripcion: String,
    val precio: String
        ){
    object Huevos01: Huevos(R.drawable.ic_huevosss,"Huevos A","son los huevos frescos que no presentan ningún tipo de defecto y que no han sido lavados ni sometidos a ningún tipo de tratamiento para su conservación","14980, 30 und")
    object Huevos02: Huevos(R.drawable.ic_huevosss,"Huevos AA","Las yemas son redondas, se levantan sobre la clara y están casi libres de defectos. Los cascarones están limpios e intactos","18000, 30 und")
    object Huevos03: Huevos(R.drawable.ic_huevosss,"Huevos AAA","Las yemas son redondas, se levantan sobre la clara y están casi libres de defectos. Los cascarones están limpios e intactos","18500, 24 und")
}
