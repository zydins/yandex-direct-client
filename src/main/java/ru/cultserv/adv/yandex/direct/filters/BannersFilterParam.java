package ru.cultserv.adv.yandex.direct.filters;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BannersFilterParam {

	/**
	 * Массив идентификаторов кампаний (не более 10 идентификаторов).
	 * Метод возвращает параметры объявлений, принадлежащих указанным кампаниям.
	 */
	@JsonProperty("CampaignIDS")
	public List<Long> campaign_ids;

}
