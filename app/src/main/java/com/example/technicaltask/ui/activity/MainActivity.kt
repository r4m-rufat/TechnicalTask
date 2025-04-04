package com.example.technicaltask.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.technicaltask.ui.activity.MainNavHost.HomeScreen
import com.example.technicaltask.ui.activity.country.CountryScreen
import com.example.technicaltask.ui.theme.TechnicalTaskTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TechnicalTaskTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)){
                        val homeViewModel: MainViewModel = viewModel()
                        CountryScreen(homeViewModel)


                    }
                }
            }
        }
    }
}