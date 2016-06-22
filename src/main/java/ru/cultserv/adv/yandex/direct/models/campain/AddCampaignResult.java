package ru.cultserv.adv.yandex.direct.models.campain;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.cultserv.adv.yandex.direct.models.util.ExceptionNotification;

import java.util.List;

/**
 * @author Sergey Zudin
 * @since 16.06.16.
 */
public class AddCampaignResult {

    @JsonProperty("Id")
    public Long campaignId;
    @JsonProperty("Warnings")
    public List<ExceptionNotification> warnings;
    @JsonProperty("Errors")
    public List<ExceptionNotification> errors;

}
