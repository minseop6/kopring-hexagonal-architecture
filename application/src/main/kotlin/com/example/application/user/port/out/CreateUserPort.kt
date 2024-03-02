package com.example.application.user.port.out

import com.example.domain.user.User


interface CreateUserPort {
    fun create(command: Command): User

    data class Command(val name: String, val email: String, val password: String)
}