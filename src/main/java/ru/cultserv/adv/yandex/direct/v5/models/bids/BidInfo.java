package ru.cultserv.adv.yandex.direct.v5.models.bids;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.cultserv.adv.yandex.direct.v5.models.util.ArrayOf;

import java.util.List;

/**
 * @author Sergey Zudin
 * @since 27.06.16.
 */
public class BidInfo {

    /*
    Start fields for creating
     */

    @JsonProperty("CampaignId")
    public Long campaignId;
    @JsonProperty("AdGroupId")
    public Long adGroupId;
    @JsonProperty("KeywordId")
    public Long keywordId;
    @JsonProperty("Bid")
    public Long searchBid;
    @JsonProperty("ContextBid")
    public Long contextBid;
    @JsonProperty("StrategyPriority")
    public StrategyPriority phrasePriority;

    /*
    End fields for creating
     */

    @JsonProperty("CompetitorsBids")
    public List<Long> competitorsBids;
    @JsonProperty("SearchPrices")
    public List<SearchPrice> searchPrices;
    @JsonProperty("ContextCoverage")
    public ArrayOf<ContextCoverageInfo> contextCoverage;
    @JsonProperty("MinSearchPrice")
    public Long minSearchPrice;
    @JsonProperty("CurrentSearchPrice")
    public Long currentSearchPrice;
    @JsonProperty("AuctionBids")
    public List<AuctionBid> auctionBids;

    public enum StrategyPriority {
        LOW,
        NORMAL,
        HIGH
    }

    public enum Field {
        KeywordId,
        AdGroupId,
        CampaignId,
        Bid,
        ContextBid,
        StrategyPriority,
        CompetitorsBids,
        SearchPrices,
        ContextCoverage,
        MinSearchPrice,
        CurrentSearchPrice,
        AuctionBids
    }
}
