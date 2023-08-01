package com.example.cupcake.data

import com.example.cupcake.R

object DataSource {
    val flavors = listOf(
        R.string.vainilla,
        R.string.chocolate,
        R.string.arequipe,
        R.string.salted_caramel,
        R.string.coffe,
    )

    val quantityOptions = listOf(
        Pair(R.string.one_cupcakes, 1),
        Pair(R.string.six_cupcakes, 6),
        Pair(R.string.twelve_cupcakes, 12)
    )
}