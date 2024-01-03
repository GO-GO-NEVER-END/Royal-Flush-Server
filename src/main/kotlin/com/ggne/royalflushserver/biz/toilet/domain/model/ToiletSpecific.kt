package com.ggne.royalflushserver.biz.toilet.domain.model

import com.ggne.royalflushserver.biz.toilet.adapter.out.persistence.entity.ToiletEntity

data class ToiletSpecific (
    val id: Long? = null,
    val toilet: ToiletEntity,
    val size: Int,
    val disabledAvailable: Boolean,
    val childAvailable: Boolean,
    val babyAvailable: Boolean
)