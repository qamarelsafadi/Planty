package com.qamar.planty.ui.core.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.qamar.planty.R

@Composable
fun AsyncImage(
    imageUrl: Any,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Fit
) {
    SubcomposeAsyncImage(
        modifier = modifier,
        model = imageUrl,
        error = {
            Image(
                painter = painterResource(R.drawable.placeholder), contentDescription = "",
            )
        },
        loading = {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    Modifier.size(10.dp),
                    color = Color.Black,
                    strokeWidth = 0.5.dp
                )
            }
        },
        contentDescription = "",
        contentScale = contentScale
    )
}
