package com.ggne.royalflushserver.common.support

import lombok.Data
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

// TODO : data class로 바꿀 수 있는지 테스트하기
@Component
@ConfigurationProperties("jwt")
@Data
class JwtConfig {

    lateinit var secretKey: String
    lateinit var accessToken: AccessTokenProperties
    lateinit var refreshToken: RefreshTokenProperties

    data class AccessTokenProperties(
        val expireTime: TimeValue
    )

    data class RefreshTokenProperties(
        val expireTime: TimeValue
    )
}

data class TimeValue(
    val value: Int,
    val timeUnit: String
)