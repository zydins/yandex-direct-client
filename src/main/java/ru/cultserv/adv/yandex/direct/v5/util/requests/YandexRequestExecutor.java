package ru.cultserv.adv.yandex.direct.v5.util.requests;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;
import ru.cultserv.adv.yandex.direct.v5.models.YandexDirectResponse;
import ru.cultserv.adv.yandex.direct.v5.util.AbstractApiRequestExecutor;
import ru.cultserv.adv.yandex.direct.v5.util.ApiResponse;
import ru.cultserv.adv.yandex.direct.v5.util.Json;

import java.io.IOException;
import java.util.List;

public class YandexRequestExecutor extends AbstractApiRequestExecutor {

    public YandexRequestExecutor(AsyncHttpClient client) {
        super(client);
    }

    @Override
	protected ApiResponse process(Response response) {
		String body = body(response);
		YandexDirectResponse api_response;
		if (body.contains("error") && !body.contains("errors-text")) { //FIXME
			api_response = Json.parse(body, YandexDirectResponse.class, true);
		} else {
			api_response = Json.parse(body, YandexDirectResponse.class, false);
		}

		List<String> units = response.getHeaders().get("Units");
		if (units != null && units.size() == 1) {
			String[] strings = units.get(0).split("/");
			if (strings.length == 3) {
				String string = strings[1];
				try {
					int points = Integer.parseInt(string);
					api_response.setApiPoints(points);
				} catch (Exception ignored) {

				}
			}
		}

		if(api_response.hasError())
			throw api_response.error();
		
		return api_response;
	}
	
	private String body(Response response) {
		try {
			return response.getResponseBody();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
