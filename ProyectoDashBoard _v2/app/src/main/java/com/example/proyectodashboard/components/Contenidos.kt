package com.example.proyectodashboard.components

import com.example.proyectodashboard.R

sealed class Contenidos (
     val image: Int,
     val name: String,
     val descripcion: String,

         ){
    object noticia01: Contenidos(R.drawable.ic_noticia1,"Aprendices del SENA en Antioquia con diversas discapacidades firmaron contrato de continuidad laboral con empresa de tortas","Integrantes del Centro de Comercio que culminaron su ciclo de prácticas fueron vinculados. Algunos tienen discapacidades como autismo, síndrome de Down, sordera o esquizofrenia leve. Son ejemplo de amor al trabajo")
    object noticia02: Contenidos(R.drawable.ic_postre,"Los mejores sabores y aromas del campo, en el paladar de los caqueteños","Es una propuesta gastronómica especializada en la elaboración de alimentos con productos orgánicos de la región, con los que se les garantiza a los visitantes y consumidores un alto contenido nutritivo; estos son cultivados y cosechados por los agricultores de Caquetá. Se trata de 'Tayarú Tienda Amazónica'.")
    object noticia03: Contenidos(R.drawable.ic_agroexpo,"El SENA, una experiencia campesina y muy colombiana en AGROEXPO 2023","Con el compromiso de impulsar la economía rural del país, el Servicio Nacional de Aprendizaje (SENA) hace presencia en la nueva edición de AGROEXPO 2023 con un espacio dedicado a la innovación, la tecnología y el emprendimiento.\n" +
            "\n" +
            "Allí, en Corferias, las personas que visiten el estand del SENA encontrarán una exhibición de las múltiples fortalezas la Entidad. Por ejemplo, el Sistema de Investigación, Innovación y Desarrollo Tecnológico (SENNOVA) presenta la SENAharina, un producto que pretende llegar a miles de indígenas wayúu para evitar su desnutrición.")
    object noticia04: Contenidos(R.drawable.ic_xde,"Se abren nuevas puertas: convocatoria para entregar hasta 93 millones de pesos a emprendedores en Santurbán","El Servicio Nacional de Aprendizaje (SENA), a través del Fondo Emprender, abrió una convocatoria para darle apoyo económico e impulsar a los santandereanos creadores de iniciativas empresariales o negocios, con el fin de poder disminuir las brechas socioeconómicas y apoyar la economía popular.")
 }
