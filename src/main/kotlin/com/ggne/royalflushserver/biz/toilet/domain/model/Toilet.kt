package com.ggne.royalflushserver.biz.toilet.domain.model

import com.ggne.royalflushserver.biz.user.adapter.out.persistence.entity.UserEntity

data class Toilet(
    var id: Long? = null,
    val name: String,
    val registerUser: UserEntity,
    val latitude: Long,
    val longitude: Long,
    val address: String
)