package com.ggne.royalflushserver.security.auth.domain.model

data class AuthTokenPair(
    private val accessToken: String,
    private val refreshToken: String
)