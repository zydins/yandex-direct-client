package ru.cultserv.adv.yandex.direct.v5.models.util;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Sergey Zudin
 * @since 22.06.16.
 */
public class Page {

    @JsonProperty("Limit")
    public Long limit;
    @JsonProperty("Offset")
    public Long offset;

    public Page() {
    }

    public Page(Long limit) {
        this.limit = limit;
    }

    public Page(Long limit, Long offset) {
        this.limit = limit;
        this.offset = offset;
    }
}
