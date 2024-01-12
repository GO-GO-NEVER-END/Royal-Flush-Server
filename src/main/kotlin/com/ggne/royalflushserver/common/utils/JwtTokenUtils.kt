package com.ggne.royalflushserver.common.utils

import com.ggne.royalflushserver.security.auth.domain.vo.AuthTokenType
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import java.nio.charset.StandardCharsets
import java.time.Duration
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

// TODO : JWT 에 담을 정보 제공하기
object JwtTokenUtils {
    fun createAccessToken(
        userId: String,
        signingKey: String,
        duration: Duration
    ): String {
        val claims = mapOf(
            "type" to AuthTokenType.ACCESS,
            "id" to userId,
        )
        return create(claims, signingKey, duration)
    }

    fun createRefreshToken(
        userId: String,
        signingKey: String,
        duration: Duration
    ): String {
        val claims = mapOf(
            "type" to AuthTokenType.REFRESH,
            "id" to userId,
        )
        return create(claims, signingKey, duration)
    }

    // todo : create 함수 구체화하기
    fun create(
        claim: Map<String, Any>,
        signingKey: String,
        duration: Duration
    ): String {

        val token: String

        val key = Keys.hmacShaKeyFor(signingKey.toByteArray(StandardCharsets.UTF_8))
        val expirationDateTime = LocalDateTime.now().plus(duration)

        try {
            token = Jwts.builder()
                .setClaims(claim)
                .signWith(key)
                .setExpiration(Date.from(expirationDateTime.atZone(ZoneId.systemDefault()).toInstant()))
                .compact()
        } catch (e: Exception) {
            throw RuntimeException()
        }

        return token
    }
}