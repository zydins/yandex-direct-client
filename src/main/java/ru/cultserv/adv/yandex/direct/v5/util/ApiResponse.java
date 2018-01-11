package ru.cultserv.adv.yandex.direct.v5.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.ning.http.client.FluentCaseInsensitiveStringsMap;
import ru.cultserv.adv.yandex.direct.v5.models.Unit;
import ru.cultserv.adv.yandex.direct.v5.util.exceptions.ApiException;

import java.lang.reflect.Type;

public interface ApiResponse {

	<T> T as(Class<T> dataClass);
	
	<T> T as(Class<T> dataClass, boolean flatten);

	<T> T as(TypeReference<T> typeReference);

	<T> T as(TypeReference<T> typeReference, boolean flatten);

	<T> T as(Type type);

    <T> T as(Type type, boolean flatten);

	boolean hasError();

	Unit apiPoints();

	int responseCode();

	FluentCaseInsensitiveStringsMap headers();

	ApiException error();

}
