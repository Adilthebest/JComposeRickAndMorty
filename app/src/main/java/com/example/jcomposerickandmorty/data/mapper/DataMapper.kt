package com.example.jcomposerickandmorty.data.mapper

interface DataMapper<T> {
    fun toDomain(): T
}