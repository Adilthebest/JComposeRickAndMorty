package com.example.jcomposerickandmorty.di


import com.example.jcomposerickandmorty.presentention.vm.EpisodeViewModel
import com.example.jcomposerickandmorty.presentention.vm.LocationViewModel
import com.example.jcomposerickandmorty.presentention.vm.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
  viewModel { MainViewModel(get()) }
  viewModel { LocationViewModel(get()) }
  viewModel { EpisodeViewModel(get()) }

}