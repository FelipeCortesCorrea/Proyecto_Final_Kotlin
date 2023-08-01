package com.example.proyectodashboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.proyectodashboard.components.MainPage
import com.example.proyectodashboard.ui.theme.ProyectoDashBoardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProyectoDashBoardTheme {
                // A surface container using the 'background' color from the theme
                MainPage()
            }
        }
    }
}

