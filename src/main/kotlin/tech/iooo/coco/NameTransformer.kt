    package tech.iooo.coco

import javax.validation.constraints.NotBlank

interface NameTransformer {
    fun transform(@NotBlank name: String) : String
}