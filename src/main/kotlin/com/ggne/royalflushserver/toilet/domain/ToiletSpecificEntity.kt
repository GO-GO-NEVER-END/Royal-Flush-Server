package com.ggne.royalflushserver.toilet.domain

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "toilet_specific")
class ToiletSpecificEntity(
    @Id
    @ManyToOne
    @JoinColumn(name = "toilet_tid")
    val tid: Long,

    val size: Int,

    val isForDisabled: Boolean,

    val isForChild: Boolean,

    val isDorBaby: Boolean
)