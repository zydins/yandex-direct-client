package ru.cultserv.adv.yandex.direct.util.requests;

import ru.cultserv.adv.util.ApiRequest;
import ru.cultserv.adv.util.ApiRequestParams;
import ru.cultserv.adv.yandex.direct.AuthToken;
import ru.cultserv.adv.yandex.direct.methods.MethodName;
import ru.cultserv.adv.yandex.direct.util.params.YandexDirectParams;

public class YandexDirectRequest implements ApiRequest {
	
	public static final String PRODUCTION_URL = "https://api.direct.yandex.ru/live/v4/json/";
	public static final String SANDBOX_URL = "https://213.180.204.225/live/v4/json/";

	private final String url;
	private final YandexDirectParams params;

	public YandexDirectRequest() {
		boolean isSandBox = Integer.getInteger("ru.cultserv.adv.yandex.direct.util.requests.mode", 1) == 1;
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
