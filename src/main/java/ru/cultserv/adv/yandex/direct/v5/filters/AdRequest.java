package ru.cultserv.adv.yandex.direct.v5.filters;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.cultserv.adv.yandex.direct.v5.models.ModerationStatus;
import ru.cultserv.adv.yandex.direct.v5.models.ads.AdInfo;
import ru.cultserv.adv.yandex.direct.v5.models.ads.TextAd;
import ru.cultserv.adv.yandex.direct.v5.models.util.Page;
import ru.cultserv.adv.yandex.direct.v5.models.util.StatusBoolean;

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
        @JsonProperty("CampaignIds")
        public List<Long> campaignIds;
        @JsonProperty("AdGroupsIds")
        public List<Long> adGroupsIds;
        @JsonProperty("Mobile")
        public StatusBoolean isMobile;
        @JsonProperty("VCardIds")
        public List<Long> vCardIds;
        @JsonProperty("SitelinkSetIds")
        public List<Long> sitelinkSetIds;
        @JsonProperty("AdImageHashes")
        public List<String> imageHashes;
        @JsonProperty("VCardModerationStatuses")
        public ModerationStatus vCardModeration;
        @JsonProperty("SitelinksModerationStatuses")
        public ModerationStatus sitelinksModeration;
        @JsonProperty("AdImageModerationStatuses")
        public ModerationStatus adImageModeration;
        @JsonProperty("AdExtensionIds")
        public List<Long> extensionIds;
    }


}
