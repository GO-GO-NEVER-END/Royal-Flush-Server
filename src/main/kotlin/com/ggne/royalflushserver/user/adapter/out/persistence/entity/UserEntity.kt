package com.ggne.royalflushserver.user.adapter.out.persistence.entity

import com.ggne.royalflushserver.user.domain.model.User
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import lombok.Builder

@Entity
@Table(name = "user")
class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    var userId: String,

    var userPassword: String,

    var name: String,

    var coin: Int = 0,

    var isSsamulie: Boolean = false
) {
    fun toDomain(): User {
        return User(
            id = userId,
            password = "",
            name = name,
            coin = coin,
            isSsamulie = isSsamulie
        )
    }
}