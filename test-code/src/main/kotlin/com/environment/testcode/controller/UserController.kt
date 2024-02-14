package com.environment.testcode.controller

import com.environment.testcode.domain.entity.User
import com.environment.testcode.domain.request.UserCreationRequest
import com.environment.testcode.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    private val userService: UserService,
) {
    @PostMapping("/user")
    fun createUser(
        @RequestBody request: UserCreationRequest,
    ) : ResponseEntity<User> {
        val savedUser = userService.saveUser(request.toUser())
        return ResponseEntity.ok(savedUser)
    }
}