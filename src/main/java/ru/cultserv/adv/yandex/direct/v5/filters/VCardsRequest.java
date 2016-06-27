package ru.cultserv.adv.yandex.direct.v5.filters;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.cultserv.adv.yandex.direct.v5.models.util.Page;
import ru.cultserv.adv.yandex.direct.v5.models.vcards.VCard;

import java.util.Arrays;
import java.util.List;

/**
 * @author Sergey Zudin
 * @since 27.06.16.
 */
public class VCardsRequest {

    @JsonProperty("SelectionCriteria")
    public SelectionCriteria criteria;
    @JsonProperty("FieldNames")
    public List<VCard.Field> fields = Arrays.asList(VCard.Field.values());
    @JsonProperty("Page")
    public Page page;

    public static class SelectionCriteria {
        @JsonProperty("Ids")
        public List<Long> ids;
    }

}
