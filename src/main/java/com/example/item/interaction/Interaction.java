package com.example.item.interaction;

import com.example.item.Item;
import io.micronaut.data.annotation.*;
import io.micronaut.data.model.DataType;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.Objects;

@MappedEntity
public class Interaction {
    @Id
    @GeneratedValue
    Long id;

    @Relation(value = Relation.Kind.MANY_TO_ONE, mappedBy = "item")
    @Nullable
    Item item;

    @TypeDef(type = DataType.JSON)
    @Nullable
    Map<String, String> properties;

    public Long getId() {
        return id;
    }

    public Interaction setId(Long id) {
        this.id = id;
        return this;
    }

    @Nullable public Item getItem() {
        return item;
    }

    public Interaction setItem(@Nullable Item item) {
        this.item = item;
        return this;
    }

    @Nullable public Map<String, String> getProperties() {
        return properties;
    }

    public Interaction setProperties(@Nullable Map<String, String> properties) {
        this.properties = properties;
        return this;
    }

    @Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Interaction that = (Interaction) o;
        return getId().equals(that.getId()) && Objects.equals(getItem(), that.getItem()) &&
                Objects.equals(getProperties(), that.getProperties());
    }

    @Override public int hashCode() {
        return Objects.hash(getId(), getItem(), getProperties());
    }
}
