package com.example.jcomposerickandmorty.domain.repository

import androidx.paging.PagingData
import com.example.jcomposerickandmorty.domain.model.Episode
import com.example.jcomposerickandmorty.domain.model.Location
import com.example.jcomposerickandmorty.domain.model.Result
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getAllCharacters(
        name: String?,
        status: String?,
        gender: String?,
        species: String?
    ): Flow<PagingData<Result>>

    fun getAllEpisode(name: String?): Flow<PagingData<Episode>>

    fun getAllLocation(name: String?): Flow<PagingData<Location>>
}