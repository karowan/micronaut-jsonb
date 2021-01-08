package com.example.kotlin.regular.item

import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.CrudRepository


@JdbcRepository(dialect = Dialect.POSTGRES)
interface KotlinClassItemRepository: CrudRepository<KotlinClassItem, Long> {
}