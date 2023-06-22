package com.example.jcomposerickandmorty.presentention.vm

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.map
import com.example.jcomposerickandmorty.domain.usecase.GetAllLocationUseCase
import com.example.jcomposerickandmorty.model.LocationUI
import com.example.jcomposerickandmorty.model.ResultUI
import com.example.jcomposerickandmorty.model.toUI
import com.example.jcomposerickandmorty.presentention.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class LocationViewModel(
    private val locationUseCase: GetAllLocationUseCase
):BaseViewModel() {
    private val _state: MutableStateFlow<PagingData<LocationUI>> = MutableStateFlow(value = PagingData.empty())
    val locationState  = _state.asStateFlow()

    fun getLocationPaging() {
        viewModelScope.launch(Dispatchers.IO) {
            locationUseCase(""
            ).collectLatest {
                _state.value = it.map { it.toUI() }
            }
        }
    }
}