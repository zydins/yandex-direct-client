package ru.cultserv.adv.yandex.direct.v5.models.reports;

/**
 * @author Sergey Zudin
 * @since 09.01.18.
 *
 * https://tech.yandex.ru/direct/doc/reports/fields-list-docpage/
 */
public enum ReportField {

    AdFormat,
    AdGroupId,
    AdId,
    AdNetworkType,
    Age,
    AvgClickPosition,
    AvgCpc,
    AvgImpressionPosition,
    AvgPageviews,
    BounceRate,
    CampaignId,
    CampaignType,
    CarrierType,
    Clicks,
    ClickType,
    ConversionRate,
    Conversions,
    Cost,
    CostPerConversion,
    CriteriaType,
    Ctr,
    Device,
    ExternalNetworkName,
    Gender,
    GoalsRoi,
    Impressions,
    ImpressionShare,
    LocationOfPresenceId,
    MatchedKeyword,
    MatchType,
    MobilePlatform,
    Placement,
    Query,
    Revenue,
    RlAdjustmentId,
    Slot,
    TargetingLocationId,

    AdGroupName(true, false, true),
    AudienceTargetId(false, true, false),
    Bounces(true, false, true),
    CampaignName(true, false, true),
    Criteria(true, false, false),
    CriteriaId(true, false, false),
    Criterion(true, false, false),
    CriterionId(true, false, false),
    Date(true, false, true),
    DynamicTextAdTargetId(false, true, false),
    Keyword(false, true, false),
    LocationOfPresenceName(true, false, true),
    Month(true, false, true),
    Quarter(true, false, true),
    Sessions(true, false, true),
    SmartBannerFilterId(false, true, false),
    TargetingLocationName(true, false, true),
    Week(true, false, true),
    Year(true, false, true);

    public boolean fieldNames;
    public boolean fieldFilter;
    public boolean fieldOrderBy;

    ReportField() {
        this(true, true, true);
    }

    ReportField(boolean fieldNames, boolean fieldFilter, boolean fieldOrderBy) {
        this.fieldNames = fieldNames;
        this.fieldFilter = fieldFilter;
        this.fieldOrderBy = fieldOrderBy;
    }
}
