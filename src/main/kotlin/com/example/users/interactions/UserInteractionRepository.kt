package com.example.users.interactions

import io.micronaut.data.annotation.Join
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.CrudRepository


@JdbcRepository(dialect = Dialect.POSTGRES)
@Join(value = "user", type = Join.Type.FETCH)
abstract class UserInteractionRepository: CrudRepository<UserInteraction, Long> {

    abstract fun findByUserUid(userUid: String): Set<UserInteraction>

}