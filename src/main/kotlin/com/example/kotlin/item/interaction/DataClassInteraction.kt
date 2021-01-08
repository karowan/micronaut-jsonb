package com.example.kotlin.item.interaction

import com.example.kotlin.item.DataClassItem
import io.micronaut.data.annotation.*
import io.micronaut.data.model.DataType

@MappedEntity("data_class_interaction")
data class DataClassInteraction(
    @field:Id
    @GeneratedValue
    var id: Long = 0,
    @Relation(value = Relation.Kind.MANY_TO_ONE, mappedBy = "data_class_item")
    var dataClassItem: DataClassItem? = null,
    @field:TypeDef(type = DataType.JSON)
    var properties: Map<String, String>? = null,
)