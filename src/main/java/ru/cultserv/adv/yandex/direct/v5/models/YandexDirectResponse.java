package ru.cultserv.adv.yandex.direct.v5.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.ning.http.client.FluentCaseInsensitiveStringsMap;
import ru.cultserv.adv.yandex.direct.v5.util.ApiResponse;
import ru.cultserv.adv.yandex.direct.v5.util.Json;
import ru.cultserv.adv.yandex.direct.v5.util.exceptions.ApiException;

import java.lang.reflect.Type;

public class YandexDirectResponse implements ApiResponse {

	@JsonProperty
	private JsonNode result;

	@JsonProperty
	private Unit api_points;
	
	@JsonProperty
	private Integer error_code;
	
	@JsonProperty
	private String error_string;
	
	@JsonProperty
	private String error_detail;

	private FluentCaseInsensitiveStringsMap headers;

	@Override
	public <T> T as(Class<T> dataClass) {
		return as(dataClass, false);
	}

	@Override
	public <T> T as(Class<T> dataClass, boolean flatten) {
		if (result == null) {
			return null;
		}
		return Json.parse(result.toString(), dataClass, flatten);
	}

	@Override
	public <T> T as(TypeReference<T> typeReference) {
		return as(typeReference, false);
	}

	@Override
	public <T> T as(TypeReference<T> typeReference, boolean flatten) {
		if (result == null) {
			return null;
		}
		return Json.parse(result.toString(), typeReference, flatten);
	}

	@Override
	public <T> T as(Type type) {
		return as(type, false);
	}

	@Override
	public <T> T as(Type type, boolean flatten) {
		if (result == null) {
			return null;
		}
		return Json.parse(result.toString(), type, flatten);
	}

	public FluentCaseInsensitiveStringsMap getHeaders() {
		return headers;
	}

	public void setHeaders(final FluentCaseInsensitiveStringsMap headers) {
		this.headers = headers;
	}

	@Override
	public Unit apiPoints() {
		return api_points;
	}

	@Override
	public boolean hasError() {
		return error_code != null;
	}
	
	public ApiException error() {
		return new ApiException(error_code, error_string, error_detail);
	}

	public void setApiPoints(Unit api_points) {
		this.api_points = api_points;
	}

	public String getRequestId() {
		return headers.getFirstValue("RequestId");
	}
}
