package com.example.users

import com.example.users.interactions.UserInteraction
import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import io.micronaut.data.annotation.Relation

@MappedEntity
data class User(
    @field:Id
    @field:GeneratedValue(ref = "user_id_seq")
    var id: Long,
    var uid: String,
    @Relation(value = Relation.Kind.ONE_TO_MANY, mappedBy = "user")
    var userInteractions: Set<UserInteraction>? = null
)