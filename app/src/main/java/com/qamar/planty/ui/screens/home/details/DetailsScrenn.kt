package com.qamar.planty.ui.screens.home.details

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.qamar.planty.ui.screens.home.PlantsViewModel

@Composable
fun DetailsScreen(
    viewModel: PlantsViewModel = hiltViewModel(),
    id: Int) {

    /**
     * get plant details from network
     */

    LaunchedEffect(viewModel.isLoaded.value) {
        if (viewModel.isLoaded.value.not())
            viewModel.getPlantDetails(id)
    }
}