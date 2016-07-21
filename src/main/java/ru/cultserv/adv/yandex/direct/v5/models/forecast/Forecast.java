package ru.cultserv.adv.yandex.direct.v5.models.forecast;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Alexandr Kolosov
 * @since 7/3/14
 */
@Deprecated
public class Forecast {

	@JsonProperty("Phrases")
	public List<BannerPhraseInfo> phrases;

	@JsonProperty("Common")
    public ForecastCommonInfo common;

}
