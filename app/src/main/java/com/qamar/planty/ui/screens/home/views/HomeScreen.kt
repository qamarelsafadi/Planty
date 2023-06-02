package com.qamar.planty.ui.screens.home.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.qamar.planty.R
import com.qamar.planty.data.source.network.plants.model.plants.Plant
import com.qamar.planty.ui.core.views.LoadingView
import com.qamar.planty.ui.screens.home.PlantsViewModel
import com.qamar.planty.ui.screens.home.state.PlantUiState
import com.qamar.planty.ui.screens.home.views.components.CategoryTabs
import com.qamar.planty.ui.theme.Black
import com.qamar.planty.ui.theme.PlantyTheme
import com.qamar.planty.ui.theme.titleFont
import de.palm.composestateevents.EventEffect
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Composable
fun HomeScreen(
    viewModel: PlantsViewModel = hiltViewModel(),
    goToDetails: (Int) -> Unit
) {

    val viewState: PlantUiState by viewModel.uiState.collectAsStateWithLifecycle()

    /**
     * get plants from network
     */

    LaunchedEffect(viewModel.isLoaded.value) {
        if (viewModel.isLoaded.value.not())
            viewModel.getPlants()
    }

    /**
     * Handle Ui state from flow
     */

    when (val state = viewState) {
        is PlantUiState.Loading, PlantUiState.IDLE -> LoadingView()
        is PlantUiState.Success -> {
            HomeContent(
                state.plants ?: persistentListOf(),
                onClickItem = goToDetails
            )
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
fun HomeContent(
    plants: ImmutableList<Plant>,
    onClickItem: (Int) -> Unit
) {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Text(
            text = stringResource(id = R.string.app_name), style = titleFont,
            color = Color.Black,
            modifier = Modifier.padding(start = 52.dp, top = 50.dp)
        )
        CategoryTabs(
            plants,
            onClickItem = onClickItem
        )
        Spacer(modifier = Modifier.weight(1f))

        // Footer
        Row(
            Modifier
                .fillMaxWidth()
                .requiredHeight(150.dp)
                .background(Black, RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.take_care),
                color = Color.White,
                textAlign = TextAlign.Center,
                style = titleFont,
                modifier = Modifier
                    .padding(top = 15.dp)
                    .navigationBarsPadding()
                    .fillMaxWidth(1f)
                    .height(150.dp),
            )
        }
    }
}

@Preview
@Composable
private fun HomeContentPreview() = PlantyTheme {
    HomeContent(persistentListOf()) {}
}

