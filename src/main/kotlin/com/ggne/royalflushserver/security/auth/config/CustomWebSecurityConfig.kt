package com.ggne.royalflushserver.security.auth.config

import com.ggne.royalflushserver.security.auth.filter.JwtAuthenticationFilter
import com.ggne.royalflushserver.security.auth.filter.JwtAuthorizationFilter
import com.ggne.royalflushserver.security.auth.handler.CustomLoginFailureHandler
import com.ggne.royalflushserver.security.auth.handler.CustomLoginSuccessHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain

@EnableWebSecurity
@Configuration
class CustomWebSecurityConfig(
    private val authenticationManagerBuilder: AuthenticationManagerBuilder,
) {

    @Bean
    @Throws(Exception::class)
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        val authorizationFilter = JwtAuthorizationFilter(
            authenticationManagerBuilder.orBuild,
            CustomLoginSuccessHandler(),
            CustomLoginFailureHandler()
        )

        val authenticationFilter = JwtAuthenticationFilter()

        http
            .cors().and()
            .csrf().disable()
            .authorizeHttpRequests { request ->
                request
                    .requestMatchers("/login/**").permitAll()
                    .requestMatchers("/logout/**").permitAll()
                    .requestMatchers("/join/**").permitAll()
                    .anyRequest().authenticated()
            }
            .httpBasic().disable()
            .formLogin().disable()
            .addFilterBefore(authenticationFilter, JwtAuthenticationFilter::class.java)
            .addFilterAfter(authorizationFilter, JwtAuthorizationFilter::class.java)

        return http.build()
    }
}