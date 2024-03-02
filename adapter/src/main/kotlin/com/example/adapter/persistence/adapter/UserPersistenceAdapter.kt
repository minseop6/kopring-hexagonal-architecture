package com.example.adapter.persistence.adapter

import com.example.adapter.persistence.entity.UserEntity
import com.example.adapter.persistence.repository.UserRepository
import com.example.application.user.port.out.CreateUserPort
import com.example.application.user.port.out.LoadUserPort
import com.example.domain.user.User
import org.springframework.stereotype.Service

@Service
class UserPersistenceAdapter(private val userRepository: UserRepository) : CreateUserPort, LoadUserPort {
    override fun findByEmail(email: String): User? {
        val userEntity = userRepository.findByEmail(email)
        return userEntity?.let { User(it.id, it.name, it.email, it.password) }
    }

    override fun create(command: CreateUserPort.Command): User {
        val userEntity = UserEntity(name = command.name, email = command.email, password = command.password)
        val savedUserEntity = userRepository.save(userEntity)
        return User(savedUserEntity.id, savedUserEntity.name, savedUserEntity.email, savedUserEntity.password)
    }
}