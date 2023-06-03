package com.qamar.planty.ui.screens.home.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.qamar.planty.R
import com.qamar.planty.data.source.network.plants.model.plant.FullPlant
import com.qamar.planty.ui.core.components.AsyncImage
import com.qamar.planty.ui.core.views.LoadingView
import com.qamar.planty.ui.screens.home.PlantsViewModel
import com.qamar.planty.ui.screens.home.state.PlantUiState
import com.qamar.planty.ui.theme.normalFont
import com.qamar.planty.ui.theme.textFont
import de.palm.composestateevents.EventEffect

@Composable
fun DetailsScreen(
    viewModel: PlantsViewModel = hiltViewModel(),
    id: Int
) {
    val viewState: PlantUiState by viewModel.uiState.collectAsStateWithLifecycle()

    /**
     * get plant details from network
     */

    LaunchedEffect(viewModel.isLoaded.value) {
        if (viewModel.isLoaded.value.not())
            viewModel.getPlantDetails(id)
    }

    /**
     * Handle Ui state from flow
     */

    when (val state = viewState) {
        is PlantUiState.Loading, PlantUiState.IDLE -> LoadingView()
        is PlantUiState.Success -> {
            state.plant?.let {
                DetailsContent(
                    plant = it
                )
            }
        }

        is PlantUiState.Failed -> {
            EventEffect(
                event = state.onFailure,
                onConsumed = viewModel::onFailure
            ) { _ ->
                // show toast alert
            }
        }
    }
}

@Composable
fun DetailsContent(plant: FullPlant) {
    Column(
        Modifier.padding(horizontal = 16.dp, vertical = 25.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.author),
                    style = textFont,
                )
                Text(
                    text = plant.author,
                    style = normalFont,
                    fontSize = 16.sp,

                    )
            }

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.family),
                    style = textFont,
                )
                Text(
                    text = plant.family.name,
                    style = normalFont,
                    fontSize = 16.sp
                )
            }

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.year),
                    style = textFont,
                )
                Text(
                    text = "${plant.year}",
                    style = normalFont,
                    fontSize = 16.sp
                )
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.bibliography),
                    style = textFont,
                )
                Text(
                    text = plant.bibliography,
                    style = normalFont,
                    fontSize = 16.sp
                )
            }
        }
        AsyncImage(
            imageUrl = plant.imageUrl ?: "",
            modifier = Modifier
                .padding(vertical = 30.dp)
                .size(300.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Text(
            text = stringResource(id = plant.desription),
            style = normalFont
        )
    }
}

@Preview
@Composable
private fun DetailsContentPreview() {
    DetailsContent(FullPlant())
}