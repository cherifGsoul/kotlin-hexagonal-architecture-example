package dev.cherif.kthexa.book

import java.util.*

data class FullName(val fname: NonEmptyString, val lname: NonEmptyString)

data class NonEmptyString private constructor(val s: String) {
    companion object {
        fun fromString(s: String): NonEmptyString {
            if (s.isEmpty()) {
                throw Exception("Value can not be empty string")
            }
            return NonEmptyString(s)
        }
    }

    override fun toString(): String {
        return s
    }


}

data class Author(val id: UUID, val name: FullName)
data class Book(val id: UUID, val title: NonEmptyString, val author: Author)