package ru.cultserv.adv.yandex.direct.util.requests;

import com.google.common.base.Optional;
import ru.cultserv.adv.util.ApiRequest;
import ru.cultserv.adv.util.ApiRequestExecutor;
import ru.cultserv.adv.util.ApiResponse;
import ru.cultserv.adv.yandex.direct.AuthToken;
import ru.cultserv.adv.yandex.direct.methods.MethodName;

public class YandexDirectMethodCaller {
	
	private final AuthToken token;
	private final ApiRequestExecutor executor;
	
	public YandexDirectMethodCaller(AuthToken token, ApiRequestExecutor executor) {
		this.token = token;
		this.executor = executor;
	}

	public <T> T call(MethodName method) {
		return call(method, new String[] {});
	}

	@SuppressWarnings("unchecked")
	public <T> T call(MethodName method, Object param) {
		ApiRequest request = buildCommonRequest(method, param);
		Optional<ApiResponse> responseOpt = executor.execute(request);
		T result;

		if (responseOpt.isPresent()) {
			ApiResponse response = responseOpt.get();
			if(method.returnClass() != null) {
				result = (T) response.as(method.returnClass());
			} else {
				result = (T) response.as(method.returnType());
			}

			return result;
		} else {
			throw new RuntimeException("no response");
		}
	}
	
	private ApiRequest buildCommonRequest(MethodName method, Object param) {
		ApiRequest request =
			new YandexDirectRequest.Builder(token)
				.forMethod(method)
				.andParam(param)
				.build();
		
		return request;
	}

}
