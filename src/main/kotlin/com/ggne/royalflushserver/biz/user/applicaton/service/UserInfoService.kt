package com.ggne.royalflushserver.biz.user.applicaton.service

import com.ggne.royalflushserver.biz.user.applicaton.port.`in`.UserInfoUseCase
import com.ggne.royalflushserver.biz.user.applicaton.port.out.UserPort
import com.ggne.royalflushserver.biz.user.domain.model.User
import org.springframework.stereotype.Service

@Service
class UserInfoService(
    private val userPort: UserPort
) : UserInfoUseCase {

    override fun findUser(userId: String): User? {
        return userPort.findUser(userId)
    }
}