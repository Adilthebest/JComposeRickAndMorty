package com.example.jcomposerickandmorty.di

import com.example.jcomposerickandmorty.data.repository.RepositoryImpl
import com.example.jcomposerickandmorty.domain.repository.Repository
import org.koin.dsl.module

val dataModule = module {
    single<Repository> {RepositoryImpl(get())}
}