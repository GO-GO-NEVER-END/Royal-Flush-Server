package com.ggne.royalflushserver.toilet.util

import org.locationtech.jts.geom.Coordinate
import org.locationtech.jts.geom.GeometryFactory
import org.locationtech.jts.geom.Point

object GeoPointUtil {
    private val geometryFactory = GeometryFactory()

    fun getPoint(lat: Double, lon: Double): Point {
        return geometryFactory.createPoint(Coordinate(lat, lon))
    }
}