package tech.iooo.coco

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.post
import io.micronaut.ktor.KtorRoutingBuilder
import jakarta.inject.Singleton
import mu.KotlinLogging
import javax.validation.ConstraintViolationException

val logger = KotlinLogging.logger { }

@Singleton
class HomeRoute(private val nameTransformer: NameTransformer) : KtorRoutingBuilder({
    post("/") {
        val name = call.receive<NameRequest>().name
        logger.info { "request from ${call.request.host()}" }
        try {
            call.respondText(nameTransformer.transform(name), contentType = ContentType.Text.Plain)
        } catch (e: ConstraintViolationException) {
            call.respondText(
                e.constraintViolations.joinToString(",") { c -> "${c.propertyPath.last().name} ${c.message}" },
                contentType = ContentType.Text.Plain,
                status = HttpStatusCode.UnprocessableEntity
            )
        }
    }
})

data class NameRequest(val name: String)
