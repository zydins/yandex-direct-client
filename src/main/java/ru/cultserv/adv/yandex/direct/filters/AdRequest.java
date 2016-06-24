package ru.cultserv.adv.yandex.direct.filters;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.cultserv.adv.yandex.direct.models.ModerationStatus;
import ru.cultserv.adv.yandex.direct.models.ads.AdInfo;
import ru.cultserv.adv.yandex.direct.models.ads.TextAd;
import ru.cultserv.adv.yandex.direct.models.util.Page;
import ru.cultserv.adv.yandex.direct.models.util.StatusBoolean;

import java.util.Arrays;
import java.util.List;

/**
 * @author Sergey Zudin
 * @since 24.06.16.
 */
public class AdRequest {

    @JsonProperty("SelectionCriteria")
    public SelectionCriteria selectionCriteria = new SelectionCriteria();
    @JsonProperty("FieldNames")
    public List<AdInfo.Field> fields = Arrays.asList(AdInfo.Field.values());
    @JsonProperty("TextAdFieldNames")
    public List<TextAd.Field> textAdFields = Arrays.asList(TextAd.Field.values());
    @JsonProperty("Page")
    public Page page;
    //TODO

    public static class SelectionCriteria {
        @JsonProperty("Ids")
        public List<Long> ids;
        @JsonProperty("States")
        public List<AdInfo.State> states;
        @JsonProperty("Statuses")
        public List<ModerationStatus> moderationStatuses;
        @JsonProperty("Types")
        public List<AdInfo.Type> types;
        @JsonProperty("Types")
        public List<Long> campaignIds;
        @JsonProperty("Types")
        public List<Long> adGroupsIds;
        @JsonProperty("Types")
        public StatusBoolean isMobile;
        @JsonProperty("Types")
        public List<Long> vCardIds;
        @JsonProperty("Types")
        public List<Long> sitelinkSetIds;
        @JsonProperty("Types")
        public List<String> imageHashes;
        @JsonProperty("Types")
        public ModerationStatus vCardModeration;
        @JsonProperty("Types")
        public ModerationStatus sitelinksModeration;
        @JsonProperty("Types")
        public ModerationStatus adImageModeration;
        @JsonProperty("Types")
        public List<Long> extensionIds;
    }


}
