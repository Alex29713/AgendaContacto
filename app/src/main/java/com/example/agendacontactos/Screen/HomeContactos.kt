package com.example.agendacontactos.Screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeContactos(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Agenda de Contactos", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(32.dp))

        // Botón para navegar a la pantalla de ingresar contactos
        Button(
            onClick = { navController.navigate("ingresarContactos") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ingresar Contactos")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para navegar a la pantalla de listar contactos
        Button(
            onClick = { navController.navigate("listarContactos") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Listar Contactos")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para navegar a la pantalla de Editar contactos
        Button(
            onClick = { navController.navigate("EditarContactos") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Editar Contactos")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para navegar a la pantalla de borrar contactos
        Button(
            onClick = { navController.navigate("borrarContactos") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Borrar Contactos")
        }

    }
}
