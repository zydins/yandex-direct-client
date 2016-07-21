package ru.cultserv.adv.yandex.direct.v5.filters;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.cultserv.adv.yandex.direct.v5.models.ModerationStatus;
import ru.cultserv.adv.yandex.direct.v5.models.keywords.KeywordInfo;
import ru.cultserv.adv.yandex.direct.v5.models.util.Page;

import java.util.Arrays;
import java.util.List;

/**
 * @author Sergey Zudin
 * @since 21.07.16.
 */
public class KeywordRequest {

    @JsonProperty("SelectionCriteria")
    public SelectionCriteria selectionCriteria = new SelectionCriteria();
    @JsonProperty("FieldNames")
    public List<KeywordInfo.Field> fieldNames = Arrays.asList(KeywordInfo.Field.values());
    @JsonProperty("Page")
    public Page page;
    //TODO

    public static class SelectionCriteria {
        @JsonProperty("Ids")
        public List<Long> ids;
        @JsonProperty("AdGroupIds")
        public List<Long> adGroupIds;
        @JsonProperty("CampaignIds")
        public List<Long> campaignIds;
        @JsonProperty("States")
        public List<KeywordInfo.State> states;
        @JsonProperty("Statuses")
        public List<ModerationStatus> moderationStatuses;
    }

}
