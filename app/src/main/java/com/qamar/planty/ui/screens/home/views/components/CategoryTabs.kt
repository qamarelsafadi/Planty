package com.qamar.planty.ui.screens.home.views.components


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Divider
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.TabPosition
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.qamar.planty.data.source.network.plants.model.Links
import com.qamar.planty.data.source.network.plants.model.Plant
import com.qamar.planty.ui.screens.home.views.item.PagerView
import com.qamar.planty.ui.theme.PlantyTheme
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CategoryTabs(
    plants: ImmutableList<Plant>
) {
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState()
    val indicator = @Composable { tabPositions: List<TabPosition> ->
        CustomIndicator(tabPositions, pagerState)
    }

    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        ScrollableTabRow(
            modifier = Modifier
                .padding(top = 33.dp, start = 37.dp)
                .height(30.dp),
            selectedTabIndex = pagerState.currentPage,
            indicator = indicator,
            backgroundColor = Color.White,
            edgePadding = 0.dp,
            divider = {
                Divider(color = Color.Transparent)
            }
        ) {
            plants.forEachIndexed { index, plant ->
                TabItem(plant, isSelected = index == pagerState.currentPage,
                onTabClicked = {
                    scope.launch {
                        pagerState.animateScrollToPage(index,pagerState.currentPageOffsetFraction)
                    }
                })
            }
        }
        PagerView(pagerState, plants)
    }
}


@Preview
@Composable
private fun CategoryTabsPreview() = PlantyTheme {
    CategoryTabs(persistentListOf(
        Plant(
            author = "tractatos",
            bibliography = "vulputate",
            commonName = null,
            family = "cetero",
            familyCommonName = null,
            genus = "sadipscing",
            genusId = 2228,
            id = 8093,
            links = Links(
                genus = "alia",
                plant = "ipsum",
                self = "vero"
            ),
            plantId = 2976,
            rank = "omittam",
            scientificName = "Cornell Campbell",
            slug = "duis",
            status = "maiorum",
            synonyms = listOf(),
            year = 1988
        )
    ))
}