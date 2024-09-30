package com.example.agendacontactos.Screen

import android.provider.ContactsContract.Contacts
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp



@Composable
fun BorrarContactos(navController: NavController, contacts: MutableList<String>){

    val contactosMutable = remember { mutableStateListOf(*contacts.toTypedArray()) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally, // Centrar el contenido
        verticalArrangement = Arrangement.Center

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

        Spacer(modifier = Modifier.height(16.dp))

        Text("Eliminar Contactos", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(8.dp))

        // Usamos LazyColumn para mostrar la lista de contactos
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp) // Espacio entre elementos
        ) {
            items(contactosMutable) { contact ->
                // Cada contacto en una Card con botón para eliminar
                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFFFCDD2)), // Color de fondo diferente
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
                                fontWeight = FontWeight.Bold
                            )
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        // Botón para eliminar contacto
                        Button(onClick = {
                            contactosMutable.remove(contact) // Eliminar el contacto de la lista mutable
                            contacts.remove(contact) // Eliminar el contacto de la lista original
                        }) {
                            Text("Eliminar")
                        }
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