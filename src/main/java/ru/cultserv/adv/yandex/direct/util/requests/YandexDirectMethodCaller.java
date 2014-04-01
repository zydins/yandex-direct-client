package ru.cultserv.adv.yandex.direct.util.requests;

import ru.cultserv.adv.util.ApiRequest;
import ru.cultserv.adv.util.ApiRequestExecutor;
import ru.cultserv.adv.yandex.direct.AuthToken;
import ru.cultserv.adv.yandex.direct.methods.MethodName;

import com.fasterxml.jackson.core.type.TypeReference;

public class YandexDirectMethodCaller {
	
	private final AuthToken token;
	private final ApiRequestExecutor executor;
	
	public YandexDirectMethodCaller(AuthToken token, ApiRequestExecutor executor) {
		this.token = token;
		this.executor = executor;
	}
	
	public <T> T call(MethodName method, Object param, TypeReference<T> tr) {
		ApiRequest request = buildCommonRequest(method, param);
		return executor.execute(request).as(tr);
	}
	
	public <T> T call(MethodName method, Object param, Class<T> clazz) {
		ApiRequest request = buildCommonRequest(method, param);
		return executor.execute(request).as(clazz);
	}
	
	private ApiRequest buildCommonRequest(MethodName method, Object param) {
		ApiRequest request =
			new YandexDirectRequest.Builder(token)
				.forMethod(method.name())
				.andParam(param)
				.build();
		
		return request;
	}

}
