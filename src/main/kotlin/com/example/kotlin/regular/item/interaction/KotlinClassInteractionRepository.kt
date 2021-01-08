package com.example.kotlin.regular.item.interaction

import io.micronaut.data.annotation.Join
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.CrudRepository


@Join(value = "kotlinClassItem", type = Join.Type.FETCH)
@JdbcRepository(dialect = Dialect.POSTGRES)
interface KotlinClassInteractionRepository: CrudRepository<KotlinClassInteraction, Long> {

    fun findByKotlinClassItemUid(itemUid: String): Set<KotlinClassInteraction>
}