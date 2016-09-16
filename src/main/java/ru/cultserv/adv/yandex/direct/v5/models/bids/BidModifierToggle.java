package ru.cultserv.adv.yandex.direct.v5.models.bids;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.cultserv.adv.yandex.direct.v5.models.util.StatusBoolean;

/**
 * @author Sergey Zudin
 * @since 21.07.16.
 */
public class BidModifierToggle {

    @JsonProperty("CampaignId")
    public Long campaignId;
    @JsonProperty("AdGroupId")
    public Long adGroupId;
    @JsonProperty("Type")
    public BidModifier.Type type;
    @JsonProperty("Enabled")
    public StatusBoolean isEnabled;

}