package ru.cultserv.adv.yandex.direct.v5.models.dict;

import ru.cultserv.adv.yandex.direct.v5.models.RegionInfo;

import java.util.List;

/**
 * @author Sergey Zudin
 * @since 27.06.16.
 */
public class Dictionary {

    public List<CurrencyInfo> currencies;
    public List<MetroStation> stations;
    public List<RegionInfo> regions;
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
