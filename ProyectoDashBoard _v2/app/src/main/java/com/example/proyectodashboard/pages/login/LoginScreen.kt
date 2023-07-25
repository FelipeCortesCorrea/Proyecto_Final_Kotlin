package com.example.proyectodashboard.pages.login

import android.content.Context
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.example.proyectodashboard.R
import com.example.proyectodashboard.components.CreateChannelNotification
import com.example.proyectodashboard.components.PagesScreen
import com.example.proyectodashboard.components.notificacionSencilla
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout.RESIZE_MODE_ZOOM
import com.google.android.exoplayer2.ui.StyledPlayerView

@Composable
fun VideoView(videoUri: String){
    val context = LocalContext.current

    val exoPlayer = ExoPlayer.Builder(LocalContext.current)
        .build()
        .also { exoPlayer ->
            val mediaItem = MediaItem.Builder()
                .setUri(videoUri)
                .build()
            exoPlayer.setMediaItem(mediaItem)
            exoPlayer.prepare()
            exoPlayer.playWhenReady = true
            exoPlayer.repeatMode = Player.REPEAT_MODE_ALL
        }
    DisposableEffect(
        AndroidView(factory = {
            StyledPlayerView(context).apply {
                player = exoPlayer
                useController = false
                resizeMode = RESIZE_MODE_ZOOM
            }
        }, modifier = Modifier.fillMaxSize()
        )
    ){
        onDispose { exoPlayer.release() }
    }

}

@Composable
fun LoginScreen(navController: NavController ) {

    val idNotification: Int = 0
    val context: Context = LocalContext.current
    val idChannel: String = ("CanalTienda")
    val name = ("CanalTienda")
    val descriptionText = ( "Canal de Notificaciones Tienda CBA")
    val textShort: String = ""
    val textLong: String = "Saludos! Esta es una prueba de notificaciones. Debe aparecer"+
            "un icono a la derecha y el texto puede tener una longitud de 200 caracterer"+
            "El tamaño de la notificacion puede colapsar y/o expandirse"+
            "Gracias y hasta pronto"

    //Funcion de creacion propia como corrutina
    LaunchedEffect(Unit){
        CreateChannelNotification(
            idChannel,
            context,
            name,
            descriptionText,

        )
    }

    //Variables para controlar la accion: True::Login -False::Create
    val showLoginForm = rememberSaveable {
        mutableStateOf(true)
    }
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        VideoView(videoUri = "android.resource://com.example.proyectodashboard/raw/videosena")
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_sena),
                contentDescription = "Logo Sena",
                Modifier.size(250.dp, 250.dp))


            if (showLoginForm.value) {
                Text(
                    text = "Inicia Sesion",
                    modifier = Modifier,
                    color = Color.White

                )
                UserForm(
                    isCreateAccount = false
                ) {
                        email, password ->
                    Log.d("TiendaApp", "Inicio sesion con $email y $password")
                    navController.navigate(route= PagesScreen.DasBoard.name)
                    notificacionSencilla(
                        context,
                        idChannel,
                        idNotification,
                        "Inicio sesion con $email y $password",
                        textShort

                    )

                }
            } else {
                Text(
                    text = "Crear Cuenta Nueva",
                    modifier = Modifier,
                    color = Color.White
                )
                UserForm(
                    isCreateAccount = true
                ) {
                        email, password ->
                    Log.d("TiendaApp", "Creando Cuenta con $email y $password")
                    navController.navigate(route= PagesScreen.DasBoard.name)
                    notificacionSencilla(
                        context,
                        idChannel,
                        idNotification,
                        "Creo cuenta con " +
                                "Email:$email y " +
                                "Password:$password",
                        textShort
                    )

                }
            }
            Spacer(
                modifier = Modifier
                    .height(15.dp)
            )
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val text1 =
                    if (showLoginForm.value)
                        "¿No tienes cuenta?"
                    else
                        "¿Ya tienes cuenta"
                val text2 =
                    if (showLoginForm.value)
                        "Registrate"
                    else
                        "Inicia Sesion"
                Text(
                    text = text1,
                    modifier = Modifier,
                    color = Color.White
                )
                Text(
                    text =text2,
                    modifier = Modifier
                        .clickable { showLoginForm.value = !showLoginForm.value }
                        .padding(start = 5.dp),
                    color = Color.Blue
                )
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun UserForm(
    isCreateAccount: Boolean,
    onDone: (String, String) -> Unit = {email, pwd ->},

){
    val email = rememberSaveable{
        mutableStateOf("")
    }
    val password = rememberSaveable{
        mutableStateOf("")
    }
    val passwordVisible = rememberSaveable{
        mutableStateOf(false)
    }
    val validState = remember(email.value, password.value) {
        email.value.trim().isNotEmpty() && password.value.trim().isNotEmpty()
    }
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        EmailImput(
            emailState = email,


        )
        PasswordInput(
            passwordState = password,
            labelId = "Password",
            passwordVisible = passwordVisible
        )
        Spacer(
            modifier =  Modifier
                .height(15.dp)
        )
        SubmitButton(
            textId =
                if (isCreateAccount)
                    "Crear Cuenta"
                else
                    "Iniciar Sesion",
            inputValid = validState
        ){
            onDone(email.value.trim(), password.value.trim())
            keyboardController?.hide()
        }
    }
}

