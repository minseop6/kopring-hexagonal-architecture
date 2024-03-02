package com.example.domain.feed

import java.time.LocalDateTime

data class Feed(
    val id: Long,
    val title: String,
    val content: String,
    val userId: Long,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)