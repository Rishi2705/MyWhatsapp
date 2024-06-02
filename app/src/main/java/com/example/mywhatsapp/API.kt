package com.example.mywhatsapp

import retrofit2.Call
import retrofit2.http.GET

interface API {
    @GET("users")
    fun getUserData(): Call<PluginDataClass>
}