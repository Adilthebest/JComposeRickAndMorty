package com.example.jcomposerickandmorty.data.remote

import com.example.jcomposerickandmorty.data.base.BasePagingResponse
import com.example.jcomposerickandmorty.data.base.BasePagingSource
import com.example.jcomposerickandmorty.data.model.CLocationDto
import com.example.jcomposerickandmorty.data.model.EpisodeDto
import com.example.jcomposerickandmorty.data.model.LocationDto
import com.example.jcomposerickandmorty.data.model.ModelCharactersDto
import com.example.jcomposerickandmorty.data.model.ResultDto
import com.example.jcomposerickandmorty.domain.model.ModelCharacters
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("character")
    suspend fun getAllCharacters(
        @Query("page") page: Int,
        @Query("name") name: String?,
        @Query("status") status: String?,
        @Query("gender") gender: String?,
        @Query("species") species: String?,
    ): BasePagingResponse<ResultDto>

    @GET("episode")
    suspend fun getAllEpisode(
        @Query("page") page: Int,
        @Query("name") name: String?
    ): BasePagingResponse<EpisodeDto>

    @GET("location")
    suspend fun getAllLocation(
        @Query("page") page: Int,
        @Query("name") name: String?
    ): BasePagingResponse<LocationDto>
}