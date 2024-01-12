package com.ggne.royalflushserver.biz.user.applicaton.port.`in`

import com.ggne.royalflushserver.biz.user.domain.model.User


interface UserInfoUseCase {
    fun findUser(userId: String): User?
}