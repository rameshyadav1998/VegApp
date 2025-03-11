package com.example.project1jc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.project1jc.screens.Screen1
import com.example.project1jc.screens.Screen2

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyScreen()
        }
    }
}

@Composable
fun MyScreen() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "screen1") {
        composable(route = "screen1") {
            Screen1(navController = navController)
        }

        composable(route = "screen2") {
            Screen2(navController)
        }
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyScreen()
}