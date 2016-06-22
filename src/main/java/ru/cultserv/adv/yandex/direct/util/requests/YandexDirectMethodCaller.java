package ru.cultserv.adv.yandex.direct.util.requests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.ning.http.client.AsyncHttpClient;
import ru.cultserv.adv.util.ApiRequest;
import ru.cultserv.adv.util.ApiRequestExecutor;
import ru.cultserv.adv.util.ApiResponse;
import ru.cultserv.adv.util.AsyncClientFactory;
import ru.cultserv.adv.yandex.direct.AuthToken;

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

	@SuppressWarnings("unchecked")
	public <T> T call(Method method, Object param) {
		ApiRequest request = buildCommonRequest(method, param);
		ApiResponse response = executor.execute(request);
		T result;

		Type returnType = method.getGenericReturnType();
		if (returnType instanceof ParameterizedType) {
			result = (T) response.as(returnType);
		} else if (returnType instanceof Class) {
			result = (T) response.as(method.getReturnType());
		} else {
			result = null;
		}
//		if(returnType != null) {
//			TypeReference<?> typeReference = buildRef(returnType);
//			result = (T) response.as(typeReference);
//		} else {
//			result = null;
//		}

		return result;
	}

	private <T> TypeReference<T> buildRef(Class<T> obj) {
		return new TypeReference<T>() {};
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
