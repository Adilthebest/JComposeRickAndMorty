package com.example.jcomposerickandmorty.presentention.screens.character

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.example.jcomposerickandmorty.presentention.screens.components.item.ItemNote
import com.example.jcomposerickandmorty.presentention.vm.MainViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun CharactersScreen() {
    val viewModel: MainViewModel = koinViewModel()
    val moviePagingItems = viewModel.characterState.collectAsLazyPagingItems()

viewModel.getCharacterPaging()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Characters",
            color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        LazyColumn(Modifier.padding(10.dp)) {
            items(moviePagingItems) { item ->

                item?.let { ItemNote(note = it) }
            }

                }
        }

}
