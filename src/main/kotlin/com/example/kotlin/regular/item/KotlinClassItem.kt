package com.example.kotlin.regular.item

import com.example.kotlin.regular.item.interaction.KotlinClassInteraction
import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import io.micronaut.data.annotation.Relation

@MappedEntity("kotlin_class_item")
open class KotlinClassItem {

    @field:Id
    @GeneratedValue
    var id: Long = 0
    var uid: String = ""

    @Relation(value = Relation.Kind.ONE_TO_MANY, mappedBy = "item")
    var interactions: Set<KotlinClassInteraction>? = null
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is KotlinClassItem) return false

        if (id != other.id) return false
        if (uid != other.uid) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + uid.hashCode()
        return result
    }


}