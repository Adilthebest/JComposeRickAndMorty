package com.example.jcomposerickandmorty.data.model

import com.example.jcomposerickandmorty.domain.model.Episode
import com.example.jcomposerickandmorty.data.mapper.DataMapper

data class ModelEpisode(
    val info: Info,
    val results: List<EpisodeDto>
)

data class Info(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: Any
)

data class EpisodeDto(
    val air_date: String,
    val characters: List<String>,
    val created: String,
    val episode: String,
    val id: Int,
    val name: String,
    val url: String
) : DataMapper<Episode> {
    override fun toDomain() = Episode(
        air_date, characters, created, episode, id, name, url
    )
}