package dev.cherif.kthexa.config

import dev.cherif.kthexa.book.BookService
import dev.cherif.kthexa.book.InMemoryBooks

class Dependencies (
    val bookService: BookService
)

fun dependencies(): Dependencies {
    val books = InMemoryBooks()
    return Dependencies(
        BookService(books)
    )
}