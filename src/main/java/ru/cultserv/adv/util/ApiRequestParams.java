package ru.cultserv.adv.util;

import java.util.Map;

public interface ApiRequestParams {

    Map<String, String> headers();

    Object body();

}
