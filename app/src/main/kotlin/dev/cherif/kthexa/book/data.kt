package dev.cherif.kthexa.book

import kotlinx.serialization.Serializable

@Serializable
data class BookData(val id: String, val title: String,val author: AuthorData) {
    companion object {
        fun fromBook(book: Book): BookData {
            return BookData(book.id.toString(), book.title.toString(), AuthorData.fromAuthor(book.author))
        }
    }
}

@Serializable
data class AuthorData(val id: String, val fname: String, val lname: String) {
    companion object {
        fun fromAuthor(author: Author): AuthorData {
            return AuthorData(author.id.toString(), author.name.fname.toString(), author.name.lname.toString())
        }
    }
}