package com.example.jerseydemo

import org.springframework.stereotype.Component
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.core.Response

@Component
@Path("/")
class Resource {

    @GET
    @Path("demo")
    fun test() = Response.ok("Hi!").encoding("UTF-8").build()
}