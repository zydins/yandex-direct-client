package ru.cultserv.adv.yandex.direct.v5.models.bids;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.cultserv.adv.yandex.direct.v5.models.Age;
import ru.cultserv.adv.yandex.direct.v5.models.Gender;
import ru.cultserv.adv.yandex.direct.v5.models.util.StatusBoolean;

import java.util.List;

/**
 * @author Sergey Zudin
 * @since 21.07.16.
 */
public class BidModifier {

    /*
    Start fields for creating
     */

    @JsonProperty("CampaignId")
    public Long campaignId;
    @JsonProperty("AdGroupId")
    public Long adGroupId;
    @JsonProperty("MobileAdjustment")
    public MobileAdjustment mobileAdjustment;
    @JsonProperty("DemographicsAdjustments")
    public List<DemographicsAdjustment> demographicsAdjustments;
    @JsonProperty("RetargetingAdjustments")
    public List<RetargetingAdjustment> retargetingAdjustments;

    /*
    End fields for creating
     */
    @JsonProperty("Id")
    public Long id;
    @JsonProperty("Level")
    public Level level;
    @JsonProperty("Type")
    public Type type;

    public enum Field {
        Id,
        CampaignId,
        AdGroupId,
        Level,
        Type
    }

    public enum Type {
        MOBILE_ADJUSTMENT,
        DEMOGRAPHICS_ADJUSTMENT,
        RETARGETING_ADJUSTMENT
    }

    public enum Level {
        CAMPAIGN,
        AD_GROUP
    }

    public static class MobileAdjustment {
        @JsonProperty("BidModifier")
        public Integer bidModifier;

        public enum Field {
            BidModifier
        }
    }

    public static class DemographicsAdjustment {
        @JsonProperty("Gender")
        public Gender gender;
        @JsonProperty("Age")
        public Age age;
        @JsonProperty("BidModifier")
        public Integer bidModifier;
        @JsonProperty("Enabled")
        public StatusBoolean isEnabled;

        public enum Field {
            Gender,
            Age,
            BidModifier,
            Enabled
        }
    }

    public static class RetargetingAdjustment {
        @JsonProperty("RetargetingConditionId")
        public Long retargetingConditionId;
        @JsonProperty("BidModifier")
        public Integer bidModifier;
        @JsonProperty("Accessible")
        public StatusBoolean isAccessible;
        @JsonProperty("Enabled")
        public StatusBoolean isEnabled;

        public enum Field {
            RetargetingConditionId,
            BidModifier,
            Accessible,
            Enabled
        }
    }

}
