package ru.cultserv.adv.yandex.direct.util.exceptions;

public class ApiException extends RuntimeException {

	private static final long serialVersionUID = -2649739798540624789L;
	
	private int error_code;
	private String error_str;
	private String error_detail;
	
	public ApiException(int error_code, String error_str, String error_detail) {
		super(
			error_code + " :: " + error_str +
			(error_detail != null && !error_detail.isEmpty() ? (" :: " + error_detail) : "")
		);
		
		this.error_code = error_code;
		this.error_str = error_str;
		this.error_detail = error_detail;
	}
	
	public int errorCode() {
		return error_code;
	}
	
	public String errorStr() {
		return error_str;
	}
	
	public String errorDetail() {
		return error_detail;
	}

}
