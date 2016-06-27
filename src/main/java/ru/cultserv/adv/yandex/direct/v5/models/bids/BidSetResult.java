package ru.cultserv.adv.yandex.direct.v5.models.bids;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.cultserv.adv.yandex.direct.v5.models.util.ExceptionNotification;

import java.util.List;

/**
 * @author Sergey Zudin
 * @since 27.06.16.
 */
public class BidSetResult {

    @JsonProperty("CampaignId")
    public Long campaignId;
    @JsonProperty("AdGroupId")
    public Long adGroupId;
    @JsonProperty("KeywordId")
    public Long keywordId;
    @JsonProperty("Warnings")
    public List<ExceptionNotification> warnings;
    @JsonProperty("Errors")
    public List<ExceptionNotification> errors;

}
