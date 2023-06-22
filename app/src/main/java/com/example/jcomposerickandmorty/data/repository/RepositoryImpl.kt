package com.example.jcomposerickandmorty.data.repository

import com.example.jcomposerickandmorty.data.pagingsource.CharacterPagingSource
import com.example.jcomposerickandmorty.data.pagingsource.EpisodePagingSource
import com.example.jcomposerickandmorty.data.pagingsource.LocationPagingSource
import com.example.jcomposerickandmorty.data.remote.ApiService
import com.example.jcomposerickandmorty.domain.repository.Repository
import com.example.jcomposerickandmorty.presentention.base.BaseRepository

class RepositoryImpl(private val apiService: ApiService) : Repository, BaseRepository() {
    override fun getAllCharacters(
        name: String?,
        status: String?,
        gender: String?,
        species: String?
    ) = doPagingRequest(CharacterPagingSource(apiService, name, status, gender, species))

    override fun getAllEpisode(name: String?) =
        doPagingRequest(EpisodePagingSource(apiService, name))

    override fun getAllLocation(name: String?) =
        doPagingRequest(LocationPagingSource(apiService, name))
}