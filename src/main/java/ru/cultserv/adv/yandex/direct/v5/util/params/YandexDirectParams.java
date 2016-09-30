package ru.cultserv.adv.yandex.direct.v5.util.params;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.cultserv.adv.yandex.direct.v5.util.ApiRequestParams;

import java.util.HashMap;
import java.util.Map;

public class YandexDirectParams implements ApiRequestParams {

	@JsonProperty
	private String method;
	
	@JsonProperty
	private Object params;
	
	private String token;

	private String clientLogin = null;
	
	private String locale = "ru";

	public void setParams(Object params) {
		this.params = params;
	}
	
	public void setMethod(String api_method_name) {
		this.method = api_method_name;
	}
	
	public void setToken(String token) {
		this.token = token;
	}

	public void setClientLogin(String clientLogin) {
		this.clientLogin = clientLogin;
	}

	@Override
	public Map<String, String> headers() {
		Map<String, String> headers = new HashMap<>();
		headers.put("Authorization", "Bearer " + token);
		headers.put("Accept-Language", locale);
		if (clientLogin != null) {
			headers.put("Client-Login", clientLogin);
			headers.put("Use-Operator-Units", "true");
		}
		return headers;
	}

	@Override
	public Object body() {
		Map<String, Object> map = new HashMap<>();
		map.put("method", method);
		map.put("params", params);
		return map;
	}
}
