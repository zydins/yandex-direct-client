package ru.cultserv.adv.util;

import com.fasterxml.jackson.core.type.TypeReference;
import ru.cultserv.adv.yandex.direct.util.exceptions.ApiException;

import java.lang.reflect.Type;

public interface ApiResponse {

	<T> T as(Class<T> data_class);
	
	<T> T as(TypeReference<T> data_type_reference);

	<T> T as(Type type);
	
	boolean hasError();
	
	ApiException error();

}
