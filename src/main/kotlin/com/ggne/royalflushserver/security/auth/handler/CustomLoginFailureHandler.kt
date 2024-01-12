package com.ggne.royalflushserver.security.auth.handler

import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.authentication.AuthenticationFailureHandler
import org.springframework.stereotype.Component

@Component
class CustomLoginFailureHandler: AuthenticationFailureHandler{

    private val objectMapper = ObjectMapper()

    // TODO : failure했을 때의 동자 정의하기
    override fun onAuthenticationFailure(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        exception: AuthenticationException?
    ) {
        val data = mapOf("timestamp" to System.currentTimeMillis(), "exception" to exception?.message)
        response?.apply {
            status = HttpServletResponse.SC_UNAUTHORIZED
        }
        response?.outputStream?.println(objectMapper.writeValueAsString(data))

    }
}