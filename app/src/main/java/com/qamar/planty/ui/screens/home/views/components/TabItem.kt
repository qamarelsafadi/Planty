package com.qamar.planty.ui.screens.home.views.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.material.Text
import androidx.compose.material3.Tab
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.zIndex
import com.qamar.planty.data.source.network.plants.model.plants.Plant
import com.qamar.planty.ui.theme.Gray
import com.qamar.planty.ui.theme.textFont

@Composable
fun TabItem(
    plant: Plant,
    isSelected: Boolean,
    onTabClicked: () -> Unit
) {

    val color: Color by animateColorAsState(
        if (isSelected) Color.White else Gray
    )
    Tab(
        modifier = Modifier.zIndex(6f),
        text = {
            Text(
                text = plant.commonName ?: "", color = color,
                style = textFont
            )
        },
        selected = isSelected,
        onClick = {
            onTabClicked()
        },
    )
}