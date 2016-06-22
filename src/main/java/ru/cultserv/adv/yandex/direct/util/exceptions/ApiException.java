package ru.cultserv.adv.yandex.direct.util.exceptions;

public class ApiException extends RuntimeException {

	private static final long serialVersionUID = -2649739798540624789L;

	private String requestId;
	private int errorCode;
	private String errorStr;
	private String errorDetail;

	public ApiException(String requestId, int errorCode, String errorStr, String errorDetail) {
		this(errorCode, errorStr, errorDetail);
		this.requestId = requestId;
	}

	public ApiException(int errorCode, String errorStr, String errorDetail) {
		super(
			errorCode + " :: " + errorStr +
			(errorDetail != null && !errorDetail.isEmpty() ? (" :: " + errorDetail) : "")
		);
		
		this.errorCode = errorCode;
		this.errorStr = errorStr;
		this.errorDetail = errorDetail;
	}

	public String getRequestId() {
		return requestId;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public String getErrorStr() {
		return errorStr;
	}

	public String getErrorDetail() {
		return errorDetail;
	}
}
