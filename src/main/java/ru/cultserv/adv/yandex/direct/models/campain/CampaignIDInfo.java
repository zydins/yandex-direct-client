package ru.cultserv.adv.yandex.direct.models.campain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Alexandr Kolosov
 * @since 7/3/14
 */
public class CampaignIDInfo {

	@JsonProperty("CampaignID")
	public Long campaign_id;

	public static CampaignIDInfo of(Long campaign_id) {
		CampaignIDInfo info = new CampaignIDInfo();
		info.campaign_id = campaign_id;
		return info;
	}
}
