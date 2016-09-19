package ru.cultserv.adv.yandex.direct.v5.models.keywords;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.cultserv.adv.yandex.direct.v5.models.ModerationStatus;
import ru.cultserv.adv.yandex.direct.v5.models.StrategyPriority;

import java.util.List;

/**
 * @author Sergey Zudin
 * @since 21.07.16.
 */
public class KeywordInfo {

    @JsonProperty("Id")
    public Long id;

    /*
	Start fields for creation
	 */

    @JsonProperty("Keyword")
    public String keyword;

    @JsonProperty("AdGroupId")
    public Long adGroupId;

    @JsonProperty("Bid")
    public Long bid;

    @JsonProperty("ContextBid")
    public Long contextBid;

    @JsonProperty("StrategyPriority")
    public StrategyPriority strategyPriority;

    @JsonProperty("UserParam1")
    public String userParam1;

    @JsonProperty("UserParam2")
    public String userParam2;

    /*
    End fields for creation
    */

    @JsonProperty("CampaignId")
    public long campaignId;

    @JsonProperty("State")
    public State state;

    @JsonProperty("Status")
    public ModerationStatus status;

    @JsonProperty("Productivity")
    public Productivity productivity;

    @JsonProperty("StatisticsSearch")
    public Stats statisticsSearch;

    @JsonProperty("StatisticsNetwork")
    public Stats statisticsNetwork;

    public enum Field {
        Id,
        Keyword,
        State,
        Status,
        AdGroupId,
        CampaignId,
        Bid,
        ContextBid,
        StrategyPriority,
        UserParam1,
        UserParam2,
        Productivity,
        StatisticsSearch,
        StatisticsNetwork
    }

    public enum State {
        OFF,
        ON,
        SUSPENDED
    }

    public static class Productivity {
        @JsonProperty("Value")
        public Double value;

        @JsonProperty("References")
        public List<Integer> references;
    }

    public static class Stats {
        @JsonProperty("Clicks")
        public Long clicks;

        @JsonProperty("Impressions")
        public Long impressions;
    }

}
