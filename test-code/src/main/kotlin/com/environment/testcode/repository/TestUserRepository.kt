package com.environment.testcode.repository

import com.environment.testcode.domain.entity.TestUser
import org.springframework.data.jpa.repository.JpaRepository

interface TestUserRepository : JpaRepository<TestUser, Long>