package dev.cherif.kthexa

import dev.cherif.kthexa.config.dependencies
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    val dependencies = dependencies()
    embeddedServer(Netty, port = 8080) {
        server(dependencies)
    }.start(wait = true)
}