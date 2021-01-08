package com.example.kotlin.item.interaction

import io.micronaut.data.annotation.Join
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.CrudRepository

@Join(value = "dataClassItem", type = Join.Type.FETCH)
@JdbcRepository(dialect = Dialect.POSTGRES)
interface DataClassInteractionRepository: CrudRepository<DataClassInteraction, Long> {

    fun findByDataClassItemUid(itemUid: String): Set<DataClassInteraction>
}