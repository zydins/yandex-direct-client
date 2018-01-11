package ru.cultserv.adv.yandex.direct.v5.util.requests;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.FluentCaseInsensitiveStringsMap;
import ru.cultserv.adv.yandex.direct.v5.AuthToken;
import ru.cultserv.adv.yandex.direct.v5.models.Unit;
import ru.cultserv.adv.yandex.direct.v5.models.util.Format;
import ru.cultserv.adv.yandex.direct.v5.util.*;

import java.io.Closeable;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class YandexDirectMethodCaller implements Closeable {
	
	private final AuthToken token;
	private final String clientLogin;
	private final ApiRequestExecutor executor;
	private final List<ApiResponseCallback> callbacks = new CopyOnWriteArrayList<>();

	private Unit apiPoints;
	private int responseCode;
	public FluentCaseInsensitiveStringsMap headers;


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

	public <T> T call(Method method, Object param, String methodName, boolean flatten) {
		return call(method, param, methodName, Format.JSON, flatten);
	}

	@SuppressWarnings("unchecked")
	public <T> T call(Method method, Object param, String methodName, Format format, boolean flatten) {
		ApiRequest request = buildCommonRequest(method, param, methodName, format);
		ApiResponse response = executor.execute(request);

		apiPoints = response.apiPoints();
		responseCode = response.responseCode();
		headers = response.headers();

		fireCallback(request, response);

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
	
	private ApiRequest buildCommonRequest(Method method, Object param, String customName, Format format) {
		YandexDirectRequest.Builder builder = new YandexDirectRequest.Builder(token)
				.forService(method.getDeclaringClass().getSimpleName())
				.forFormat(format)
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

	public Unit apiPoints() {
		return apiPoints;
	}

	public int responseCode() {
		return responseCode;
	}

	public List<String> getHeader(String name) {
		return headers.get(name);
	}

	private void fireCallback(final ApiRequest request, final ApiResponse response) {
		callbacks.forEach(c -> {
			try {
				c.callback(request, response);
			} catch (Throwable t) {
				//empty
			}
		});
	}

	public void addCallback(final ApiResponseCallback callback) {
		callbacks.add(callback);
	}

	public void removeCallback(final ApiResponseCallback callback) {
		callbacks.remove(callback);
	}
}
