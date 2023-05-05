package com.ggne.royalflushserver.teatime.domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "teatime_article")
class TeatimeArticleEntity(
    val articleUrl: String,
    val articleTitle: String,
    val articleDate: LocalDateTime
){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var articleId: Long? = null
}