package com.ggne.royalflushserver.security.auth

import com.ggne.royalflushserver.security.auth.handler.CustomLoginFailureHandler
import com.ggne.royalflushserver.security.auth.handler.CustomLoginSuccessHandler
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

class CustomAuthenticationFilter(
    private val authenticationManager: AuthenticationManager,
    private val successHandler: CustomLoginSuccessHandler,
    private val failureHandler: CustomLoginFailureHandler
): UsernamePasswordAuthenticationFilter() {
    init {
        setAuthenticationManager(authenticationManager)
        setAuthenticationSuccessHandler(successHandler)
        setAuthenticationFailureHandler(failureHandler)
    }

    // TODO : 전달받은 id, 비밀번호에 대한 유효성 검사
    override fun attemptAuthentication(request: HttpServletRequest?, response: HttpServletResponse?): Authentication {
        val id = obtainUsername(request)
        val password = obtainPassword(request)

        val token = UsernamePasswordAuthenticationToken(id, password)
        setDetails(request, token)

        return getAuthenticationManager().authenticate(token)
    }

    override fun obtainUsername(request: HttpServletRequest?): String? {
        return super.obtainUsername(request)
    }

    override fun obtainPassword(request: HttpServletRequest?): String? {
        return super.obtainPassword(request)
    }
}