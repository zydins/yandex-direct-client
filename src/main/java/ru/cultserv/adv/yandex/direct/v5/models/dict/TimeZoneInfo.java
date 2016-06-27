package ru.cultserv.adv.yandex.direct.v5.models.dict;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Sergey Zudin
 * @since 27.06.16.
 */
public class TimeZoneInfo {

    @JsonProperty("TimeZone")
    public String timezone;
    @JsonProperty("TimeZoneName")
    public String name;
    @JsonProperty("UtcOffset")
    public Integer utcOffset;

}
