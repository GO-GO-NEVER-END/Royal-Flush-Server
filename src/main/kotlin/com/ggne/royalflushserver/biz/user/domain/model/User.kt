package com.ggne.royalflushserver.biz.user.domain.model

data class User(
    val id: Long? = null,
    val userId: String,
    val password: String,
    val name: String,
    val coin: Int,
    val isSsamulie: Boolean
)
