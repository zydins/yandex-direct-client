package ru.cultserv.adv.util;

import ru.cultserv.adv.yandex.direct.util.exceptions.ApiException;

import com.fasterxml.jackson.core.type.TypeReference;

public interface ApiResponse {

	<T> T as(Class<T> data_class);
	
	<T> T as(TypeReference<T> data_type_reference);
	
	boolean hasError();
	
	ApiException error();

}
