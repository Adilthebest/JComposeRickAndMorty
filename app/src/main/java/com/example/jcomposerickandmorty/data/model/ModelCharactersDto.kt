package com.example.jcomposerickandmorty.data.model

import com.example.jcomposerickandmorty.domain.model.CLocation
import com.example.jcomposerickandmorty.domain.model.Info
import com.example.jcomposerickandmorty.domain.model.ModelCharacters
import com.example.jcomposerickandmorty.domain.model.Origin
import com.example.jcomposerickandmorty.data.mapper.DataMapper
import com.example.jcomposerickandmorty.domain.model.Result

data class ModelCharactersDto(
    val info: InfoDto,
    val results: List<ResultDto>
) : DataMapper<ModelCharacters> {
    override fun toDomain() = ModelCharacters(
        info.toDomain(),
        results.map { it.toDomain() }
    )
}

data class InfoDto(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: Any
) : DataMapper<Info> {
    override fun toDomain() = Info(
        count,
        next, pages, prev
    )
}

data class ResultDto(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: CLocationDto,
    val name: String,
    val origin: OriginDto,
    val species: String,
    val status: String,
    val type: String,
    val url: String
) : DataMapper<Result> {

    override fun toDomain() = Result(
        created,
        episode,
        gender,
        id,
        image,
        location.toDomain(),
        name,
        origin.toDomain(),
        species,
        status,
        type,
        url
    )
}

data class CLocationDto(
    val name: String,
    val url: String
) : DataMapper<CLocation> {
    override fun toDomain() = CLocation(
        name, url
    )

}

data class OriginDto(
    val name: String,
    val url: String
) : DataMapper<Origin> {
    override fun toDomain() = Origin(
        name, url
    )
}