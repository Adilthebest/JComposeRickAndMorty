package com.example.jcomposerickandmorty.presentention.screens.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jcomposerickandmorty.presentention.screens.character.CharactersScreen
import com.example.jcomposerickandmorty.presentention.screens.episode.EpisodeScreen
import com.example.jcomposerickandmorty.presentention.screens.location.LocationsScreen
import com.example.jcomposerickandmorty.presentention.screens.utils.BottomNavItem

@Composable
fun Navigation(navController: NavHostController) {

    NavHost(navController, startDestination = BottomNavItem.CharactersScreen.screen_route) {
        composable(BottomNavItem.CharactersScreen.screen_route) {
            CharactersScreen()
        }
        composable(BottomNavItem.EpisodeScreen.screen_route) {
            EpisodeScreen()
        }
        composable(BottomNavItem.LocationsScreen.screen_route) {
            LocationsScreen()
        }
    }
}