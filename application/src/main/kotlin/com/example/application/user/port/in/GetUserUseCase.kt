package com.example.application.user.port.`in`

import com.example.domain.user.User

interface GetUserUseCase {
    fun get(id: Long): Result

    data class Command(val email: String)
    data class Result(val id: Long, val name: String, val email: String) {
        companion object {
            fun of(user: User) = Result(user.id, user.name, user.email)
        }
    }
}