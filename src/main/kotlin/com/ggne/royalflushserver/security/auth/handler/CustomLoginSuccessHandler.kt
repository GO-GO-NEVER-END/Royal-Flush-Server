package com.ggne.royalflushserver.security.auth.handler

import com.ggne.royalflushserver.common.support.JwtConfig
import com.ggne.royalflushserver.common.utils.JwtTokenUtils
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler
import org.springframework.stereotype.Component
import java.time.Duration

@Component
class CustomLoginSuccessHandler(
    private val jwtConfig: JwtConfig
): SimpleUrlAuthenticationSuccessHandler() {

    // TODO : Login Success 시 로직 만들기
    override fun onAuthenticationSuccess(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        authentication: Authentication?
    ) {
        SecurityContextHolder.getContext().authentication = authentication

        val userId = authentication?.principal ?: throw IllegalStateException()
        val signingKey = jwtConfig.secretKey

        val accessToken = JwtTokenUtils.createAccessToken(
            userId as String, signingKey, Duration.ofDays(jwtConfig.accessToken.expireTime.value.toLong())
        )
        val refreshToken = JwtTokenUtils.createRefreshToken(
            userId, signingKey, Duration.ofDays(jwtConfig.refreshToken.expireTime.value.toLong())
        )

        response?.apply {
            addHeader("Authorization", "Bearer $accessToken")
            addHeader("Refresh-Token", refreshToken)
        }
    }

    private fun getJwtSecretKey(): String{
        return jwtConfig.secretKey
    }
}