package ru.cultserv.adv.yandex.direct.filters;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.LocalDate;
import ru.cultserv.adv.yandex.direct.models.ModerationStatus;
import ru.cultserv.adv.yandex.direct.models.ads.AdExtension;
import ru.cultserv.adv.yandex.direct.models.util.Page;

import java.util.Arrays;
import java.util.List;

/**
 * @author Sergey Zudin
 * @since 24.06.16.
 */
public class AdExtensionRequest {

    @JsonProperty("SelectionCriteria")
    public SelectionCriteria selectionCriteria = new SelectionCriteria();
    @JsonProperty("FieldNames")
    public List<AdExtension.Field> fields = Arrays.asList(AdExtension.Field.values());
    @JsonProperty("TextAdFieldNames")
    public List<AdExtension.Callout.Field> textAdFields = Arrays.asList(AdExtension.Callout.Field.values());
    @JsonProperty("Page")
    public Page page;
    //TODO

    public static class SelectionCriteria {
        @JsonProperty("Ids")
        public List<Long> ids;
        @JsonProperty("States")
        public List<AdExtension.State> states;
        @JsonProperty("Statuses")
        public List<ModerationStatus> moderationStatuses;
        @JsonProperty("Types")
        public List<AdExtension.Type> types;
        @JsonProperty("ModifiedSince")
        public LocalDate modifiedSince;
    }

}
