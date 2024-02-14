package com.environment.testcode.controller

import com.environment.testcode.domain.entity.TestUser
import com.environment.testcode.domain.request.TestUserCreationRequest
import com.environment.testcode.service.TestUserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TestUserController(
    private val testUserService: TestUserService,
) {
    @PostMapping("/user")
    fun createUser(
        @RequestBody request: TestUserCreationRequest,
    ) : ResponseEntity<TestUser> {
        val savedUser = testUserService.saveUser(request.toUser())
        return ResponseEntity.ok(savedUser)
    }
}