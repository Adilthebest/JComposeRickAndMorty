package com.example.jcomposerickandmorty.data.pagingsource

import com.example.jcomposerickandmorty.data.base.BasePagingSource
import com.example.jcomposerickandmorty.data.model.LocationDto
import com.example.jcomposerickandmorty.data.remote.ApiService
import com.example.jcomposerickandmorty.domain.model.Location

class LocationPagingSource(
    private val service: ApiService,
    private val name: String?
) : BasePagingSource<LocationDto, Location>({
    service.getAllLocation(it, name)
})
