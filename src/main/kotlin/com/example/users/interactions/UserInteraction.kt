package com.example.users.interactions

import com.example.users.User
import io.micronaut.data.annotation.MappedEntity
import io.micronaut.data.annotation.TypeDef
import io.micronaut.data.model.DataType
import io.micronaut.data.annotation.*

@MappedEntity(value = "user_interaction")
data class UserInteraction(
    @field:Id
    @GeneratedValue(ref = "user_interaction_id_seq")
    var id: Long,
    @Relation(value = Relation.Kind.MANY_TO_ONE, mappedBy = "user")
    var user: User,
    @field:TypeDef(type = DataType.JSON)
    var properties: Map<String, String>? = null,
)