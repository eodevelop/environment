package com.environment.testcode.domain.request

import com.environment.testcode.domain.entity.User

data class UserCreationRequest (
    val name: String,
    val email: String
) {
    fun toUser() = User(
        name = name,
        email = email
    )
}