@Composable
fun SubmitButton(
    textId: String,
    inputValid: Boolean,
    onClic: ()->Unit,


){
    Button(
        onClick =  onClic ,
        modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth(),
        shape = CircleShape,
        enabled = inputValid
    ){
        Text(
            text = textId,
            modifier = Modifier
                .padding(5.dp)
        )

    }
}

@Composable
fun PasswordInput(
    passwordState: MutableState<String>,
    labelId: String,
    passwordVisible: MutableState<Boolean>
){
    val visualTransformation =
        if (passwordVisible.value)
            VisualTransformation.None
        else
            PasswordVisualTransformation()

    OutlinedTextField(
        value = passwordState.value,
        onValueChange = {passwordState.value = it},
        label = {Text(text = labelId)},
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = White,
            unfocusedBorderColor = White,
            focusedLabelColor = White,
            textColor = White,
            disabledTextColor = White
        ),
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        modifier = Modifier
            .padding(
                bottom = 10.dp,
                start = 10.dp,
                end = 10.dp
            )
            .fillMaxWidth(),
        visualTransformation = visualTransformation,
        trailingIcon = {
            if (passwordState.value.isNotBlank())
                PasswordVisibleIcon(passwordVisible)
            else null
        }

    )
}
@Composable
fun PasswordVisibleIcon(
    passwordVisible: MutableState<Boolean>
){
    val image =
        if (passwordVisible.value)
            Icons.Default.VisibilityOff
        else
            Icons.Default.Visibility
    IconButton(onClick = {
        passwordVisible.value = !passwordVisible.value
    }){
        Icon(
            imageVector = image,
            contentDescription = ""
        )
    }
}
@Composable
fun EmailImput(
    emailState: MutableState<String>,
    labelId: String = "Email",


){
    InputField(
        valueState = emailState,
        labelId = labelId,
        keyboardType = KeyboardType.Email
    )
}

@Composable
fun InputField(
    valueState: MutableState<String>,
    labelId: String,
    keyboardType: KeyboardType,
    isSingleLine: Boolean = true
){
    OutlinedTextField(
        value = valueState.value,
        onValueChange = {valueState.value = it},
        label = { Text(text = labelId)},
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = White,
            unfocusedBorderColor = White,
            focusedLabelColor = White,
            textColor = White,
            disabledTextColor = White

        ),
        singleLine = isSingleLine,
        modifier = Modifier
            .padding(
                bottom = 10.dp,
                start = 10.dp,
                end = 10.dp
            )
            .fillMaxWidth(),
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        )
    )
}