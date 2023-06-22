package com.example.jcomposerickandmorty.model

import com.example.jcomposerickandmorty.domain.model.CLocation
import com.example.jcomposerickandmorty.domain.model.Origin
import com.example.jcomposerickandmorty.domain.model.Result

data class ResultUI (
        val created: String,
        val episode: List<String>,
        val gender: String,
        val id: Int,
        val image: String,
        val location: CLocationUI,
        val name: String,
        val origin: COriginUI,
        val species: String,
        val status: String,
        val type: String,
        val url: String
        )

fun Result.toUI() = ResultUI(
        created,
        episode,
        gender,
        id,
        image,
        location.toUI(),
        name,
        origin.toUI(),
        species,
        status,
        type,
        url
)

data class CLocationUI(
        val name: String,
        val url: String
)

fun CLocation.toUI() = CLocationUI(
        name, url
)

data class COriginUI(
        val name: String,
        val url: String
)

fun Origin.toUI() = COriginUI(
        name, url
)