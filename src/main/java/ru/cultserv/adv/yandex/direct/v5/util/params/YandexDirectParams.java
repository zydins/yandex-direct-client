package ru.cultserv.adv.yandex.direct.v5.util.params;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.cultserv.adv.yandex.direct.v5.util.ApiRequestParams;

import java.util.HashMap;
import java.util.Map;

public class YandexDirectParams implements ApiRequestParams {

	@JsonProperty
	private String method;
	
	@JsonProperty
	private Object params;
	
	private String token;

	private String clientLogin = null;
	
	private String locale = "ru";

	private String processingMode = null;
	private Boolean skipReportHeader = null;
	private Boolean skipColumnHeader = null;
	private Boolean skipReportSummary = null;

	public void setParams(Object params) {
		this.params = params;
	}
	
	public void setMethod(String api_method_name) {
		this.method = api_method_name;
	}

	public String getMethod() {
		return method;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getClientLogin() {
		return clientLogin;
	}

	public void setClientLogin(String clientLogin) {
		this.clientLogin = clientLogin;
	}

	public String getProcessingMode() {
		return processingMode;
	}

	public void setProcessingMode(String processingMode) {
		this.processingMode = processingMode;
	}

	public Boolean getSkipReportHeader() {
		return skipReportHeader;
	}

	public void setSkipReportHeader(Boolean skipReportHeader) {
		this.skipReportHeader = skipReportHeader;
	}

	public Boolean getSkipColumnHeader() {
		return skipColumnHeader;
	}

	public void setSkipColumnHeader(Boolean skipColumnHeader) {
		this.skipColumnHeader = skipColumnHeader;
	}

	public Boolean getSkipReportSummary() {
		return skipReportSummary;
	}

	public void setSkipReportSummary(Boolean skipReportSummary) {
		this.skipReportSummary = skipReportSummary;
	}

	@Override
	public Map<String, String> headers() {
		Map<String, String> headers = new HashMap<>();
		headers.put("Authorization", "Bearer " + token);
		headers.put("Accept-Language", locale);
		if (clientLogin != null) {
			headers.put("Client-Login", clientLogin);
			headers.put("Use-Operator-Units", "true");
		}
		if (processingMode != null) {
			headers.put("processingMode", processingMode);
		}
		if (skipColumnHeader != null) {
			headers.put("skipColumnHeader", skipColumnHeader.toString());
		}
		if (skipReportHeader != null) {
			headers.put("skipReportHeader", skipReportHeader.toString());
		}
		if (skipReportSummary != null) {
			headers.put("skipReportSummary", skipReportSummary.toString());
		}
		return headers;
	}

	@Override
	public Object body() {
		Map<String, Object> map = new HashMap<>();
		map.put("method", method);
		map.put("params", params);
		return map;
	}
}
