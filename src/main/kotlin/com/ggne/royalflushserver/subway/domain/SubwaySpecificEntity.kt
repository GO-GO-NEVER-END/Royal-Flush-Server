package com.ggne.royalflushserver.subway.domain

import jakarta.persistence.*

@Entity
@Table(name = "subway")
class SubwaySpecificEntity(
    @ManyToOne
    @JoinColumn(name = "toilet_tid")
    val tid: Long,

    val isOuter: Boolean

) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var subwayNumber: Long? = null
}