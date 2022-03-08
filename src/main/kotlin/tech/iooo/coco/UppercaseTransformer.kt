package tech.iooo.coco

import jakarta.inject.Singleton
import java.util.*
import javax.validation.constraints.NotBlank

@Singleton
open class UppercaseTransformer : NameTransformer {
    override fun transform(@NotBlank name: String): String {
        return name.uppercase(Locale.getDefault())
    }
}
