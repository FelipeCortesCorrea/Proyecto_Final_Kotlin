package com.example.proyectodashboard.components

import com.example.proyectodashboard.R

sealed class Principal (
    val image: Int,
    val name: String,
    val descripcion: String,
    val precio: String
        ){
    object producto01: Principal(R.drawable.ic_lechee,"Leche","Leche directamente de la vaca","3000, Lt")
    object producto02: Principal(R.drawable.ic_huevosss,"Huevos A","son los huevos frescos que no presentan ningún tipo de defecto y que no han sido lavados ni sometidos a ningún tipo de tratamiento para su conservación","14980, 30 und")
    object producto03: Principal(R.drawable.ic_lechuga,"Lechuga","es una planta anual de la familia Asteraceae. Se cultiva sobre todo como verdura de hoja, pero a veces también por su tallo y sus semillas","1000")
    object producto04: Principal(R.drawable.ic_flores,"Amelia","Hortensias colombianas con calidad tipo exportación","2000")
    object producto05: Principal(R.drawable.ic_manzana,"Manzana","es el fruto comestible de la especie Malus domestica, el manzano común. Es una fruta pomácea de forma redonda y sabor muy dulce","3000")
    object producto06: Principal(R.drawable.ic_rosas,"Rosas","grupo de arbustos generalmente espinosos y floridos","2500")
    object producto07: Principal(R.drawable.ic_yogurt,"Yogur","es un producto lácteo obtenido mediante la fermentación de la leche por medio de bacterias","2000, Lt")
    object producto08: Principal(R.drawable.ic_huevosss,"Huevos AAA","Las yemas son redondas, se levantan sobre la clara y están casi libres de defectos. Los cascarones están limpios e intactos","18500, 24 und")
    object producto09: Principal(R.drawable.ic_banano,"Banana","conocido también como banano, plátano, guineo maduro, guineo, cambur o gualele, es un fruto comestible","4000")
    object producto10: Principal(R.drawable.ic_azalea,"Azalea"," las azaleas son los arbustos de flores del género Rhododendron","5000")

}

