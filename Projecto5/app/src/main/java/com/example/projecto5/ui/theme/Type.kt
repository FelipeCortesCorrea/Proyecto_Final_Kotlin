package com.example.projecto5.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.projecto5.R

// Set of Material typography styles to start with
private val fontFamilyKulim = FontFamily(
    listOf(
        Font(
            resId = R.font.kulim_park_regular
        ),
        Font(
            resId = R.font.kulim_park_light,
            weight = FontWeight.Light
        )
    )
)

private val fontFamilyLato = FontFamily(
    listOf(
        Font(
            resId = R.font.lato_regular
        ),
        Font(
            resId = R.font.lato_bold,
            weight = FontWeight.Bold
        )
    )
)

val typography = Typography(
    titleLarge = TextStyle(
        fontFamily = fontFamilyKulim,
        fontWeight = FontWeight.Light,
        fontSize = 28.sp,
        letterSpacing = (1.15).sp
    ),
    titleMedium = TextStyle(
        fontFamily = fontFamilyKulim,
        fontSize = 15.sp,
        letterSpacing = (1.15).sp
    ),
    titleSmall = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        letterSpacing = 0.sp
    ),
    bodySmall = TextStyle(
        fontSize = 14.sp,
        letterSpacing = 0.sp
    ),
    labelLarge = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        letterSpacing = (1.15).sp
    ),
    labelSmall = TextStyle(
        fontFamily = fontFamilyKulim,
        fontSize = 12.sp,
        letterSpacing = (1.15).sp
    ),
)
/*val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp*/

    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */