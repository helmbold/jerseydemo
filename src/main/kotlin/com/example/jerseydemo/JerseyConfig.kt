package com.example.jerseydemo

import org.glassfish.jersey.server.ResourceConfig
import org.springframework.stereotype.Component

@Component
class JerseyConfig : ResourceConfig() {

    init {
        register(Resource::class.java)
    }
}