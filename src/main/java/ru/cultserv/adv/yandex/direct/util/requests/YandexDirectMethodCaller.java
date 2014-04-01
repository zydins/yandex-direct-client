package ru.cultserv.adv.yandex.direct.util.requests;

import ru.cultserv.adv.util.ApiRequest;
import ru.cultserv.adv.util.ApiRequestExecutor;
import ru.cultserv.adv.yandex.direct.AuthToken;
import ru.cultserv.adv.yandex.direct.methods.MethodName;

import com.fasterxml.jackson.core.type.TypeReference;

public class YandexDirectMethodCaller {
	
	private AuthToken token;
	
	public YandexDirectMethodCaller(AuthToken token) {
		this.token = token;
	}
	
	public <T> T call(MethodName method, Object param, TypeReference<T> tr, ApiRequestExecutor executor) {
		ApiRequest request = buildCommonRequest(method, param);
		return executor.execute(request).as(tr);
	}
	
	public <T> T call(MethodName method, Object param, Class<T> clazz, ApiRequestExecutor executor) {
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
