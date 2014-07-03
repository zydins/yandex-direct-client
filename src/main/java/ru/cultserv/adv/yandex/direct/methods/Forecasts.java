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

	int create(NewForecastInfo info);

	boolean delete(int forecast_id);

	Forecast get(int forecast_id);

	List<ForecastStatusInfo> list();

}
