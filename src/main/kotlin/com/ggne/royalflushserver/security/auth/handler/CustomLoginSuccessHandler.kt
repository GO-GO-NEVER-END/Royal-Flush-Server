package com.ggne.royalflushserver.security.auth.handler

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler
import org.springframework.stereotype.Component

@Component
class CustomLoginSuccessHandler: SimpleUrlAuthenticationSuccessHandler() {

    // TODO : Login Success 시 로직 만들기
    override fun onAuthenticationSuccess(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        authentication: Authentication?
    ) {
        SecurityContextHolder.getContext().authentication = authentication
        // TODO : 로그인 완료 로직
    }
}