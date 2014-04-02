package ru.cultserv.adv.yandex.direct.util.requests;

import ru.cultserv.adv.util.ApiRequest;
import ru.cultserv.adv.util.ApiRequestParams;
import ru.cultserv.adv.yandex.direct.AuthToken;
import ru.cultserv.adv.yandex.direct.methods.MethodName;
import ru.cultserv.adv.yandex.direct.util.params.YandexDirectParams;

public class YandexDirectRequest implements ApiRequest {
	
	public static final String PRODUCTION_URL = "https://api.direct.yandex.ru/live/v4/json/";
	public static final String SANDBOX_URL = "https://api-sandbox.direct.yandex.ru/live/v4/json/";
	
	private String http_method = "POST";
	private String full_url = SANDBOX_URL;
	
	private YandexDirectParams params = new YandexDirectParams();

	@Override
	public String httpMethod() {
		return http_method;
	}

	@Override
	public String url() {
		return full_url;
	}

	@Override
	public ApiRequestParams params() {
		return params;
	}
	
	public static class Builder {
		
		private final YandexDirectRequest request;
		
		public Builder(AuthToken token) {
			request = new YandexDirectRequest();
			request.params.setToken(token.value());
		}

		public Builder forMethod(String api_method) {
			request.params.setMethod(api_method);
			return this;
		}
		
		public Builder forMethod(MethodName api_method) {
			return forMethod(api_method.name());
		}
		
		public Builder andParam(Object param) {
			request.params.setParam(param);
			return this;
		}
		
		public ApiRequest build() {
			return request;
		}

	}

}
