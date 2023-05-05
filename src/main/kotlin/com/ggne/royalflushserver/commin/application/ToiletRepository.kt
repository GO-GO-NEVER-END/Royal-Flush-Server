package com.ggne.royalflushserver.commin.application

import com.ggne.royalflushserver.commin.domain.ToiletEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ToiletRepository : JpaRepository<ToiletEntity, Long>