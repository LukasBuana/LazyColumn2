package com.example.lazycolumn

import com.example.lazycolumn.model.User
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<User>
}
