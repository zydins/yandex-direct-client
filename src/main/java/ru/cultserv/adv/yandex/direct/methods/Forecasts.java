package ru.cultserv.adv.yandex.direct.methods;

import ru.cultserv.adv.yandex.direct.filters.NewForecastInfo;
import ru.cultserv.adv.yandex.direct.models.forecast.Forecast;
import ru.cultserv.adv.yandex.direct.models.forecast.ForecastStatusInfo;

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
