package com.example.tarea3compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tarea3compose.ui.theme.Tarea3ComposeTheme
import com.example.tarea3compose.util.Screen
import androidx.compose.material.Icon
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.modifier.modifierLocalOf
import com.example.tarea3compose.model.Ocupacion
import com.example.tarea3compose.ui.theme.ocupacion.ConsultaOcupaciones
import com.example.tarea3compose.ui.theme.ocupacion.RegistroOcupaciones
import com.example.tarea3compose.ui.theme.persona.ConsultaPersona
import com.example.tarea3compose.ui.theme.persona.RegistroPersona
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tarea3ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
     val navHostController = rememberNavController( )

    NavHost(navController = navHostController, startDestination = Screen.ConsultaPersona.route){
        composable(route = Screen.ConsultaPersona.route){
            ConsultaPersona(clickRegistro = {navHostController.navigate(Screen.RegistroPersona.route)}, ClickConsultaOcup = {navHostController.navigate(Screen.ConsultaOcupaciones.route)})
        }
        composable(route = Screen.RegistroPersona.route){
            RegistroPersona(navHostController = navHostController)
        }
        composable(Screen.ConsultaOcupaciones.route){
            ConsultaOcupaciones(clickRegistroOcup = {navHostController.navigate(Screen.RegistroOcupaciones.route)})
        }
        composable(route = Screen.RegistroOcupaciones.route){
            RegistroOcupaciones(navHostController = navHostController)
        }
    }
}

@Composable
fun RowOcupaciones(ocupacion: Ocupacion){
    Row(){
        Text(text = ocupacion.nombres)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    Tarea3ComposeTheme {
        MyApp()
    }
}


