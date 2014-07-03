package ru.cultserv.adv.yandex.direct.models.campain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Alexandr Kolosov
 * @since 7/3/14
 */
public class CampaignStrategy {

	@JsonProperty("StrategyName")
	public String strategy_name;

	@JsonProperty("MaxPrice")
	public float max_price;

	@JsonProperty("AveragePrice")
	public float average_price;

	@JsonProperty("AverageCPA")
	public float average_cpa;

	@JsonProperty("WeeklySumLimit")
	public float weekly_sum_limit;

	@JsonProperty("ClicksPerWeek")
	public int click_per_week;

	@JsonProperty("GoalID")
	public int goal_id;

}
