package ru.cultserv.adv.util;

public interface ApiRequest {

	String httpMethod();
	
	String url();
	
	ApiRequestParams params();

}
