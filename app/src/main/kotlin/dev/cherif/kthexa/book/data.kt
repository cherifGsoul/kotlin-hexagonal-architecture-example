package dev.cherif.kthexa.book

import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class BookData(val id: String, val title: String,val author: AuthorData) {
    companion object {
        fun fromBook(book: Book): BookData {
            return BookData(book.id.toString(), book.title.toString(), AuthorData.fromAuthor(book.author))
        }
    }

    fun toBook(): Book = Book(UUID.fromString(this.id), NonEmptyString.fromString(this.title), this.author.toAuthor())
}

@Serializable
data class AuthorData(val id: String, val fname: String, val lname: String) {
    companion object {
        fun fromAuthor(author: Author): AuthorData {
            return AuthorData(author.id.toString(), author.name.fname.toString(), author.name.lname.toString())
        }
    }

    fun toAuthor(): Author = Author(
        UUID.fromString(this.id),
        FullName(
            NonEmptyString.fromString(this.fname),
            NonEmptyString.fromString(this.lname))
    )
}