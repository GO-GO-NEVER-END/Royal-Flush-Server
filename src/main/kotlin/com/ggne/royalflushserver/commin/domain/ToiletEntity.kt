package com.ggne.royalflushserver.commin.domain

import jakarta.persistence.*

@Entity
@Table(name = "toilet")
class ToiletEntity(
    val toiletName: String,

    val toiletAddress: String,

    @ManyToOne
    @JoinColumn(name = "user_uid")
    val uid: String
    ) {

    // Toilet Id를 우리가 만들어 줘야 상세정보랑 위치정보를 저장할 수 있지 않을까?
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var tid: Long? = null

    var score: Float = 0f
    var zeroTag: Int = 0
    var twoTag: Int = 0
    var fiveTag: Int = 0
}