package com.ggne.royalflushserver.toilet.adapter.out.persistence.entity

import com.ggne.royalflushserver.toilet.domain.vo.Evaluation
import com.ggne.royalflushserver.user.adapter.out.persistence.entity.UserEntity
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.sql.Timestamp

@Entity
@Table(name = "toilet_review")
class ToiletReviewEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "tid")
    val toilet: ToiletEntity,

    @ManyToOne
    @JoinColumn(name = "uid")
    val user: UserEntity,

    @Enumerated(EnumType.STRING)
    val evaluation: Evaluation,

    val comment: String,

    val time: Timestamp
)