package ru.cultserv.adv.yandex.direct.v5.models.bids;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Sergey Zudin
 * @since 27.06.16.
 */
public class AutoBidInfo {

    @JsonProperty("CampaignId")
    public Long campaignId;
    @JsonProperty("AdGroupId")
    public Long adGroupId;
    @JsonProperty("KeywordId")
    public Long keywordId;
    @JsonProperty("MaxBid")
    public Long maxBid;
    @JsonProperty("Position")
    public Position position;
    @JsonProperty("IncreasePercent")
    public Integer increasePercent;
    @JsonProperty("CalculateBy")
    public CalculateBy calculateBy;
    public Integer contextCoverage;
    public Scope scope;

    public enum CalculateBy {
        VALUE,
        DIFF
    }

    public enum Scope {
        SEARCH,
        NETWORK
    }
}
