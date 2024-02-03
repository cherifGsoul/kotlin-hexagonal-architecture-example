package dev.cherif.kthexa

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import dev.cherif.kthexa.config.dependencies

fun main() {
    val dependencies = dependencies()
    embeddedServer(Netty, port = 8080) {
        server(dependencies)
    }.start(wait = true)
}