package com.qamar.planty.ui.screens.home.views.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.qamar.planty.data.source.network.plants.model.plants.Plant


@Composable
 fun PlantProperty(currentItem: Plant, modifier: Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(19.dp)
    ) {
        repeat(currentItem.properties.size) {
            CircularProgress(currentItem.properties[it])
        }
    }
}

