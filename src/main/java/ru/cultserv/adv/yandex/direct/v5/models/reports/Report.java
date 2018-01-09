package ru.cultserv.adv.yandex.direct.v5.models.reports;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.cultserv.adv.yandex.direct.v5.models.ads.AdFormat;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Sergey Zudin
 * @since 09.01.18.
 */
public class Report {

    @JsonProperty("Name")
    public String name;
    @JsonProperty("Entries")
    public List<ReportEntry> entries;

    public static class ReportEntry {
        @JsonProperty("AdFormat")
        public AdFormat adFormat;
        @JsonProperty("AdGroupId")
        public Long adGroupId;
        @JsonProperty("AdId")
        public Long adId;
        @JsonProperty("Clicks")
        public Integer clicks;
        @JsonProperty("Impressions")
        public Integer impressions;
        @JsonProperty("Cost")
        public BigDecimal cost;

    }

}
