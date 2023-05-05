package com.ggne.royalflushserver.teatime.domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "week_toilet")
class WeekToiletEntity(
    @ManyToOne
    @JoinColumn(name = "toilet_tid")
    val bestTid: Long,

    @ManyToOne
    @JoinColumn(name = "user_uid")
    val ssamulie: Long,

    @ManyToOne
    @JoinColumn(name = "user_uid")
    val lactobacillus: Long,

    val dateTime: LocalDateTime
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val weekToiletNumber: Int? = null
}