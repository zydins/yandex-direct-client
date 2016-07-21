package ru.cultserv.adv.yandex.direct.v5.models.forecast;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Alexandr Kolosov
 * @since 7/3/14
 */
@Deprecated
public class ForecastCommonInfo {

	@JsonProperty("Geo")
	public String geo;

	@JsonProperty("Min")
	public float min;

	@JsonProperty("Max")
	public float max;

	@JsonProperty("PremiumMin")
	public float premium_min;

	@JsonProperty("Shows")
	public int shows;

	@JsonProperty("Clicks")
	public int clicks;

	@JsonProperty("FirstPlaceClicks")
	public int first_place_clicks;

	@JsonProperty("PremiumClicks")
	public int premium_clicks;

}
