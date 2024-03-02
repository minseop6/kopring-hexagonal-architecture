package com.example.application.user.port.`in`

import com.example.domain.user.User

interface SignInUseCase {
    fun signIn(command: Command): Result

    data class Command(val email: String, val password: String)
    data class Result(val id: Long, val name: String, val email: String) {
        companion object {
            fun of(user: User) = Result(user.id, user.name, user.email)
        }
    }
}