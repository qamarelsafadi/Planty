package com.qamar.planty.ui.screens.home.state

import com.qamar.planty.data.source.network.plants.model.Plant
import de.palm.composestateevents.StateEventWithContent
import de.palm.composestateevents.consumed
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

/**
 * using sealed interface for UiState to make the code more readable when handle it on the view screen
 * I know that I can directly use data class but it will not be as readable as this is when using it
 * in the view screen ( a personal point of view that has no solid resource ^_^" )
 */

sealed interface HomeUiState {
    object Loading : HomeUiState
    object IDLE : HomeUiState

    data class Success(
        val plants: ImmutableList<Plant>? = persistentListOf(),
    ) : HomeUiState

    data class Failed(
        val onFailure: StateEventWithContent<String?> = consumed(),
    ) : HomeUiState

    fun onReset(): HomeUiState {
        val uiState = Success()
        Failed(
            onFailure = consumed()
        )
        return uiState
    }
}