package ru.cultserv.adv.yandex.direct.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import ru.cultserv.adv.util.ApiResponse;
import ru.cultserv.adv.util.Json;
import ru.cultserv.adv.yandex.direct.util.exceptions.ApiException;

import java.lang.reflect.Type;

public class YandexDirectResponse implements ApiResponse {

	@JsonProperty
	private JsonNode result;
	
	@JsonProperty
	private Integer error_code;
	
	@JsonProperty
	private String error_string;
	
	@JsonProperty
	private String error_detail;

	@Override
	public <T> T as(Class<T> dataClass) {
		return as(dataClass, false);
	}

	@Override
	public <T> T as(Class<T> dataClass, boolean flatten) {
		return Json.parse(result.toString(), dataClass, flatten);
	}

	@Override
	public <T> T as(TypeReference<T> typeReference) {
		return as(typeReference, false);
	}

	@Override
	public <T> T as(TypeReference<T> typeReference, boolean flatten) {
		return Json.parse(result.toString(), typeReference, flatten);
	}

	@Override
	public <T> T as(Type type) {
		return as(type, false);
	}

	@Override
	public <T> T as(Type type, boolean flatten) {
		return Json.parse(result.toString(), type, flatten);
	}

	@Override
	public boolean hasError() {
		return error_code != null;
	}
	
	public ApiException error() {
		return new ApiException(error_code, error_string, error_detail);
	}

}
