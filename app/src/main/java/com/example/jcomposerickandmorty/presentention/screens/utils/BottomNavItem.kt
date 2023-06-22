package com.example.jcomposerickandmorty.presentention.screens.utils

import com.example.jcomposerickandmorty.R

sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String) {
    object CharactersScreen : BottomNavItem("Characters", R.drawable.morty,"character")
    object EpisodeScreen : BottomNavItem("Episodes", R.drawable.morty,"episode")
    object LocationsScreen : BottomNavItem("Locations", R.drawable.morty,"location")
}