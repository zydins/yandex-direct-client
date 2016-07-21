package ru.cultserv.adv.yandex.direct.v5.models.forecast;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.cultserv.adv.yandex.direct.v5.models.Currency;

/**
 * @author Alexandr Kolosov
 * @since 7/3/14
 */
@Deprecated
public class BannerPhraseInfo {

	@JsonProperty("Phrase")
	public String phrase;

	@JsonProperty("IsRubric")
	public String is_rubric;

	@JsonProperty("Min")
	public float min;

	@JsonProperty("Max")
	public float max;

	@JsonProperty("PremiumMin")
	public float premium_min;

	@JsonProperty("PremiumMax")
	public float premium_max;

	@JsonProperty("Shows")
	public int shows;

	@JsonProperty("Clicks")
	public int clicks;

	@JsonProperty("FirstPlaceClicks")
	public int first_place_clicks;

	@JsonProperty("PremiumClicks")
	public int premium_clicks;

	@JsonProperty("CTR")
	public float ctr;

	@JsonProperty("FirstPlaceCTR")
	public float first_place_ctr;

	@JsonProperty("PremiumCTR")
	public float premium_ctr;

	@JsonProperty("Currency")
	public Currency currency;
}
