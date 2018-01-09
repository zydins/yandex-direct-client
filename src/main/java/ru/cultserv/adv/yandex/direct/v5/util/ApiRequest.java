package ru.cultserv.adv.yandex.direct.v5.util;

import ru.cultserv.adv.yandex.direct.v5.models.util.Format;

public interface ApiRequest {

	String httpMethod();
	
	String url();
	
	ApiRequestParams params();

	Format returnFormat();

}
