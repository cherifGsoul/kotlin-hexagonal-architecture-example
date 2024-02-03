package dev.cherif.kthexa.book

import dev.cherif.kthexa.config.Routes
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.resources.*
import io.ktor.server.response.*
import io.ktor.server.routing.Routing


fun Routing.booksRoutes(service: BookService) {
    get<Routes.Book>{
        println("GET BOOK")
        call.respondText("GET BOOK")
    }
    post<Routes.Book>{
        try {
            val newBook = call.receive<CreateBookWithNewAuthorInput>()
            val book = service.createWithNewAuthor(newBook)
            call.respond(book)
        } catch (e: ContentTransformationException) {
            println(" ================ ERROR ================" + e.message)
            call.respond(HttpStatusCode.BadRequest, "Invalid request body")
        }
    }
}