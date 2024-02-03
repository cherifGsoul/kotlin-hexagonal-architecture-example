package dev.cherif.kthexa.book

interface Books {
    fun save(book: BookData)
}

class InMemoryBooks: Books {

    private val books: MutableMap<String, BookData> = mutableMapOf()

    override fun save(book: BookData) {
        this.books[book.id.toString()] = book
    }
}