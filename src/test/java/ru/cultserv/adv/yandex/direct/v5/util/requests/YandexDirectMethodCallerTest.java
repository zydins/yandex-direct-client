package ru.cultserv.adv.yandex.direct.v5.util.requests;

import org.junit.Assert;
import org.junit.Test;
import ru.cultserv.adv.yandex.direct.v5.util.ApiRequest;
import ru.cultserv.adv.yandex.direct.v5.util.ApiResponse;
import ru.cultserv.adv.yandex.direct.v5.util.ApiResponseCallback;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * User: Iggi
 * Date: 18/08/2017
 * Time: 14:38
 */
public class YandexDirectMethodCallerTest {

    @Test
    public void testCallback() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        YandexDirectMethodCaller caller = new YandexDirectMethodCaller(null, null);
        final AtomicBoolean called = new AtomicBoolean(false);
        final ApiResponseCallback callback = (request, response) -> {
            called.set(true);
        };
        caller.addCallback(callback);
        final Method m = YandexDirectMethodCaller.class.getDeclaredMethod("fireCallback", ApiRequest.class, ApiResponse.class);
        m.setAccessible(true);
        m.invoke(caller, null, null);
        Assert.assertEquals("Callback must be called", true, called.get());

        caller.removeCallback(callback);
        called.set(false);
        m.invoke(caller, null, null);
        Assert.assertEquals("Callback must not be called", false, called.get());
    }
}