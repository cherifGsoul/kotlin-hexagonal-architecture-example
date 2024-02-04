package dev.cherif.kthexa.config

import dev.cherif.kthexa.book.BookService
import dev.cherif.kthexa.book.InMemoryBooks
import dev.cherif.kthexa.book.bookService

class Dependencies (
    val bookService: BookService
)

fun dependencies(): Dependencies {
    val books = InMemoryBooks()
    return Dependencies(
        bookService(books)
    )
}