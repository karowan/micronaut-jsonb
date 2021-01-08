package com.example.item.interaction;


import io.micronaut.data.annotation.Join;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import java.util.Set;

@Join(value = "item", type = Join.Type.FETCH)
@JdbcRepository(dialect = Dialect.POSTGRES)
public interface InteractionRepository extends CrudRepository<Interaction, Long> {

    Set<Interaction> findByItemUid(String itemUid);
}
