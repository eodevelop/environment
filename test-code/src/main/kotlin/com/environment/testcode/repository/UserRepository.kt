package com.environment.testcode.repository

import com.environment.testcode.domain.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>