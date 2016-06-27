package ru.cultserv.adv.yandex.direct.v5.models.util;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Sergey Zudin
 * @since 16.06.16.
 */
public class ArrayOf<T> {

    @JsonProperty("Items")
    public List<T> items;

    public ArrayOf() {
    }

    public ArrayOf(List<T> items) {
        this.items = items;
    }
}
