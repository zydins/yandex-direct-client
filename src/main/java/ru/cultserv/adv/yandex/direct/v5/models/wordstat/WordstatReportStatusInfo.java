package ru.cultserv.adv.yandex.direct.v5.models.wordstat;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Alexandr Kolosov
 * @since 29.07.2014
 */
public class WordstatReportStatusInfo {

    @JsonProperty("ReportID")
    public int report_id;

    @JsonProperty("StatusReport")
    public String status_report;

}
