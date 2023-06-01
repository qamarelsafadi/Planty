package com.qamar.planty.ui.screens.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.qamar.planty.data.source.network.Status
import com.qamar.planty.data.source.network.plants.repository.PlantsRepository
import com.qamar.planty.ui.screens.home.state.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import de.palm.composestateevents.triggered
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlantsViewModel @Inject constructor(
    private val repository: PlantsRepository
) : ViewModel() {

    val isLoaded = mutableStateOf(false)

    /**
     * State Flows
     */
    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.IDLE)
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()


    /**
     * API Requests
     */

    fun getPlants() {
        viewModelScope.launch {
            _uiState.update {
                HomeUiState.Loading
            }
            repository.getPlants()
                .collect { result ->
                    val uiState = when (result.status) {
                        Status.SUCCESS -> {
                            isLoaded.value = true
                            val data = result.data
                            HomeUiState.Success(
                                plants = data?.toImmutableList()
                            )
                        }

                        Status.LOADING ->
                            HomeUiState.Loading

                        Status.ERROR -> HomeUiState.Failed(
                            onFailure = triggered(
                                result.message
                            )
                        )
                    }
                    _uiState.update {
                        uiState
                    }
                }
        }
    }


    fun onFailure(){
        _uiState.update {
            it.onReset()
        }
    }
}