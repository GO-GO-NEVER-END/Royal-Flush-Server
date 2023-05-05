package com.ggne.royalflushserver.toilet.domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "toilet_review")
class ToiletReviewEntity(
    @Id
    @ManyToOne
    @JoinColumn(name = "toilet_tid")
    val tid: Long,

    @Id
    @ManyToOne
    @JoinColumn(name = "user_uid")
    val uid: Long,

    @Enumerated(EnumType.ORDINAL)
    val evaluation: Evaluation,

    val tags: String,

    val comment: String,

    val time: LocalDateTime
) {
    enum class Evaluation {
        BAD, OK, GOOD
    }
}