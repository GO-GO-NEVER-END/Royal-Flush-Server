package com.ggne.royalflushserver.biz.user.applicaton.port.out

import com.ggne.royalflushserver.biz.user.domain.model.User

interface UserPort {
    fun saveUser(user: User)

    fun findUser(id: String): User?
}