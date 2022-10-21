package design.pattern.kotlin.patterns.creational.singleton

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.stream.Stream

class DBConnectionTest {
    @Test
    fun itShouldCreateADBConnectionWhenCreateIsCalled() {
        val host = "test.com"
        val port = 8443
        val username = "test"
        val password = "****"
        val connection = DBConnection.create(
            host, port, username, password
        )
        Assertions.assertEquals(host, connection?.host)
        Assertions.assertEquals(port, connection?.port)
        Assertions.assertEquals(username, connection?.username)
        Assertions.assertEquals(password, connection?.password)
    }

    @Test
    fun itShouldCreateOnlyOneInstanceWhenCreateIsCalledMoreThanOnce() {
        val host = "test.com"
        val port = 8443
        val username = "test"
        val password = "****"
        val connection = DBConnection.create(
            host, port, username, password
        )
        Stream.generate { java.lang.Double.valueOf(Math.random() * 100).toInt() }
            .limit(10)
            .map { index: Int ->
                DBConnection.create(
                    host, port, username + index.toString(), password
                )
            }
            .forEach { testDBConnection: DBConnection? ->
                Assertions.assertEquals(
                    connection,
                    testDBConnection
                )
            }
    }
}