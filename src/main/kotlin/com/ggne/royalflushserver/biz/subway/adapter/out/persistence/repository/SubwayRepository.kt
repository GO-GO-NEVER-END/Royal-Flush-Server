package com.ggne.royalflushserver.biz.subway.adapter.out.persistence.repository

import com.ggne.royalflushserver.biz.subway.adapter.out.persistence.entity.SubwayEntity
import org.springframework.data.jpa.repository.JpaRepository

interface SubwayRepository: JpaRepository<Long, SubwayEntity>