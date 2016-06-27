package ru.cultserv.adv.yandex.direct.v5.util.requests;

import com.ning.http.client.AsyncHttpClient;
import ru.cultserv.adv.yandex.direct.v5.AuthToken;
import ru.cultserv.adv.yandex.direct.v5.util.ApiRequest;
import ru.cultserv.adv.yandex.direct.v5.util.ApiRequestExecutor;
import ru.cultserv.adv.yandex.direct.v5.util.ApiResponse;
import ru.cultserv.adv.yandex.direct.v5.util.AsyncClientFactory;

import java.io.Closeable;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class YandexDirectMethodCaller implements Closeable {
	
	private final AuthToken token;
	private final ApiRequestExecutor executor;

	public YandexDirectMethodCaller(AuthToken token, ApiRequestExecutor executor) {
		this.token = token;
		this.executor = executor;
	}

	public <T> T call(Method method) {
		return call(method, new String[] {});
	}

	public <T> T call(Method method, Object param) {
		return call(method, param, false);
	}

	@SuppressWarnings("unchecked")
	public <T> T call(Method method, Object param, boolean flatten) {
		ApiRequest request = buildCommonRequest(method, param);
		ApiResponse response = executor.execute(request);
		T result;

		Type returnType = method.getGenericReturnType();
		if (returnType instanceof ParameterizedType) {
			result = (T) response.as(returnType, flatten);
		} else if (returnType instanceof Class) {
			result = (T) response.as(method.getReturnType(), flatten);
		} else {
			result = null;
		}

		return result;
	}
	
	private ApiRequest buildCommonRequest(Method method, Object param) {
		return new YandexDirectRequest.Builder(token)
			.forMethod(method)
			.andParam(param)
			.build();
	}

    public static YandexDirectMethodCaller prepared(AuthToken token, AsyncHttpClient client) {
        return new YandexDirectMethodCaller(token, new YandexRequestExecutor(client));
    }

	public static YandexDirectMethodCaller defaultCaller(AuthToken token) {
		return prepared(token, AsyncClientFactory.getClient());
	}

	@Override
	public void close() {
		executor.close();
	}
}