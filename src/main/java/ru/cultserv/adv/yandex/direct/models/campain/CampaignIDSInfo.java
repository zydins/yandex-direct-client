package ru.cultserv.adv.yandex.direct.models.campain;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.cultserv.adv.yandex.direct.models.Currency;

/**
 * @author Alexandr Kolosov
 * @since 7/3/14
 */
public class CampaignIDSInfo {

	@JsonProperty("CampaignIDS")
	public Integer[] campaign_ids;

	@JsonProperty("Currency")
	public Currency currency;

	public static CampaignIDSInfo of(Integer ... campaign_ids) {
		return of(null, campaign_ids);
	}

	public static CampaignIDSInfo of(Currency currency, Integer ... campaign_ids) {
		CampaignIDSInfo info = new CampaignIDSInfo();
		info.campaign_ids = campaign_ids;
		info.currency = currency;
		return info;
	}
}
