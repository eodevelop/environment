package com.environment.testcode.service

import com.environment.testcode.domain.entity.User
import com.environment.testcode.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun saveUser(user: User): User {
        return userRepository.save(user)
    }
}