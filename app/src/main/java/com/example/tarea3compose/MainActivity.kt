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



/*
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MenuOcupacion() {
    val types = listOf("Ingeniero", "Administrador", "Contable", "Licenciado")
    val default = 0

    var expanded by remember { mutableStateOf(false) }
    var selectedType by remember { mutableStateOf(types[default]) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        },
        modifier = Modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            readOnly = true,
            value = selectedType,
            onValueChange = { },

            label = { Text(text="Ocupacion") },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            },
            colors = ExposedDropdownMenuDefaults.textFieldColors()
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {
            types.forEach { selectionOption ->
                DropdownMenuItem(
                    onClick = {
                        selectedType = selectionOption
                        expanded = false
                    }
                ) {
                    Text(text = selectionOption)
                }
            }
        }
    }
}
*/




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

/*@Composable
fun RegistroPersona(){

    val scaffoldState = rememberScaffoldState()
    var ocup by rememberSaveable() {
        mutableStateOf("")
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Registro de Personas")})
        },

        scaffoldState = scaffoldState

    ) {
        Column(modifier = Modifier.padding(it).padding(8.dp)){
            OutlinedTextField(
                label = {
                    Text(text = "PersonaId")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.FormatListNumbered, contentDescription = null)
                },
                value = ocup,
                onValueChange = {ocup = it},
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                label = {
                    Text(text = "Nombres")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Person, contentDescription = null)
                },
                value = ocup,
                onValueChange = {ocup = it},
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                label = {
                    Text(text = "Email")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Email, contentDescription = null)
                },
                value = ocup,
                onValueChange = {ocup = it},
                modifier = Modifier.fillMaxWidth()
            )



            MenuOcupacion()




            OutlinedTextField(
                label = {
                    Text(text = "Salario")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.MonetizationOn, contentDescription = null)
                },
                value = ocup,
                onValueChange = {ocup = it},
                modifier = Modifier.fillMaxWidth()
            )


            Row() {
                OutlinedButton(
                    onClick = {

                    },
                    modifier = Modifier.padding(8.dp)
                ) {

                    Icon(imageVector = Icons.Default.NewLabel, contentDescription =null )
                    Text(text = "Nuevo")

                }

                OutlinedButton(
                    onClick = {

                    },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Icon(imageVector = Icons.Default.Save, contentDescription =null )
                    Text(text = "Guardar")
                }
                OutlinedButton(
                    onClick = {

                    },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription =null )
                    Text(text = "Eliminar")
                }
            }
        }
    }
}*/




/*@Composable
fun RegistroOcupaciones(){

    val scaffoldState = rememberScaffoldState()
    var ocup by rememberSaveable() {
        mutableStateOf("")
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Registro de Ocupaciones")})
        },
        scaffoldState = scaffoldState
    ) {
        Column(modifier = Modifier.padding(it).padding(8.dp)){
            OutlinedTextField(
                label = {
                    Text(text = "OcupacionId")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.FormatListNumbered, contentDescription = null)
                },
                value = ocup,
                onValueChange = {ocup = it},
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                label = {
                    Text(text = "Nombre Ocupacion")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Work, contentDescription = null)
                },
                value = ocup,
                onValueChange = {ocup = it},
                modifier = Modifier.fillMaxWidth()
            )


            Row() {
                OutlinedButton(
                    onClick = {

                    },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Icon(imageVector = Icons.Default.NewLabel, contentDescription =null )
                    Text(text = "Nuevo")
                }
                OutlinedButton(
                    onClick = {

                    },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Icon(imageVector = Icons.Default.Save, contentDescription =null )
                    Text(text = "Guardar")
                }
                OutlinedButton(
                    onClick = {

                    },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription =null )
                    Text(text = "Eliminar")
                }
            }
        }
    }
}*/





/*@Composable
fun ConsultaPersona(clickRegistro:()->Unit, ClickConsultaOcup:()->Unit){

    val scaffoldState = rememberScaffoldState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Listado de Personas")})
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    clickRegistro()
                },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(imageVector = Icons.Default.Person , contentDescription =null )
            }
        },
        scaffoldState = scaffoldState
    ) {
        Column(modifier = Modifier.padding(it).padding(8.dp)) {

            OutlinedButton(
                onClick = {
                    ClickConsultaOcup()
                }) {
                Icon(imageVector = Icons.Default.Save, contentDescription =null )
                Text(text = "Ocupaciones")
            }


            val lista = listOf("Enel", "Vismar", "Nachely", "Kelvin", "Felix", "Reny")

            LazyColumn(modifier = Modifier.fillMaxWidth()){
                items(lista) { nombre ->
                    RowNombre(nombre)
                }
            }
        }
    }

}*/

/*@Composable
fun RowNombre(nombre: String){
    Row(){
        Text("El nombre es: $nombre")


    }
}*/

@Composable
fun RowOcupaciones(nombre: String){
    Row(){
        Text("Ocupacion : $nombre")


    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    Tarea3ComposeTheme {
        MyApp()
    }
}




/*@Composable
fun ConsultaOcupaciones(clickRegistroOcup:()->Unit){

   val scaffoldState = rememberScaffoldState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Listado de Ocupaciones")})
       },
       floatingActionButton = {
            FloatingActionButton(
              onClick = {
                   clickRegistroOcup()
                },
               backgroundColor = MaterialTheme.colors.primary
           ) {
                Icon(imageVector = Icons.Default.Work , contentDescription =null )
            }
        },
        scaffoldState = scaffoldState
    ) {
        Column(modifier = Modifier.padding(it).padding(8.dp)) {


                val lista = listOf("Ingeniero", "Administrador", "Contable", "Licenciado")

                LazyColumn(modifier = Modifier.fillMaxWidth()) {
                    items(lista) { ocupacion ->
                        RowOcupaciones(ocupacion)
                }
            }
        }
    }
}*/

