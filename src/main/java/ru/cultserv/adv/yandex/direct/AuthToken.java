package ru.cultserv.adv.yandex.direct;

public class AuthToken {

	private final String value;
	
	public AuthToken(String token) {
		this.value = token;
	}
	
	public String value() {
		return value;
	}

}
