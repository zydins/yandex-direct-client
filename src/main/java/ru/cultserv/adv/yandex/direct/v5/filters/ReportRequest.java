package ru.cultserv.adv.yandex.direct.v5.filters;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.cultserv.adv.yandex.direct.v5.models.reports.ReportField;
import ru.cultserv.adv.yandex.direct.v5.models.util.Format;
import ru.cultserv.adv.yandex.direct.v5.models.util.Operator;
import ru.cultserv.adv.yandex.direct.v5.models.util.Page;
import ru.cultserv.adv.yandex.direct.v5.models.util.StatusBoolean;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Sergey Zudin
 * @since 09.01.18.
 */
public class ReportRequest {

    @JsonProperty("SelectionCriteria")
    public SelectionCriteria criteria = new SelectionCriteria();
    @JsonProperty("FieldNames")
    public List<ReportField> fields = Arrays.asList(ReportField.values())
                                        .stream().filter(f -> f.fieldNames).collect(Collectors.toList());
    @JsonProperty("ReportName")
    public String name;
    @JsonProperty("ReportType")
    public Type type = Type.AD_PERFORMANCE_REPORT;
    @JsonProperty("DateRangeType")
    public DataRangeType dataRangeType = DataRangeType.CUSTOM_DATE;
    @JsonProperty("Format")
    public Format format = Format.TSV;
    @JsonProperty("IncludeVAT")
    public StatusBoolean includeVAT = StatusBoolean.YES;
    @JsonProperty("IncludeDiscount")
    public StatusBoolean includeDiscount = StatusBoolean.YES;
    @JsonProperty("Page")
    public Page page;
    @JsonProperty("OrderBy")
    public List<ReportField> orderBy;

    public ReportRequest() {
    }

    public ReportRequest(SelectionCriteria criteria, String name) {
        this.criteria = criteria;
        this.name = name;
    }

    public enum Type {
        /** https://tech.yandex.ru/direct/doc/reports/type-docpage/ */

        ACCOUNT_PERFORMANCE_REPORT,
        CAMPAIGN_PERFORMANCE_REPORT,
        ADGROUP_PERFORMANCE_REPORT,
        AD_PERFORMANCE_REPORT,
        CRITERIA_PERFORMANCE_REPORT,
        CUSTOM_REPORT,
        SEARCH_QUERY_PERFORMANCE_REPORT
    }

    public enum DataRangeType {
        TODAY,
        YESTERDAY,
        LAST_3_DAYS,
        LAST_5_DAYS,
        LAST_7_DAYS,
        LAST_14_DAYS,
        LAST_30_DAYS,
        LAST_90_DAYS,
        LAST_365_DAYS,
        THIS_WEEK_MON_TODAY,
        THIS_WEEK_SUN_TODAY,
        LAST_WEEK,
        LAST_BUSINESS_WEEK,
        LAST_WEEK_SUN_SAT,
        THIS_MONTH,
        LAST_MONTH,
        ALL_TIME,
        CUSTOM_DATE,
        AUTO
    }

    public static class SelectionCriteria {
        @JsonProperty("DateFrom")
        public LocalDate from;
        @JsonProperty("DateTo")
        public LocalDate to;
        @JsonProperty("Filter")
        public List<FilterItem> filters;

        public SelectionCriteria() {
        }

        public SelectionCriteria(List<FilterItem> filters) {
            this.filters = filters;
        }

        public SelectionCriteria(LocalDate from, LocalDate to, List<FilterItem> filters) {
            this.from = from;
            this.to = to;
            this.filters = filters;
        }

        public static class FilterItem {
            @JsonProperty("Field")
            public final ReportField field;
            @JsonProperty("Operator")
            public final Operator operator;
            @JsonProperty("Values")
            public final List<String> values;

            public FilterItem(ReportField field, Operator operator, String value) {
                this(field, operator, Collections.singletonList(value));
            }

            public FilterItem(ReportField field, Operator operator, List<String> values) {
                if (!field.fieldFilter) {
                    throw new IllegalArgumentException("Field is not supported");
                }
                if (values.size() > 10000) {
                    throw new IllegalArgumentException("Size of list is greater than 10000");
                }
                if (values.isEmpty()) {
                    throw new IllegalArgumentException("List of values is empty");
                }
                this.field = field;
                this.operator = operator;
                this.values = values;
            }
        }
    }

}
