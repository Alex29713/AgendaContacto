package com.example.agendacontactos.Screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
    val navController = rememberNavController()

    // Usar una lista mutable para mantener el estado de los contactos
    val contacts = remember { mutableStateListOf<String>() }

    NavHost(navController = navController, startDestination = "HomeContactos") {

        composable("homeContactos") {
            HomeContactos(navController)
        }
        composable("ingresarContactos") {
            IngresarContactos(navController, contacts)
        }
        composable("editarContactos") {
            EditarContactos(navController, contacts)
        }
        composable("listarContactos") {
            ListarContactos(navController, contacts)
        }
        composable("borrarContactos") {
            BorrarContactos(navController, contacts )
        }
    }
}

