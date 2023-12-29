package com.ggne.royalflushserver.toilet.adapter.out.persistence.entity

import com.ggne.royalflushserver.toilet.domain.model.Toilet
import com.ggne.royalflushserver.user.adapter.out.persistence.entity.UserEntity
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "toilet")
class ToiletEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    val name: String,

    @ManyToOne
    @JoinColumn(name = "register_id")
    val registerUser: UserEntity,

    val latitude: Long,
    val longitude: Long,
    val address: String
){
    fun toDomain(): Toilet = Toilet(
        id = id,
        name = name,
        registerUser = registerUser,
        latitude = latitude,
        longitude = longitude,
        address = address
    )
}