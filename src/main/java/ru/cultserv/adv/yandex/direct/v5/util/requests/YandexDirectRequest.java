package ru.cultserv.adv.yandex.direct.v5.util.requests;

import ru.cultserv.adv.yandex.direct.v5.AuthToken;
import ru.cultserv.adv.yandex.direct.v5.util.ApiRequest;
import ru.cultserv.adv.yandex.direct.v5.util.ApiRequestParams;
import ru.cultserv.adv.yandex.direct.v5.util.params.YandexDirectParams;

public class YandexDirectRequest implements ApiRequest {
	
	public static final String PRODUCTION_URL = "https://api.direct.yandex.com/json/v5/";
	public static final String SANDBOX_URL = null; //TODO

	private final YandexDirectParams params;
	private String url;

	public YandexDirectRequest() {
		boolean isSandBox = Integer.getInteger("ru.cultserv.adv.yandex.direct.util.requests.mode", 0) == 1;
		this.url = isSandBox ? SANDBOX_URL : PRODUCTION_URL;
		this.params = new YandexDirectParams();
	}

	@Override
	public String httpMethod() {
		return "POST";
	}

	@Override
	public String url() {
		return url;
	}

	@Override
	public ApiRequestParams params() {
		return params;
	}
	
	public static class Builder {
		
		private final YandexDirectRequest request;
		
		public Builder(AuthToken token) {
			request = new YandexDirectRequest();
            String value = token.value();
            if (value != null) {
                request.params.setToken(value);
            }
		}

		public Builder forService(String service) {
			request.url += service;
			return this;
		}

		public Builder forMethod(String method) {
			request.params.setMethod(method);
			return this;
		}

		public Builder forClient(String clientLogin) {
			request.params.setClientLogin(clientLogin);
			return this;
		}

		public Builder andParam(Object param) {
			request.params.setParams(param);
			return this;
		}
		
		public ApiRequest build() {
			return request;
		}
	}
}
