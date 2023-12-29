package com.ggne.royalflushserver.toilet.adapter.out.persistence.repository

import com.ggne.royalflushserver.toilet.adapter.out.persistence.entity.ToiletSpecificEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ToiletSpecificRepository : JpaRepository<ToiletSpecificEntity, Long> {
}