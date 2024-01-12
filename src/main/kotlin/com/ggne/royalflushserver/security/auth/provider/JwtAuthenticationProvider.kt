package com.ggne.royalflushserver.security.auth.provider

import com.ggne.royalflushserver.biz.user.applicaton.port.`in`.UserInfoUseCase
import com.ggne.royalflushserver.common.constants.NotificationMessages
import com.ggne.royalflushserver.common.utils.EncryptUtils
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component

@Component
class JwtAuthenticationProvider(
    private val userInfoUseCase: UserInfoUseCase,
) : AuthenticationProvider {

    // TODO : 인증 과정 추가
    override fun authenticate(authentication: Authentication?): Authentication {
        val userId = authentication?.principal ?: throw IllegalStateException()
        val userPassword = authentication.credentials ?: throw IllegalStateException()

        val loginUser = userInfoUseCase.findUser(userId as String) ?: throw UsernameNotFoundException(
            NotificationMessages.USER_NOT_FOUND
        )

        if (!EncryptUtils.matchPassword(
                userPassword as String,
                loginUser.password
            )
        ) throw AuthenticationCredentialsNotFoundException(NotificationMessages.INVALID_PASSWORD)

        return UsernamePasswordAuthenticationToken(userId, userPassword)
    }

    override fun supports(authentication: Class<*>?): Boolean {
        return authentication == UsernamePasswordAuthenticationToken::class.java
    }
}