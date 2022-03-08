package tech.iooo.coco

import com.fasterxml.jackson.databind.SerializationFeature
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.jackson.*
import io.micronaut.ktor.KtorApplicationBuilder
import jakarta.inject.Singleton

@Singleton
class JacksonFeature : KtorApplicationBuilder({
    install(ContentNegotiation) {
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
        }
    }
})
