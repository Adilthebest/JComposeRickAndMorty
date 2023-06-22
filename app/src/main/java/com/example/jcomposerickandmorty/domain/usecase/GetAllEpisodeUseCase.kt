package com.example.jcomposerickandmorty.domain.usecase

import com.example.jcomposerickandmorty.domain.repository.Repository

class GetAllEpisodeUseCase(
    private val rickAndMortyRepository: Repository
) {
    operator fun invoke(name: String?) = rickAndMortyRepository.getAllEpisode(name)
}