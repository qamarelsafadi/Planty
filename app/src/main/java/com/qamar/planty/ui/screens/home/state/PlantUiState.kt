package com.qamar.planty.ui.screens.home.state

import com.qamar.planty.data.source.network.plants.model.plant.FullPlant
import com.qamar.planty.data.source.network.plants.model.plants.Plant
import de.palm.composestateevents.StateEventWithContent
import de.palm.composestateevents.consumed
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

/**
 * using sealed interface for UiState to make the code more readable when handle it on the view screen
 * I know that I can directly use data class but it will not be as readable as this is when using it
 * in the view screen ( a personal point of view that has no solid resource ^_^" )
 */

sealed interface PlantUiState {
    object Loading : PlantUiState
    object IDLE : PlantUiState

    data class Success(
        val plants: ImmutableList<Plant>? = persistentListOf(),
        val plant: FullPlant? = null,
    ) : PlantUiState

    data class Failed(
        val onFailure: StateEventWithContent<String?> = consumed(),
    ) : PlantUiState

    fun onReset(): PlantUiState {
        val uiState = Success()
        Failed(
            onFailure = consumed()
        )
        return uiState
    }
}