package com.example.project1jc.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun Screen2(navController: NavHostController) {
Box (modifier = Modifier.fillMaxSize().padding(16.dp)){
    Text(text = "Screen2", modifier = Modifier.align(Alignment.Center))
}
}