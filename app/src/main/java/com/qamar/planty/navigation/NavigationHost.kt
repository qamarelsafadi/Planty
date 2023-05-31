package com.qamar.planty.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType.Companion.IntType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.qamar.planty.navigation.PlantyDestinations.DETAILS_ROUTE
import com.qamar.planty.navigation.PlantyDestinationsArgs.ID_ARGS
import com.qamar.planty.ui.screens.home.views.HomeScreen

@Composable
fun NavigationHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screens.Home.name,
    navActions: NavigationActions = remember(navController) {
        NavigationActions(navController)
    },
) {
    NavHost(navController = navController, startDestination = startDestination, modifier) {
        composable(Screens.Home.name) {
            HomeScreen(
                goToDetails = navActions::navigateToDetails
            )
        }
        
        // Note: You shouldn't be passing Parcelables at all as arguments
        // and never has been a recommended pattern
        // instead pass an unique key that represent your data and handle it
        // inside you vm or repository
        composable(
            DETAILS_ROUTE,
            arguments = listOf(navArgument(ID_ARGS) {
                type = IntType
            })
        ) {
          //  DetailsScreen()
        }
    }
}