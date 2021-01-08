package com.example.kotlin.regular.item.interaction

import com.example.kotlin.regular.item.KotlinClassItem
import io.micronaut.data.annotation.*
import io.micronaut.data.model.DataType

@MappedEntity("kotlin_class_interaction")
open class KotlinClassInteraction {
    @field:Id
    @GeneratedValue
    var id: Long = 0
    @Relation(value = Relation.Kind.MANY_TO_ONE, mappedBy = "item")
    var kotlinClassItem: KotlinClassItem? = null
    @field:TypeDef(type = DataType.JSON)
    var properties: Map<String, String>? = null



    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is KotlinClassInteraction) return false

        if (id != other.id) return false
        if (kotlinClassItem != other.kotlinClassItem) return false
        if (properties != other.properties) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + (kotlinClassItem?.hashCode() ?: 0)
        result = 31 * result + (properties?.hashCode() ?: 0)
        return result
    }


}