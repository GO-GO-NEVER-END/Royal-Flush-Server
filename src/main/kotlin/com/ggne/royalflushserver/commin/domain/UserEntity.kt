package com.ggne.royalflushserver.commin.domain

import jakarta.persistence.*

@Entity
@Table(name = "user")
class UserEntity(
    val name: String,
    val coin: Int,
    val isSsamulie: Boolean
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var uid: Long = 1
}