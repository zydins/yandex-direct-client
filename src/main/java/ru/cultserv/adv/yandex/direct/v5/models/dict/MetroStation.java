package ru.cultserv.adv.yandex.direct.v5.models.dict;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Sergey Zudin
 * @since 27.06.16.
 */
public class MetroStation {

    @JsonProperty("MetroStationId")
    public Long id;
    @JsonProperty("MetroStationName")
    public String name;
    @JsonProperty("GeoRegionId")
    public Long regionId;

}
