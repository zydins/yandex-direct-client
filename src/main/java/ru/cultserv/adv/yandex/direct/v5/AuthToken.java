package ru.cultserv.adv.yandex.direct.v5;

public class AuthToken {

	private final String value;
	
	public AuthToken(String token) {
		this.value = token;
	}
	
	public String value() {
		return value;
	}

}
