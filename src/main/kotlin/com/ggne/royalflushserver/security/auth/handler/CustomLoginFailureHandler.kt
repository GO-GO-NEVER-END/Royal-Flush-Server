package com.ggne.royalflushserver.security.auth.handler

import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.authentication.AuthenticationFailureHandler
import org.springframework.stereotype.Component

@Component
class CustomLoginFailureHandler: AuthenticationFailureHandler{

    private lateinit var objectMapper: ObjectMapper

    override fun onAuthenticationFailure(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        exception: AuthenticationException?
    ) {
        response?.status = HttpServletResponse.SC_UNAUTHORIZED

        // TODO : failure했을 때의 return 형태 지정하기
    }
}