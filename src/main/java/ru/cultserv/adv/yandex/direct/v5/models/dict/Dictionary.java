package ru.cultserv.adv.yandex.direct.v5.models.dict;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Sergey Zudin
 * @since 27.06.16.
 */
public class Dictionary {

    @JsonProperty("Currency")
    public List<CurrencyInfo> currencies;
    @JsonProperty("MetroStations")
    public List<MetroStation> stations;
    @JsonProperty("GeoRegions")
    public List<RegionInfo> regions;
    @JsonProperty("TimeZones")
    public List<TimeZoneInfo> timezones;
    //TODO

    public enum Type {
        Currencies,
        MetroStations,
        GeoRegions,
        TimeZones,
        Constants,
        AdCategories,
        OperationSystemVersions,
        ProductivityAssertions,
        SupplySidePlatforms
    }

}
