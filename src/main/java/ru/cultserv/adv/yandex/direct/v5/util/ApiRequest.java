package ru.cultserv.adv.yandex.direct.v5.util;

public interface ApiRequest {

	String httpMethod();
	
	String url();
	
	ApiRequestParams params();

}
