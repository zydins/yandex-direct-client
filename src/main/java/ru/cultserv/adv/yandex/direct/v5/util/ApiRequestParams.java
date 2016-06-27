package ru.cultserv.adv.yandex.direct.v5.util;

import java.util.Map;

public interface ApiRequestParams {

    Map<String, String> headers();

    Object body();

}
