package com.example.businesscard.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.compose.ui.Modifier

@Composable
fun Profile(navController: NavHostController) {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
    ) {
        ElevatedButton(
            onClick = { navController.navigate("login") },
            ) {
            Text("ログインする")
        }
        ElevatedButton(
            onClick = { navController.navigate("login") },
        ) {
            Text("ログアウトする")
        }
    }
}