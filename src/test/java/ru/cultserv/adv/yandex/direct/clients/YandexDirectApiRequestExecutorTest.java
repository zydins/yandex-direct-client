package ru.cultserv.adv.yandex.direct.clients;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import ru.cultserv.adv.util.ApiRequest;
import ru.cultserv.adv.util.ApiResponse;
import ru.cultserv.adv.yandex.direct.AuthToken;
import ru.cultserv.adv.yandex.direct.util.exceptions.ApiException;
import ru.cultserv.adv.yandex.direct.util.requests.YandexDirectRequest;
import ru.cultserv.adv.yandex.direct.util.requests.YandexRequestExecutor;

public class YandexDirectApiRequestExecutorTest {

	@Test
	public void shouldExecuteYandexRequest() {
		ApiRequest request =
			new YandexDirectRequest.Builder(new AuthToken("f3e8a7c18f284908aa226b64213c4002"))
				.forMethod("PingAPI")
				.build();
		
		ApiResponse response = new YandexRequestExecutor().execute(request);
		int result = response.as(int.class);
		
		assertEquals(1, result);
	}
	
	@Test
	public void shouldExuteRequestWithException() {
		ApiRequest request =
			new YandexDirectRequest.Builder(new AuthToken(""))
				.forMethod("PingAPI")
				.build();
		
		try {
			new YandexRequestExecutor().execute(request);
		} catch(ApiException e) {
			assertNotNull(e);
			assertEquals(53, e.errorCode());
		}
		
	}

}
