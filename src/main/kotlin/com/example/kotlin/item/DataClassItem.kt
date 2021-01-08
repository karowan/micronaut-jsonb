package com.example.kotlin.item

import com.example.kotlin.item.interaction.DataClassInteraction
import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import io.micronaut.data.annotation.Relation

@MappedEntity("data_class_item")
data class DataClassItem(
    @field:Id
    @GeneratedValue
    var id: Long = 0,
    var uid: String = ""
) {
    @Relation(value = Relation.Kind.ONE_TO_MANY, mappedBy = "data_class_item")
    var interactions: Set<DataClassInteraction>? = null
}