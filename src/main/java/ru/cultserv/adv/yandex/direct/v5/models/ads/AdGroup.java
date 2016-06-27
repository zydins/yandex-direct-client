package ru.cultserv.adv.yandex.direct.v5.models.ads;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.cultserv.adv.yandex.direct.v5.models.util.ArrayOf;

import java.util.List;

/**
 * @author Sergey Zudin
 * @since 24.06.16.
 */
public class AdGroup {

    @JsonProperty("Id")
    public Long id;

    /*
    Start fields for creating
     */

    @JsonProperty("Name")
    public String name;

    @JsonProperty("CampaignId")
    public Long campaignId;

    @JsonProperty("RegionIds")
    public List<Long> regionIds;

    @JsonProperty("NegativeKeywords")
    public ArrayOf<String> negativeKeywords;

    @JsonProperty("TrackingParams")
    public String trackingParams;

    //TODO

    /*
    End fields for creating
     */

    @JsonProperty("Status")
    public Status status;
    @JsonProperty("Type")
    public Type type;

    public enum Type {
        TEXT_AD_GROUP,
        MOBILE_APP_AD_GROUP,
        DYNAMIC_TEXT_AD_GROUP
    }

    public enum Status {
        DRAFT,
        MODERATION,
        PREACCEPTED,
        ACCEPTED,
        REJECTED
    }

    public enum Field {
        Id,
        CampaignId,
        Status,
        Name,
        RegionIds,
        NegativeKeywords,
        TrackingParams,
        Type
    }
}
