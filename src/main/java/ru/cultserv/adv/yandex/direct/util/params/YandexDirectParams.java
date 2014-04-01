package ru.cultserv.adv.yandex.direct.util.params;

import ru.cultserv.adv.util.ApiRequestParams;

import com.fasterxml.jackson.annotation.JsonProperty;

public class YandexDirectParams implements ApiRequestParams {

	@JsonProperty
	private String method;
	
	@JsonProperty
	private Object param;
	
	@JsonProperty
	private String token;
	
	@JsonProperty
	private String locale = "ru";

	public void setParam(Object param) {
		this.param = param;
	}
	
	public void setMethod(String api_method_name) {
		this.method = api_method_name;
	}
	
	public void setToken(String token) {
		this.token = token;
	}

}
