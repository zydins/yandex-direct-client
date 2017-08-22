package ru.cultserv.adv.yandex.direct.v5.util;

/**
 * User: Iggi
 * Date: 18/08/2017
 * Time: 14:11
 */
public interface ApiResponseCallback {

    void callback(final ApiRequest request, final ApiResponse response);
}
