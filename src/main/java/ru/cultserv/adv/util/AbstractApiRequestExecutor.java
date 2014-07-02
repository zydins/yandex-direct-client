package ru.cultserv.adv.util;

import com.ning.http.client.*;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public abstract class AbstractApiRequestExecutor implements ApiRequestExecutor {
	
	private static final AsyncHttpClient CLIENT = createHttpClient();
	
	private static AsyncHttpClient createHttpClient() {
		return new AsyncHttpClient();
	}

	@Override
	public ApiResponse execute(ApiRequest request) {
		Request http_request = convertToHttpRequest(request);
		Response response;
		
		try {
			ListenableFuture<Response> future = CLIENT.executeRequest(http_request);
			response = future.get(30, TimeUnit.SECONDS);
		} catch (IOException | InterruptedException | ExecutionException | TimeoutException e) {
			throw new RuntimeException(e);
		}

		return process(response);
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
