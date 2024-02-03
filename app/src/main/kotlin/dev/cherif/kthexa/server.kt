package dev.cherif.kthexa

import dev.cherif.kthexa.book.booksRoutes
import dev.cherif.kthexa.config.Dependencies
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.defaultheaders.*
import io.ktor.server.resources.*
import io.ktor.server.routing.*
import kotlinx.serialization.json.Json

fun Application.configure() {
    install(DefaultHeaders)
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

fun Application.server(dependencies: Dependencies) {
    configure()
    routes(dependencies)
}

private fun Application.routes(dependencies: Dependencies): Routing =
    routing {
        booksRoutes(dependencies.bookService)
    }