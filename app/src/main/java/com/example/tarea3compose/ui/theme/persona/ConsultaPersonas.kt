package com.example.tarea3compose.ui.theme.persona

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Save
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ConsultaPersona(clickRegistro:()->Unit, ClickConsultaOcup:()->Unit){

    val scaffoldState = rememberScaffoldState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Listado de Personas") })
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

}

@Composable
fun RowNombre(nombre: String){
    Row(){
        Text("El nombre es: $nombre")


    }
}