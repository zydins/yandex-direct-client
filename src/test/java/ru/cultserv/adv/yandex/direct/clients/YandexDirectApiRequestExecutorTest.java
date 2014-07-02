package ru.cultserv.adv.yandex.direct.clients;

import com.google.common.base.Optional;
import org.junit.Test;
import ru.cultserv.adv.util.ApiRequest;
import ru.cultserv.adv.util.ApiRequestExecutor;
import ru.cultserv.adv.util.ApiResponse;
import ru.cultserv.adv.yandex.direct.AuthToken;
import ru.cultserv.adv.yandex.direct.methods.MethodName;
import ru.cultserv.adv.yandex.direct.util.AuthTokens;
import ru.cultserv.adv.yandex.direct.util.exceptions.ApiException;
import ru.cultserv.adv.yandex.direct.util.requests.YandexDirectRequest;
import ru.cultserv.adv.yandex.direct.util.requests.YandexRequestExecutor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class YandexDirectApiRequestExecutorTest {
	
	private ApiRequestExecutor executor = new YandexRequestExecutor();

	@Test
	public void shouldExecuteYandexRequest() {
		ApiRequest request =
			new YandexDirectRequest.Builder(AuthTokens.fake())
				.forMethod(MethodName.PingAPI.name())
				.build();

		Optional<ApiResponse> response = executor.execute(request);
		int result = response.get().as(int.class);
		
		assertEquals(1, result);
	}
	
	@Test
	public void shouldExecuteRequestWithException() {
		ApiRequest request =
			new YandexDirectRequest.Builder(new AuthToken(""))
				.forMethod(MethodName.PingAPI)
				.build();
		
		ApiException exception = null;
		
		try {
			executor.execute(request);
		} catch(ApiException e) {
			exception = e;
		}
		
		assertNotNull(exception);
		assertEquals(53, exception.errorCode());
		
	}

}
