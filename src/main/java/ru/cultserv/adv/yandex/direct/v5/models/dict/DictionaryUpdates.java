package ru.cultserv.adv.yandex.direct.v5.models.dict;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.LocalDate;
import ru.cultserv.adv.yandex.direct.v5.models.util.StatusBoolean;

/**
 * @author Sergey Zudin
 * @since 21.07.16.
 */
public class DictionaryUpdates {

    @JsonProperty("TimeZonesChanged")
    public StatusBoolean timeZonesChanged;
    @JsonProperty("RegionsChanged")
    public StatusBoolean regionsChanged;
    @JsonProperty("Timestamp")
    public LocalDate timestamp;

}
