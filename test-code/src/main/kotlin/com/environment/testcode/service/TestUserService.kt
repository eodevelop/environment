package com.environment.testcode.service

import com.environment.testcode.domain.entity.TestUser
import com.environment.testcode.repository.TestUserQRepository
import com.environment.testcode.repository.TestUserRepository
import org.springframework.stereotype.Service

@Service
class TestUserService(
    private val testUserRepository: TestUserRepository,
    private val testUserQRepository: TestUserQRepository,
) {

    fun saveUser(testUser: TestUser): TestUser {
        return testUserQRepository.save(testUser)
    }
}