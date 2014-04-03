package ru.cultserv.adv.yandex.direct.util.requests;

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
	
	@SuppressWarnings("unchecked")
	public <T> T call(MethodName method, Object param) {
		ApiRequest request = buildCommonRequest(method, param);
		ApiResponse response = executor.execute(request);
		T result;
		
		if(method.returnClass() != null)
			result = (T) response.as(method.returnClass());
		else
			result = (T) response.as(method.returnType());
		
		return result;
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
