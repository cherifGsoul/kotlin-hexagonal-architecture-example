package dev.cherif.kthexa

import dev.cherif.kthexa.book.*
import io.ktor.server.resources.Resources
import io.ktor.server.application.*
import io.ktor.server.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import dev.cherif.kthexa.config.Dependencies
import dev.cherif.kthexa.config.dependencies
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.plugins.contentnegotiation.*
import io.netty.handler.codec.DefaultHeaders
import kotlinx.serialization.json.Json

fun main() {
    val dependencies = dependencies()
    embeddedServer(Netty, port = 8080) {
       serve(dependencies)
    }.start(wait = true)
}

fun Application.configure() {
    install(ContentNegotiation) {
        json(
            Json {
                isLenient = true
                ignoreUnknownKeys = true
            }
        )
    }
    install(Resources)
}

fun Application.serve(dependencies: Dependencies) {
    configure()
    routes(dependencies)
}

private fun Application.routes(dependencies: Dependencies) {
    println("routes")
    routing {
        booksRoutes(dependencies.bookService)
    }
}