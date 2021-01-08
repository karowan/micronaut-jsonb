package com.example.users

import io.micronaut.data.annotation.Join
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.CrudRepository

@JdbcRepository(dialect = Dialect.POSTGRES)
abstract class UserRepository: CrudRepository<User, Long> {

    @Join(value = "userInteractions", type = Join.Type.FETCH)
    abstract fun findByUid(uid: String): User?
    abstract fun getByUid(uid: String): User?
}