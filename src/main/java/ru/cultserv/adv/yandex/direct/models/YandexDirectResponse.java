package ru.cultserv.adv.yandex.direct.models;

import ru.cultserv.adv.util.ApiResponse;
import ru.cultserv.adv.util.Json;
import ru.cultserv.adv.yandex.direct.util.exceptions.ApiException;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;

public class YandexDirectResponse implements ApiResponse {

	@JsonProperty
	private JsonNode data;
	
	@JsonProperty
	private Integer error_code;
	
	@JsonProperty
	private String error_str;
	
	@JsonProperty
	private String error_detail;

	@Override
	public <T> T as(Class<T> data_class) {
		return Json.parse(data.toString(), data_class);
	}

	@Override
	public <T> T as(TypeReference<T> data_type_reference) {
		return Json.parse(data.toString(), data_type_reference);
	}
	
	@Override
	public boolean hasError() {
		return error_code != null;
	}
	
	public ApiException error() {
		return new ApiException(error_code, error_str, error_detail);
	}

}
