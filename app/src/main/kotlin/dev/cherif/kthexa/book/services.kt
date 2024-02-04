package dev.cherif.kthexa.book

import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class CreateAuthorInput(val fname: String, val lname: String) {
    fun toAuthor() = Author(
        UUID.randomUUID(),
        FullName(NonEmptyString.fromString(this.fname),
            NonEmptyString.fromString(this.lname)
        )
    )
}// DTO (Data Transfer Object)

@Serializable
data class CreateBookWithNewAuthorInput(val title: String, val author: CreateAuthorInput) {
    fun toBook(): Book = Book(
        UUID.randomUUID(),
        NonEmptyString.fromString(this.title),
        this.author.toAuthor()
    )
} // DTO (Data Transfer Object)

@Serializable
data class CreateBookWithExistingAuthorInput(val title: String, val author: String) // DTO (Data Transfer Object)

interface BookService {
    suspend fun createWithNewAuthor(input: CreateBookWithNewAuthorInput): BookData
    fun createWithExistingAuthor(input: CreateAuthorInput)
    fun getById()
    fun update ()

    fun delete()
}
fun bookService(books: Books): BookService = SqlBookService(books)
private class SqlBookService (private val books: Books): BookService {

    override suspend fun createWithNewAuthor(input: CreateBookWithNewAuthorInput): BookData {
        val bookData = BookData.fromBook(input.toBook())
        books.save(bookData)
        return bookData
    }

    override fun createWithExistingAuthor(input: CreateAuthorInput) {
        println(input.fname)
    }

    override fun getById() {

    }

    override fun update () {

    }

    override fun delete() {

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