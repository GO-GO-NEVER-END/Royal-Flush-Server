package com.ggne.royalflushserver.biz.user.adapter.out.persistence

import com.ggne.royalflushserver.biz.user.adapter.out.persistence.entity.UserEntity
import com.ggne.royalflushserver.biz.user.adapter.out.persistence.repository.UserRepository
import com.ggne.royalflushserver.biz.user.applicaton.port.out.UserPort
import com.ggne.royalflushserver.biz.user.domain.model.User
import org.springframework.stereotype.Component

@Component
class UserPersistenceAdapter(
    private val userRepository: UserRepository
) : UserPort {

    override fun saveUser(user: User) {
        val userEntity = UserEntity(
            name = user.name,
            userId = user.userId,
            userPassword = user.password
        )

        userRepository.save(userEntity)
    }

    override fun findUser(id: String): User? {
        return userRepository
            .findByUserIdEquals(id)
            .map { it.toDomain() }
            .orElse(null)
    }
}