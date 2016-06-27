package ru.cultserv.adv.yandex.direct.v5.filters;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.cultserv.adv.yandex.direct.v5.models.ads.AdGroup;
import ru.cultserv.adv.yandex.direct.v5.models.util.Page;

import java.util.Arrays;
import java.util.List;

/**
 * @author Sergey Zudin
 * @since 24.06.16.
 */
public class AdGroupRequest {

    @JsonProperty("SelectionCriteria")
    public SelectionCriteria criteria = new SelectionCriteria();
    @JsonProperty("FieldNames")
    public List<AdGroup.Field> fields = Arrays.asList(AdGroup.Field.values());
    @JsonProperty("Page")
    public Page page;

    //TODO

    public static class SelectionCriteria {
        @JsonProperty("CampaignIds")
        public List<Long> campaignIds;
        @JsonProperty("Ids")
        public List<Long> ids;
        @JsonProperty("Types")
        public List<AdGroup.Type> types;
        @JsonProperty("Statuses")
        public List<AdGroup.Status> statuses;
        @JsonProperty("AppIconStatuses")
        public List<AdGroup.Status> appIconStatuses;
    }

}
