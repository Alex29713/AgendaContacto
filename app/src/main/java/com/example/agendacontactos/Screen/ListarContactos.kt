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
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@Composable
fun ListarContactos(navController: NavController, contacts: List<String>, ) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally, // Centrar el contenido
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(8.dp))

        IconButton(onClick = {
            navController.navigate("homeContactos") // Volver a HomeContactos
        },
            Modifier.align(Alignment.Start)) {
            Icon(
                imageVector = Icons.Default.ArrowBack, // Ícono de flecha
                contentDescription = "Volver a Home"
            )
        }
        Spacer(modifier = Modifier.height(8.dp))

        Text("Contactos Registrados", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))


        // Usamos LazyColumn para manejar mejor la lista de contactos
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp) // Espacio entre elementos
        ) {
            items(contacts) { contact ->
                // Cada contacto en una Card
                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFE3F2FD)), // Color de fondo
                    elevation = CardDefaults.cardElevation(8.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally // Centrar contenido
                    ) {
                        Text(
                            text = contact,
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        if (contacts.isEmpty()) {
            Text(text = "No hay Contactos Registados")

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    navController.navigate("ingresarContactos")
                },
                modifier = Modifier.align(Alignment.CenterHorizontally) // Centrar el botón
            ) {
                Text("Ingresar Contacto")
            }
        }
    }
}
