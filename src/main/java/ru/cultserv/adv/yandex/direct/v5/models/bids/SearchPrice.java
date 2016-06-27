package ru.cultserv.adv.yandex.direct.v5.models.bids;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Sergey Zudin
 * @since 27.06.16.
 */
public class SearchPrice {

    @JsonProperty("Position")
    public Position position;
    @JsonProperty("Price")
    public Long price;

}
