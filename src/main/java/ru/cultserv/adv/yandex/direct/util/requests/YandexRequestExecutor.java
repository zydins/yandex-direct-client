package ru.cultserv.adv.yandex.direct.util.requests;

import java.io.IOException;

import ru.cultserv.adv.util.AbstractApiRequestExecutor;
import ru.cultserv.adv.util.ApiResponse;
import ru.cultserv.adv.util.Json;
import ru.cultserv.adv.yandex.direct.models.YandexDirectResponse;

import com.ning.http.client.Response;

public class YandexRequestExecutor extends AbstractApiRequestExecutor {

	@Override
	protected ApiResponse process(Response response) {
		YandexDirectResponse api_response = Json.parse(body(response), YandexDirectResponse.class);
		
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
