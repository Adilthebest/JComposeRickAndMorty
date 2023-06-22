package com.example.jcomposerickandmorty.presentention.vm

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.example.jcomposerickandmorty.domain.usecase.GetAllEpisodeUseCase
import com.example.jcomposerickandmorty.model.EpisodeUi
import com.example.jcomposerickandmorty.model.LocationUI
import com.example.jcomposerickandmorty.model.toUI
import com.example.jcomposerickandmorty.presentention.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class EpisodeViewModel(
    private val episodeUseCase: GetAllEpisodeUseCase,
    ):BaseViewModel() {
    private val _state: MutableStateFlow<PagingData<EpisodeUi>> = MutableStateFlow(value = PagingData.empty())
    val episodeState  = _state.asStateFlow()

    fun getEpisodePaging() {
        viewModelScope.launch(Dispatchers.IO) {
            episodeUseCase(
                ""
            ).collectPagingRequest {it.toUI()}.collectLatest {
                _state.value = it
            }
        }
    }

}