package com.example.jcomposerickandmorty.data.model

import com.example.jcomposerickandmorty.data.mapper.DataMapper
import com.example.jcomposerickandmorty.domain.model.Location


data class ModelLocation(
    val info: Info,
    val results: List<CLocationDto>
)

data class LocationDto(
    val created: String,
    val dimension: String,
    val id: Int,
    val name: String,
    val residents: List<String>,
    val type: String,
    val url: String,
) : DataMapper<Location> {
    override fun toDomain() = Location(
        created, dimension, id, name, residents, type, url
    )
}
