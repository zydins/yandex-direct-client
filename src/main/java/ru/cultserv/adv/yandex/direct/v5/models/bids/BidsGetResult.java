package ru.cultserv.adv.yandex.direct.v5.models.bids;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Sergey Zudin
 * @since 22.06.16.
 */
public class BidsGetResult {

    @JsonProperty("LimitedBy")
    public Long limitedBy;
    @JsonProperty("Campaigns")
    public List<BidInfo> campaigns;

}
