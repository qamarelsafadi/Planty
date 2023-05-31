package com.qamar.planty.navigation

import androidx.annotation.StringRes
import androidx.navigation.NavController
import com.qamar.planty.R
import com.qamar.planty.navigation.PlantyDestinationsArgs.ID_ARGS
import com.qamar.planty.navigation.PlantyScreens.DETAILS_SCREEN


object PlantyDestinationsArgs {
    const val ID_ARGS = "id"
}

private object PlantyScreens {
    const val DETAILS_SCREEN = "details"
}

object PlantyDestinations {
    const val DETAILS_ROUTE = "$DETAILS_SCREEN/{$ID_ARGS}"
}

enum class Screens(
    @StringRes val title: Int? = null,
    val showTitle: Boolean? = false
) {
    Home,
    Details(title = R.string.details, showTitle = true),
}

class NavigationActions(private val navController: NavController) {
    fun navigateToDetails(id: Int) {
        navController.navigate("$DETAILS_SCREEN/$id")
    }
}