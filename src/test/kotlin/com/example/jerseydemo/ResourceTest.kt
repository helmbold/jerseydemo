package com.example.jerseydemo

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.reactive.server.WebTestClient
import javax.ws.rs.client.ClientBuilder


@ExtendWith(SpringExtension::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class ResourceTest {

    @Autowired
    lateinit var client: WebTestClient

    @Test
    fun getTest() {
        client.get().uri("demo").exchange().expectStatus().isOk
    }

    @Test
    fun testWithJerseyClient() {
        val client = ClientBuilder.newClient()
        val response = client.target("http://localhost:8080/demo").request().get()
        assertThat(response.status).isEqualTo(200)
    }
}