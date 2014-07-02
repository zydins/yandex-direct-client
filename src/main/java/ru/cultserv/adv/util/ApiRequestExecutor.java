package ru.cultserv.adv.util;

import com.google.common.base.Optional;

import java.util.concurrent.Future;

public interface ApiRequestExecutor {

	Optional<ApiResponse> execute(ApiRequest request);

	Future<ApiResponse> asFuture(ApiRequest request);

}
