package ru.cultserv.adv.yandex.direct.v5.models.forecast;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Alexandr Kolosov
 * @since 7/3/14
 */
@Deprecated
public class ForecastStatusInfo {

	@JsonProperty("ForecastID")
	public int forecast_id;

	@JsonProperty("StatusForecast")
	public String status_forecast;

}
