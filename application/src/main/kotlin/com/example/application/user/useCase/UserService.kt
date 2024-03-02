package com.example.application.user.useCase

import com.example.application.user.port.`in`.SignInUseCase
import com.example.application.user.port.`in`.SignUpUseCase
import com.example.application.user.port.out.CreateUserPort
import com.example.application.user.port.out.LoadUserPort
import org.springframework.stereotype.Service

@Service
class UserService(
    private val loadUserPort: LoadUserPort,
    private val createUserPort: CreateUserPort
) : SignUpUseCase, SignInUseCase {
    override fun signUp(command: SignUpUseCase.Command): SignUpUseCase.Result {
        val (name, email, password) = command
        loadUserPort.findByEmail(email) ?: throw Exception("Duplicate email")

        val createdUser = createUserPort.create(CreateUserPort.Command(name, email, password))

        return SignUpUseCase.Result.of(createdUser)
    }

    override fun signIn(command: SignInUseCase.Command): SignInUseCase.Result {
        val (email, password) = command
        val user = loadUserPort.findByEmail(email) ?: throw Exception("User not found")
        if (user.password != password) {
            throw Exception("Invalid password")
        }

        return SignInUseCase.Result.of(user)
    }
}