package com.example.jcomposerickandmorty.di

import com.example.jcomposerickandmorty.domain.usecase.GetAllCharactersUseCase
import com.example.jcomposerickandmorty.domain.usecase.GetAllEpisodeUseCase
import com.example.jcomposerickandmorty.domain.usecase.GetAllLocationUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetAllCharactersUseCase(rickAndMortyRepository = get()) }
    factory { GetAllEpisodeUseCase(rickAndMortyRepository = get()) }
    factory { GetAllLocationUseCase(rickAndMortyRepository = get()) }
}