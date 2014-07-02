package ru.cultserv.adv.util;

import java.util.concurrent.Future;

public interface ApiRequestExecutor {

	ApiResponse execute(ApiRequest request);

	Future<ApiResponse> asFuture(ApiRequest request);

}
