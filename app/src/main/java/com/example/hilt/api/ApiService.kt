package com.example.hilt.api

import com.example.hilt.data.model.User
import retrofit2.Response
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface ApiService {
    @GET("users")
    suspend fun getUsers(): Response<List<User>>
}