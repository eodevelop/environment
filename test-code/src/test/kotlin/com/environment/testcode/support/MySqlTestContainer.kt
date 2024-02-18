package com.environment.testcode.support

import jakarta.annotation.PreDestroy
import org.junit.jupiter.api.TestInstance
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import org.testcontainers.containers.MySQLContainer
import org.testcontainers.utility.DockerImageName

@Component
@Order(value = Ordered.HIGHEST_PRECEDENCE)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class MySqlTestContainer {

    @PreDestroy
    fun stop() {
        MY_SQL_CONTAINER.stop()
    }

    companion object {
        @JvmStatic
        val MY_SQL_CONTAINER: MySQLContainer<*> =
            // image for linux/arm64/v8 m1 support
            DockerImageName.parse("mysql/mysql-server:8.0.26")
                .asCompatibleSubstituteFor("mysql")
                .let { compatibleImageName -> MySQLContainer<Nothing>(compatibleImageName) }
                .apply {
                    withDatabaseName(DATABASE_NAME)
                    withUsername(USERNAME)
                    withPassword(PASSWORD)
                    withUrlParam("rewriteBatchedStatements", "true")
                    withUrlParam("profileSQL", "true")
                    withUrlParam("logger", "Slf4JLogger")
                    withUrlParam("maxQuerySizeToLog", "999999")
                    withUrlParam("serverTimezone", "UTC")
                    withEnv("MYSQL_USER", USERNAME)
                    withEnv("MYSQL_PASSWORD", PASSWORD)
                    withEnv("MYSQL_ROOT_PASSWORD", PASSWORD)
                    withCommand("--max_connections=1000 --sql_mode=NO_ENGINE_SUBSTITUTION")
                    start()
                }

        private const val DATABASE_NAME = "path_test"
        const val USERNAME = "root"
        const val PASSWORD = "password"
    }
}
