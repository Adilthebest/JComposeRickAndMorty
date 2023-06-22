package com.example.jcomposerickandmorty.domain.usecase

import com.example.jcomposerickandmorty.domain.repository.Repository


class GetAllLocationUseCase(
    private val rickAndMortyRepository:Repository
) {
    operator fun invoke(name: String?) = rickAndMortyRepository.getAllLocation(name)
}