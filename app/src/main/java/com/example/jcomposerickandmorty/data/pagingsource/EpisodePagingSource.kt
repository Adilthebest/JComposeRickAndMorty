package com.example.jcomposerickandmorty.data.pagingsource

import com.example.jcomposerickandmorty.data.base.BasePagingSource
import com.example.jcomposerickandmorty.data.model.EpisodeDto
import com.example.jcomposerickandmorty.data.remote.ApiService
import com.example.jcomposerickandmorty.domain.model.Episode

class EpisodePagingSource(
    private val apiService: ApiService,
    private val name: String?
) : BasePagingSource<EpisodeDto, Episode>({
    apiService.getAllEpisode(it, name)
})
