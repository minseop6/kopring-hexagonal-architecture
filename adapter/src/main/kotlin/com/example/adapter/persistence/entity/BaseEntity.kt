package com.example.adapter.persistence.entity

import jakarta.persistence.Column
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime

open class BaseEntity {
    @CreatedDate
    @Column(updatable = false)
    val createdAt: LocalDateTime = LocalDateTime.now()

    @LastModifiedDate
    @Column(updatable = false)
    val updatedAt: LocalDateTime = LocalDateTime.now()
}