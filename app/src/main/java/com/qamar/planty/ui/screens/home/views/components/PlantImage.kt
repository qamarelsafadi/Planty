package com.qamar.planty.ui.screens.home.views.components

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.qamar.planty.data.source.network.plants.model.Plant
import com.qamar.planty.ui.core.components.AsyncImage

@Composable
fun PlantImage(currentItem: Plant, modifier: Modifier) {
    Crossfade(
        targetState = currentItem,
        modifier = modifier,
        animationSpec = tween(700)
    ) {
        AsyncImage(
            it.imageUrl,
            modifier = Modifier
                .width(260.dp)
                .height(550.dp)

                .clip(RoundedCornerShape(15.dp))
                ,
            contentScale = ContentScale.Crop
        )
    }
}