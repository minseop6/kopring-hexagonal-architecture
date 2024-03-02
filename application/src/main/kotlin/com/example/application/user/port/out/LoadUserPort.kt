package com.example.application.user.port.out

import com.example.domain.user.User

interface LoadUserPort {
    fun findByEmail(email: String): User?
}