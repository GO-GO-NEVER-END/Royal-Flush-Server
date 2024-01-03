package com.ggne.royalflushserver.biz.toilet.adapter.out.persistence.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "toilet_specific")
class ToiletSpecificEntity(
    @Id
    val id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "tid")
    val toilet: ToiletEntity,

    val size: Int,

    val disabledAvailable: Boolean,
    val childAvailable: Boolean,
    val babyAvailable: Boolean
)