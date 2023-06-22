package com.example.jcomposerickandmorty.domain.usecase

import com.example.jcomposerickandmorty.domain.repository.Repository


class GetAllCharactersUseCase(
    private val rickAndMortyRepository: Repository
) {
     operator fun invoke(name: String?, status: String?, gender: String?, species: String?) =
         rickAndMortyRepository.getAllCharacters(name, status, gender, species)

}