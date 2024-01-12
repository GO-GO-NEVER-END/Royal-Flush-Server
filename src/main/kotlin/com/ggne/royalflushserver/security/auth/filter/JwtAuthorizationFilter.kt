package com.ggne.royalflushserver.security.auth.filter

import com.ggne.royalflushserver.common.constants.NotificationMessages
import com.ggne.royalflushserver.security.auth.handler.CustomLoginFailureHandler
import com.ggne.royalflushserver.security.auth.handler.CustomLoginSuccessHandler
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

// TODO : 로그인 정보에 대한 검증 작업
class JwtAuthorizationFilter(
    authenticationManager: AuthenticationManager,
    loginSuccessHandler: CustomLoginSuccessHandler,
    loginFailureHandler: CustomLoginFailureHandler
) : UsernamePasswordAuthenticationFilter() {

    init {
        setAuthenticationManager(authenticationManager)
        setAuthenticationSuccessHandler(loginSuccessHandler)
        setAuthenticationFailureHandler(loginFailureHandler)
    }

    @Throws(Exception::class)
    override fun attemptAuthentication(request: HttpServletRequest?, response: HttpServletResponse?): Authentication {
        val id = obtainUsername(request)
        val password = obtainPassword(request)
        if (id.isNullOrBlank() || password.isNullOrBlank()) throw UsernameNotFoundException(NotificationMessages.AUTHENTICATION_NOT_INVALID)

        val authToken = getAuthenticationToken(id, password)

        setDetails(request, authToken)

        return authenticationManager.authenticate(authToken)
    }

    override fun obtainPassword(request: HttpServletRequest?): String? {
        return request?.getParameter(USER_ID_PARAM)
    }

    override fun obtainUsername(request: HttpServletRequest?): String? {
        return request?.getParameter(USER_PASSWORD_PARAM)
    }

    /**
     * 로그인 과정용 authToken을 발급해 주는 함수
     */
    private fun getAuthenticationToken(userId: String, userPassword: String): UsernamePasswordAuthenticationToken {
        return UsernamePasswordAuthenticationToken(userId, userPassword)
    }

    companion object {
        const val USER_ID_PARAM = "userId"
        const val USER_PASSWORD_PARAM = "userPassword"
    }
}