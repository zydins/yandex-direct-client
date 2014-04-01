package ru.cultserv.adv.util;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Request;
import com.ning.http.client.RequestBuilder;
import com.ning.http.client.Response;

public abstract class AbstractApiRequestExecutor implements ApiRequestExecutor {
	
	private static final AsyncHttpClient CLIENT = createHttpClient();
	
	private static AsyncHttpClient createHttpClient() {
		AsyncHttpClient client = new AsyncHttpClient();
		return client;
	}

	@Override
	public ApiResponse execute(ApiRequest request) {
		Request http_request = convertToHttpRequest(request);
		Response response = null;
		
		try {
			response = CLIENT.executeRequest(http_request).get(30, TimeUnit.SECONDS);
		} catch (IOException | InterruptedException | ExecutionException | TimeoutException e) {
			throw new RuntimeException(e);
		}
		
		ApiResponse result = process(response);
		return result;
	}
	
	private Request convertToHttpRequest(ApiRequest request) {
		RequestBuilder builder = new RequestBuilder();
		
		builder
			.setMethod(request.httpMethod())
			.setUrl(request.url());
		
		withParams(request.params(), builder);
		
		return builder.build();
	}
	
	protected void withParams(final ApiRequestParams params, final RequestBuilder builder) {
		builder.setBody(Json.toJson(params).toString());
	}
	
	protected abstract ApiResponse process(Response response);

}
