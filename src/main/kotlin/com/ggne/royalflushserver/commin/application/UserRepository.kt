package com.ggne.royalflushserver.commin.application

import com.ggne.royalflushserver.commin.domain.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<UserEntity, Long>