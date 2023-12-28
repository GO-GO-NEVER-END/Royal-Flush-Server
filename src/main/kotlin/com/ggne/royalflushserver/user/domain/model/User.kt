package com.ggne.royalflushserver.user.domain.model

data class User(
    val id: String,
    val password: String,
    val name: String,
    val coin: Int,
    val isSsamulie: Boolean
)
