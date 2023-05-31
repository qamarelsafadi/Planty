package com.qamar.planty.ui.screens.home.views.item

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.qamar.planty.data.source.network.plants.model.Links
import com.qamar.planty.data.source.network.plants.model.Plant
import com.qamar.planty.ui.screens.home.views.components.PlantImage
import com.qamar.planty.ui.screens.home.views.components.PlantProperty
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@OptIn(ExperimentalFoundationApi::class)
@Composable
 fun PagerView(
    pagerState: PagerState,
    plants: ImmutableList<Plant>
) {
    var currentItem by remember {
        mutableStateOf(plants.first())
    }

    LaunchedEffect(pagerState) {
        // get selected item and store it in current item
        snapshotFlow { pagerState.currentPage }.collect { page ->
            currentItem = plants[page]
        }
    }

    HorizontalPager(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        pageCount = plants.size,
        state = pagerState,
    ) { page ->
        Box(
            Modifier
                .padding(top = 50.dp)
                .fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ) {
            PlantImage(
                currentItem,
                Modifier
                    .padding(bottom = 80.dp, start = 35.dp)
                    .align(Alignment.CenterStart)
            )
            PlantProperty(
                currentItem, Modifier
                    .padding(
                        end = 26.dp,
                        bottom = 50.dp
                    )
                    .align(Alignment.CenterEnd)
                    .wrapContentWidth()
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
private fun ItemPagerPreview(){
    val pagerState = rememberPagerState()
    val pages = persistentListOf(
        Plant(
            author = "maiestatis",
            bibliography = "iusto",
            commonName = null,
            family = "senserit",
            familyCommonName = null,
            genus = "constituto",
            genusId = 3744,
            id = 5544,
            links = Links(
                genus = "sapien",
                plant = "diam",
                self = "lorem"
            ),
            plantId = 5367,
            rank = "interesset",
            scientificName = "Madeleine Yates",
            slug = "tritani",
            status = "quas",
            synonyms = listOf(),
            year = 2013
        )
    )
    PagerView(pagerState, plants = pages)
}