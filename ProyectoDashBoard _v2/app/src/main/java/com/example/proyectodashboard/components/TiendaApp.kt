package com.example.proyectodashboard.components
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyecto_login.components.SplashScreen
import com.example.proyectodashboard.pages.login.LoginScreen


import com.example.proyectodashboard.R

enum class PagesScreen(){
    Start,
    DasBoard,
    Splash,

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TiendaAppBar(
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
){

    TopAppBar(
        title = { Text(stringResource(R.string.app_namee) )},
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack){
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }

            }
        }
    )

}
@Composable
fun Dirrecion(
    navController: NavController = rememberNavController(),
){
        NavHost(
            navController = navController as NavHostController,
            startDestination = PagesScreen.Splash.name
        ) {
            composable(route = PagesScreen.Splash.name) {
                SplashScreen(navController)
            }
            composable(route = PagesScreen.Start.name) {
                LoginScreen(navController)
            }
            composable(route= PagesScreen.DasBoard.name){
                MainPage()
            }
        }
}

@Composable
fun TiendaApp(NavController: NavController.Companion) {
    Scaffold(
        topBar = {
            TiendaAppBar(
                canNavigateBack = false,
                navigateUp = { }
            )
        }
    ) { padding ->
        ScaffoldContent(
            padding = padding
        )
    }
}



@Composable
fun ScaffoldContent(
    padding:PaddingValues,
){
    Column(
        modifier = Modifier
            .padding(
                top = 16.dp,
                bottom = padding.calculateBottomPadding()
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
        }
    }
}
