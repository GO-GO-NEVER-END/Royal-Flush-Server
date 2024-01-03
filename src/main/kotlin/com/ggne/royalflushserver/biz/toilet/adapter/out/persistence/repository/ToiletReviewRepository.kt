package com.ggne.royalflushserver.biz.toilet.adapter.out.persistence.repository

import com.ggne.royalflushserver.biz.toilet.adapter.out.persistence.entity.ToiletReviewEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ToiletReviewRepository: JpaRepository<ToiletReviewEntity, Long>