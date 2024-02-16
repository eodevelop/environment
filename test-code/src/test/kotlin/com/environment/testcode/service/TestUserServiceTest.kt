package com.environment.testcode.service

import com.environment.testcode.domain.entity.TestUser
import com.environment.testcode.repository.TestUserRepository
import org.junit.jupiter.api.extension.ExtendWith
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class TestUserServiceTest {

    private val testUserRepository = mockk<TestUserRepository>()

    private val testUserService = mockk<TestUserService>()

    @Test
    fun `saveUser - 유저 저장 후 유저 정보를 반환한다`() {
        // given
        val testUser = TestUser(id = 1L, name = "Test User", email = "test@example.com")
        every { testUserRepository.save(testUser) } returns testUser

        // when
        val result = testUserService.saveUser(testUser)

        // then
        Assertions.assertEquals(testUser, result)
    }
}