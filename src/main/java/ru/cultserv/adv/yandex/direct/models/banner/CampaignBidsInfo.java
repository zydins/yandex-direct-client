package ru.cultserv.adv.yandex.direct.models.banner;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.List;

/**
 * @author Alexandr Kolosov
 * @since 04.07.2014
 */
public class CampaignBidsInfo {

    @JsonProperty("CampaignID")
    public long campaign_id;

    @JsonProperty("BannerIDS")
    public List<Long> banner_ids;

    public static CampaignBidsInfo campaign(Long campaign_id) {
        return of(campaign_id);
    }

    public static CampaignBidsInfo of(Long campaign_id, Long ... banner_ids) {
        CampaignBidsInfo info = new CampaignBidsInfo();
        info.campaign_id = campaign_id;
        if (banner_ids.length != 0) {
            info.banner_ids = Arrays.asList(banner_ids);
        }

        return info;
    }


}
