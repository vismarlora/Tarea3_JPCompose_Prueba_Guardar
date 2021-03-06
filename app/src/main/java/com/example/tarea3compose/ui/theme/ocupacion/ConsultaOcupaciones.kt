package com.example.tarea3compose.ui.theme.ocupacion

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Work
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tarea3compose.RowOcupaciones

@Composable
fun ConsultaOcupaciones(viewModel: OcupacionViewModel = hiltViewModel(), clickRegistroOcup:()->Unit){

    val scaffoldState = rememberScaffoldState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Listado de Ocupaciones") })
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
        Column(modifier = Modifier
            .padding(it)
            .padding(8.dp)) {


            val lista = viewModel.ocupacion.collectAsState(initial = emptyList())

            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(lista.value) { ocupacion ->
                    RowOcupaciones(ocupacion = ocupacion)
                }
            }
        }
    }
}