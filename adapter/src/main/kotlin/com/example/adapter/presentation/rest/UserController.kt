package com.example.adapter.presentation.rest

import com.example.adapter.presentation.rest.dto.user.SignInDto
import com.example.adapter.presentation.rest.dto.user.SignUpDto
import com.example.adapter.presentation.rest.dto.user.UserDto
import com.example.application.user.port.`in`.GetUserUseCase
import com.example.application.user.port.`in`.SignInUseCase
import com.example.application.user.port.`in`.SignUpUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(
    private val getUserUseCase: GetUserUseCase,
    private val signUpUseCase: SignUpUseCase,
    private val signInUseCase: SignInUseCase
) {
    @GetMapping("/{id}")
    fun get(@PathVariable("id") userId: Long): UserDto {
        val result = getUserUseCase.get(userId)
        return UserDto(result.id, result.name, result.email)
    }

    @PostMapping("/sign-up")
    fun signUp(@RequestBody input: SignUpDto): UserDto {
        val result = signUpUseCase.signUp(SignUpUseCase.Command(input.name, input.email, input.password))
        return UserDto(result.id, result.name, result.email)
    }

    @PostMapping("/sign-in")
    fun signIn(@RequestBody input: SignInDto): UserDto {
        val result = signInUseCase.signIn(SignInUseCase.Command(input.email, input.password))
        return UserDto(result.id, result.name, result.email)
    }
}