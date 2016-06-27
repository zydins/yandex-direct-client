package ru.cultserv.adv.yandex.direct.v5.methods;

import ru.cultserv.adv.yandex.direct.v5.filters.NewForecastInfo;
import ru.cultserv.adv.yandex.direct.v5.models.forecast.Forecast;
import ru.cultserv.adv.yandex.direct.v5.models.forecast.ForecastStatusInfo;

import java.util.List;

/**
 * @author Alexandr Kolosov
 * @since 7/3/14
 */
public interface Forecasts {

	@DirectMethod(MethodName.CreateNewForecast)
	int create(NewForecastInfo info);

	@DirectMethod(MethodName.DeleteForecastReport)
	boolean delete(int forecast_id);

	@DirectMethod(MethodName.GetForecast)
	Forecast get(int forecast_id);

	@DirectMethod(MethodName.GetForecastList)
	List<ForecastStatusInfo> list();

}
