package ru.cultserv.adv.yandex.direct.v5.util.requests;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;
import ru.cultserv.adv.yandex.direct.v5.models.Unit;
import ru.cultserv.adv.yandex.direct.v5.models.YandexDirectResponse;
import ru.cultserv.adv.yandex.direct.v5.models.util.Format;
import ru.cultserv.adv.yandex.direct.v5.util.AbstractApiRequestExecutor;
import ru.cultserv.adv.yandex.direct.v5.util.ApiResponse;
import ru.cultserv.adv.yandex.direct.v5.util.Json;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class YandexRequestExecutor extends AbstractApiRequestExecutor {

    public YandexRequestExecutor(AsyncHttpClient client) {
        super(client);
    }

    @Override
	protected ApiResponse process(Response response, Format format) {
		String body = body(response);
		YandexDirectResponse api_response;
		if (body.contains("error") && !body.contains("errors-text")) { //FIXME
			api_response = Json.parse(body, YandexDirectResponse.class, true);
		} else {
			if (format != Format.JSON) {
				body = Json.convertFrom(body, format);
			}
			api_response = Json.parse(body, YandexDirectResponse.class, false);
		}
		extractUnits(response).ifPresent(api_response::setApiPoints);

		api_response.setHeaders(response.getHeaders());

		if (api_response.hasError())
			throw api_response.error();

		return api_response;
	}

	/**
	 * Method tries to parse Units HTTP header which contains:
	 * current request cost, current balance, daily limit of api points
	 * Format of Units header: Units: 10/20828/64000
	 * If header contains not digits method returns -1 for simultaneous field
	 *
	 * @param response response
	 * @return Unit or empty()
	 */
	private Optional<Unit> extractUnits(final Response response) {
		List<String> units = response.getHeaders().get("Units");
		if (units != null && units.size() == 1) {
			String[] strings = units.get(0).split("/");
			if (strings.length == 3) {
				return Optional.of(new Unit(response.getHeader("Units-Used-Login"),
						parseInt(strings[0], -1), parseInt(strings[1], -1), parseInt(strings[2], -1)));
			}
		}
		return Optional.empty();
	}

	private int parseInt(final String s, final int defaultValue) {
		try {
			return Integer.parseInt(s);
		} catch (Exception ignored) {
			// empty
		}
		return defaultValue;
	}
	
	private String body(Response response) {
		try {
			return response.getResponseBody();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
