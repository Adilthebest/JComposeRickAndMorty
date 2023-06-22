package com.example.jcomposerickandmorty.presentention.vm

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.jcomposerickandmorty.domain.usecase.GetAllCharactersUseCase
import com.example.jcomposerickandmorty.domain.usecase.GetAllEpisodeUseCase
import com.example.jcomposerickandmorty.domain.usecase.GetAllLocationUseCase
import com.example.jcomposerickandmorty.model.ResultUI
import com.example.jcomposerickandmorty.model.toUI
import com.example.jcomposerickandmorty.presentention.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

class MainViewModel(
    private val charactersUseCase: GetAllCharactersUseCase,
) : BaseViewModel() {

    private val _getAllCharactersSearch = MutableStateFlow<String?>(null)
    val getAllCharactersSearch = _getAllCharactersSearch.asStateFlow()

    private val _state: MutableStateFlow<PagingData<ResultUI>> = MutableStateFlow(value = PagingData.empty())
    val characterState  = _state.asStateFlow()


    private var _statusFilter = MutableStateFlow<String?>(null)
    private val _speciesFilter = MutableStateFlow<String?>(null)
    private val _genderFilter = MutableStateFlow<String?>(null)

    val statusFilter = _statusFilter.asStateFlow()
    val speciesFilter = _speciesFilter.asStateFlow()
    val genderFilter = _genderFilter.asStateFlow()

         fun getCharacterPaging() {
             viewModelScope.launch(Dispatchers.IO) {
                 charactersUseCase(
                     getAllCharactersSearch.value,
                     _statusFilter.value,
                     _genderFilter.value,
                     _speciesFilter.value
                 ).collectLatest {
                     _state.value = it.map { it.toUI() }
                 }
             }
         }

         fun filter(status: String?, species: String?, gender: String?) {
             _statusFilter.value = status
             _speciesFilter.value = species
             _genderFilter.value = gender
         }

         fun getAllSearchQuery(newQuery: String?) {
             _getAllCharactersSearch.value = newQuery
         }
     }

