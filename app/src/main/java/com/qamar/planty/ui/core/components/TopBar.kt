package com.qamar.planty.ui.core.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.qamar.planty.R
import com.qamar.planty.navigation.Screens
import com.qamar.planty.ui.theme.titleFont


/**
 * Composable that displays the topBar and displays back button if back navigation is possible.
 */

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun TopBar(
    currentScreen: Screens,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    if (currentScreen.showTitle == true) {
        CenterAlignedTopAppBar(
            title = {
                Text(stringResource(id = currentScreen.title!!),
                    style = titleFont)
            },
            modifier = modifier,
            navigationIcon = {
                if (canNavigateBack) {
                    IconButton(onClick = navigateUp) {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_arrow_left),
                            contentDescription = "back button",
                        )
                    }
                }
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Color.White
            )
        )
    }
}
