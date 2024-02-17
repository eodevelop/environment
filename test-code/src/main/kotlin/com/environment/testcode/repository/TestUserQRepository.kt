package com.environment.testcode.repository

import com.environment.testcode.domain.entity.TestUser
import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.persistence.EntityManager
import jakarta.transaction.Transactional
import org.springframework.stereotype.Repository

@Repository
class TestUserQRepository(
    private val entityManager: EntityManager
) {
    private val queryFactory = JPAQueryFactory(entityManager)

    @Transactional
    fun save(user: TestUser): TestUser {
        entityManager.persist(user)
        return user
    }
}