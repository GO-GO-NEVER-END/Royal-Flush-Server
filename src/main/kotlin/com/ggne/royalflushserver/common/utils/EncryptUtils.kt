package com.ggne.royalflushserver.common.utils

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

object EncryptUtils {
    private val bCryptPasswordEncoder = BCryptPasswordEncoder()

    fun encodePassword(password: String): String {
        return bCryptPasswordEncoder.encode(password)
    }

    fun matchPassword(inputPassword: String, savedPassword: String): Boolean {
        return bCryptPasswordEncoder.matches(inputPassword, savedPassword)
    }
}