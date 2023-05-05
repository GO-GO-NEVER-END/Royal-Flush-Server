package com.ggne.royalflushserver.toilet.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import org.locationtech.jts.geom.Point

@Entity
@Table(name = "toilet_location")
class ToiletLocationEntity(
    @Id
    @OneToOne
    @JoinColumn(name = "toilet_tid")
    val tid: Long,

    @Column(name = "point", columnDefinition = "POINT")
    val toiletGeo: Point
)