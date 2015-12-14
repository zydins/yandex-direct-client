package ru.cultserv.adv.yandex.direct.models.campain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * @author Sergey Zudin
 * @since 18.11.15.
 */
public class BannersStat {

    /**
     * Идентификатор кампании.
     */
    @JsonProperty("CampaignID")
    public Integer campaign_id;

    /**
     * Начальная дата отчетного периода, YYYY-MM-DD.
     */
    @JsonProperty("StartDate")
    public Date start_date;

    /**
     * Конечная дата отчетного периода, YYYY-MM-DD.
     */
    @JsonProperty("EndDate")
    public Date end_date;

    /**
     * Массив объектов BannersStatItem. Каждый объект содержит статистику по одной фразе за один день отчетного периода.
     */
    @JsonProperty("Stat")
    public BannersStatItem[] stat;

}
