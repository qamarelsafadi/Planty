package com.qamar.planty

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.qamar.planty.navigation.NavigationHost
import com.qamar.planty.navigation.Screens
import com.qamar.planty.ui.core.components.TopBar
import com.qamar.planty.ui.theme.PlantyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlantyTheme {
                App()
            }
        }
    }

    @Composable
    private fun App() {
        val navController = rememberNavController()
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentScreen = Screens.valueOf(
            backStackEntry?.destination?.route?.substringBefore("/") ?: Screens.Home.name
        )
        Scaffold(topBar = {
            TopBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = navController::navigateUp
            )
        }) {
            NavigationHost(
                modifier = Modifier.padding(it),
                navController = navController,
            )
        }
    }
}