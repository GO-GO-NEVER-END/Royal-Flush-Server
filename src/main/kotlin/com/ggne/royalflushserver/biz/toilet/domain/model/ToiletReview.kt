package com.ggne.royalflushserver.biz.toilet.domain.model

import com.ggne.royalflushserver.biz.toilet.adapter.out.persistence.entity.ToiletEntity
import com.ggne.royalflushserver.biz.toilet.domain.vo.Evaluation
import com.ggne.royalflushserver.biz.user.adapter.out.persistence.entity.UserEntity
import java.sql.Timestamp

data class ToiletReview(
    val id: Long? = null,
    val toilet: ToiletEntity,
    val user: UserEntity,
    val evaluation: Evaluation,
    val comment: String,
    val time: Timestamp
)
