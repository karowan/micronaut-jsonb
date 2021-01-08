package com.example.item;

import com.example.item.interaction.Interaction;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Relation;

import javax.annotation.Nullable;
import java.util.Objects;
import java.util.Set;

@MappedEntity
public class Item {

    @Id
    @GeneratedValue
    Long id;

    String uid;

    @Relation(value = Relation.Kind.ONE_TO_MANY, mappedBy = "item")
    @Nullable Set<Interaction> interactions;

    public Long getId() {
        return id;
    }

    public Item setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUid() {
        return uid;
    }

    public Item setUid(String uid) {
        this.uid = uid;
        return this;
    }

    @Nullable public Set<Interaction> getInteractions() {
        return interactions;
    }

    public Item setInteractions(@Nullable Set<Interaction> interactions) {
        this.interactions = interactions;
        return this;
    }

    @Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return getId().equals(item.getId()) && getUid().equals(item.getUid());
    }

    @Override public int hashCode() {
        return Objects.hash(getId(), getUid());
    }
}
