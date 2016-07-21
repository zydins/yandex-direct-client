package ru.cultserv.adv.yandex.direct.v5.filters;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.cultserv.adv.yandex.direct.v5.models.bids.BidModifier;
import ru.cultserv.adv.yandex.direct.v5.models.keywords.KeywordInfo;
import ru.cultserv.adv.yandex.direct.v5.models.util.Page;

import java.util.Arrays;
import java.util.List;

/**
 * @author Sergey Zudin
 * @since 21.07.16.
 */
public class BidModifiersRequest {

    @JsonProperty("SelectionCriteria")
    public SelectionCriteria selectionCriteria = new SelectionCriteria();
    @JsonProperty("FieldNames")
    public List<KeywordInfo.Field> fieldNames = Arrays.asList(KeywordInfo.Field.values());
    @JsonProperty("MobileAdjustmentFieldNames")
    public List<BidModifier.MobileAdjustment.Field> mobileAdjustmentFieldNames = Arrays.asList(BidModifier.MobileAdjustment.Field.values());
    @JsonProperty("DemographicsAdjustmentFieldNames")
    public List<BidModifier.DemographicsAdjustment.Field> demographicsAdjustmentFieldNames = Arrays.asList(BidModifier.DemographicsAdjustment.Field.values());
    @JsonProperty("RetargetingAdjustmentFieldNames")
    public List<BidModifier.RetargetingAdjustment.Field> retargetingAdjustmentFieldNames = Arrays.asList(BidModifier.RetargetingAdjustment.Field.values());
    @JsonProperty("Page")
    public Page page;
    //TODO

    public static class SelectionCriteria {
        @JsonProperty("Ids")
        public List<Long> ids;
        @JsonProperty("CampaignIds")
        public List<Long> campaignIds;
        @JsonProperty("AdGroupIds")
        public List<Long> adGroupIds;
        @JsonProperty("Types")
        public List<BidModifier.Type> types;
        @JsonProperty("Levels")
        public List<BidModifier.Level> levels;
    }

}
