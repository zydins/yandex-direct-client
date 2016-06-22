package ru.cultserv.adv.yandex.direct.util.params;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableMap;
import ru.cultserv.adv.util.ApiRequestParams;

import java.util.HashMap;
import java.util.Map;

public class YandexDirectParams implements ApiRequestParams {

	@JsonProperty
	private String method;
	
	@JsonProperty
	private Object params;
	
	private String token;
	
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

	@Override
	public Map<String, String> headers() {
		return ImmutableMap.of("Authorization", "Bearer " + token, "Accept-Language", locale);
	}

	@Override
	public Object body() {
		Map<String, Object> map = new HashMap<>();
		map.put("method", method);
		map.put("params", params);
		return map;
	}
}
