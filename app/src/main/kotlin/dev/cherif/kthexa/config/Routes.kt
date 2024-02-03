package dev.cherif.kthexa.config

import io.ktor.resources.*
import kotlinx.serialization.Serializable

object Routes {
    @Serializable
    @Resource("/books")
    class Book
}