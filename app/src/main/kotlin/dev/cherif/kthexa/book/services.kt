package dev.cherif.kthexa.book

import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class CreateAuthorInput(val fname: String, val lname: String) // DTO (Data Transfer Object)

@Serializable
data class CreateBookWithNewAuthorInput(val title: String, val author: CreateAuthorInput) // DTO (Data Transfer Object)

@Serializable
data class CreateBookWithExistingAuthorInput(val title: String, val author: String) // DTO (Data Transfer Object)

class BookService (private val books: Books) {

    fun createWithNewAuthor(input: CreateBookWithNewAuthorInput): BookData {
        val author = Author(
            UUID.randomUUID(),
            FullName(NonEmptyString.fromString(input.author.fname),
                NonEmptyString.fromString(input.author.lname)
            )
        )
        val book = Book(
            UUID.randomUUID(),
            NonEmptyString.fromString(input.title),
            author
        )
        val bookData = BookData.fromBook(book)
        books.save(bookData)
        return bookData
    }

    fun createWithExistingAuthor(input: CreateAuthorInput) {
        println(input.fname)
    }

    fun getById() {

    }

    fun update () {

    }

    fun delete() {

    }
}


class AuthorService {
    fun create() {

    }

    fun getById() {

    }

    fun update () {

    }

    fun delete() {

    }
}