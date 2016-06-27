package ru.cultserv.adv.yandex.direct.v5.filters;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.cultserv.adv.yandex.direct.v5.models.bids.BidInfo;
import ru.cultserv.adv.yandex.direct.v5.models.util.Page;

import java.util.Arrays;
import java.util.List;

/**
 * @author Sergey Zudin
 * @since 27.06.16.
 */
public class BidRequest {

    @JsonProperty("SelectionCriteria")
    public SelectionCriteria criteria;
    @JsonProperty("FieldNames")
    public List<BidInfo.Field> fields = Arrays.asList(BidInfo.Field.values());
    @JsonProperty("Page")
    public Page page;

    public static class SelectionCriteria {
        @JsonProperty("CampaignIds")
        public List<Long> campaignIds;
        @JsonProperty("AdGroupIds")
        public List<Long> adGroupIds;
        @JsonProperty("KeywordIds")
        public List<Long> keywordIds;
    }

}
