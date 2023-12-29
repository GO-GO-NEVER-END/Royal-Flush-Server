package com.ggne.royalflushserver.user.adapter.out.persistence.repository

import com.ggne.royalflushserver.user.adapter.out.persistence.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface UserRepository : JpaRepository<UserEntity, Long> {
    fun findByUserIdEquals(userId: String): Optional<UserEntity>
}