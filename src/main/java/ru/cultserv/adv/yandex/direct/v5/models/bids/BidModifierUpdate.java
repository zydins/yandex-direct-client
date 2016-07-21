package ru.cultserv.adv.yandex.direct.v5.models.bids;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Sergey Zudin
 * @since 21.07.16.
 */
public class BidModifierUpdate {

    @JsonProperty("Id")
    public Long id;
    @JsonProperty("BidModifier")
    public Integer bidModifier;

}
