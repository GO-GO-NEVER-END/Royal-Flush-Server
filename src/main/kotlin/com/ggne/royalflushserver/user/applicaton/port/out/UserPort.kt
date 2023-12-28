package com.ggne.royalflushserver.user.applicaton.port.out

import com.ggne.royalflushserver.user.domain.model.User

interface UserPort {
    fun saveUser(user: User)

    fun findUser(id: String): User?
}