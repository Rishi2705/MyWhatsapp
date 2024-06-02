package com.example.mywhatsapp

data class PluginDataClass(
    val limit: Int,
    val skip: Int,
    val total: Int,
    val users: List<User>
)