package com.qamar.planty.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.qamar.planty.data.source.network.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import okhttp3.ResponseBody

fun <E> handleSuccess(data: E?, message: String? = ""): MutableStateFlow<Resource<E>> {
    return MutableStateFlow(
        Resource.success(
            data,
            message = message
        )
    )
}

fun <E> handleExceptions(errorBase: ResponseBody?): MutableStateFlow<Resource<E>> {
    return MutableStateFlow(
        Resource.error(
            null,
            errorBase?.string(),
            null
        )
    )
}
fun <E> handleExceptions(errorBase: Exception?): MutableStateFlow<Resource<E>> {
    return MutableStateFlow(
        Resource.error(
            null,
            errorBase?.message,
            null
        )
    )
}

@Composable
inline fun <reified T : ViewModel> NavController.getSharedViewModel(
    backStackEntry: NavBackStackEntry?,
    route: String = "Parent"
): T {
    val mainEntity = remember(backStackEntry) {
        this.getBackStackEntry(route)
    }
    return hiltViewModel(mainEntity)
}



