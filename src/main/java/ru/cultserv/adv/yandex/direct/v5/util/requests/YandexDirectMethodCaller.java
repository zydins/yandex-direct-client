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
	private final String clientLogin;
	private final ApiRequestExecutor executor;

	private Integer apiPoints;

	public YandexDirectMethodCaller(AuthToken token, ApiRequestExecutor executor) {
		this(token, null, executor);
	}

	public YandexDirectMethodCaller(AuthToken token, String clientLogin, ApiRequestExecutor executor) {
		this.token = token;
		this.clientLogin = clientLogin;
		this.executor = executor;
	}

	public <T> T call(Method method) {
		return call(method, new String[] {});
	}

	public <T> T call(Method method, Object param) {
		return call(method, param, false);
	}

	public <T> T call(Method method, Object param, boolean flatten) {
		return call(method, param, method.getName(), flatten);
	}

	@SuppressWarnings("unchecked")
	public <T> T call(Method method, Object param, String methodName, boolean flatten) {
		ApiRequest request = buildCommonRequest(method, param, methodName);
		ApiResponse response = executor.execute(request);
		apiPoints = response.apiPoints();
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
	
	private ApiRequest buildCommonRequest(Method method, Object param, String customName) {
		YandexDirectRequest.Builder builder = new YandexDirectRequest.Builder(token)
				.forService(method.getDeclaringClass().getSimpleName().toLowerCase())
				.forMethod(customName);
		if (clientLogin != null) {
			builder.forClient(clientLogin);
		}
		return builder.andParam(param).build();
	}

    public static YandexDirectMethodCaller prepared(AuthToken token, AsyncHttpClient client) {
        return prepared(token, null, client);
    }

	public static YandexDirectMethodCaller prepared(AuthToken token, String clientLogin, AsyncHttpClient client) {
		return new YandexDirectMethodCaller(token, clientLogin, new YandexRequestExecutor(client));
	}

	public static YandexDirectMethodCaller defaultCaller(AuthToken token) {
		return prepared(token, AsyncClientFactory.getClient());
	}

	@Override
	public void close() {
		executor.close();
	}

	public Integer apiPoints() {
		return apiPoints;
	}
}
