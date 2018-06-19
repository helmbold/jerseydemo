package com.example.jerseydemo

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import javax.ws.rs.client.ClientBuilder


@ExtendWith(SpringExtension::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class ResourceTest {

    @Test
    fun testWithJerseyClient() {
        val client = ClientBuilder.newClient()
        val response = client.target("http://localhost:8080/demo").request().get()
        assertThat(response.status).isEqualTo(200)
    }
}