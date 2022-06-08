package com.example.tarea3compose.ui.theme.ocupacion

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun RegistroOcupaciones(
    navHostController: NavHostController,
    viewModel: OcupacionViewModel = hiltViewModel()
){


    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Registro de Ocupaciones") })
        },
        //scaffoldState = scaffoldState
    ) {
        Column(modifier = Modifier
            .padding(it)
            .padding(8.dp)){
            OutlinedTextField(
                label = {
                    Text(text = "Nombre Ocupacion")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Work, contentDescription = null)
                },
                value = viewModel.nombre,
                onValueChange = {viewModel.nombre = it},
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
                              viewModel.Guardar()

                        navHostController.navigateUp()

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
}