package com.example.jcomposerickandmorty.data.pagingsource

import com.example.jcomposerickandmorty.data.base.BasePagingSource
import com.example.jcomposerickandmorty.data.model.ResultDto
import com.example.jcomposerickandmorty.data.remote.ApiService
import com.example.jcomposerickandmorty.domain.model.Result

class CharacterPagingSource(
    private val service: ApiService,
    private val name: String?,
    private val status: String?,
    private val gender: String?,
    private val species: String?
) : BasePagingSource<ResultDto, Result>({
    service.getAllCharacters(it, name, status, gender, species)
})
