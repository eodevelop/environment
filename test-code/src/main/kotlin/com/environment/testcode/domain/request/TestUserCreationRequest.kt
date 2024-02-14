package com.environment.testcode.domain.request

import com.environment.testcode.domain.entity.TestUser

data class TestUserCreationRequest (
    val name: String,
    val email: String
) {
    fun toUser() = TestUser(
        name = name,
        email = email
    )
}