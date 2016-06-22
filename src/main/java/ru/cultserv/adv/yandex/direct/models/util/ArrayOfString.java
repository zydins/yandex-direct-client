package ru.cultserv.adv.yandex.direct.models.util;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Sergey Zudin
 * @since 16.06.16.
 */
public class ArrayOfString {

    @JsonProperty("Items")
    public List<String> items;

    public ArrayOfString(List<String> items) {
        this.items = items;
    }
}
