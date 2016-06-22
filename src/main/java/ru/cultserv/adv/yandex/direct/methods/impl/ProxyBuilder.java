package ru.cultserv.adv.yandex.direct.methods.impl;

import com.google.common.base.Function;
import com.google.common.reflect.Reflection;
import ru.cultserv.adv.yandex.direct.methods.ParamConverter;
import ru.cultserv.adv.yandex.direct.methods.WithConverter;
import ru.cultserv.adv.yandex.direct.util.requests.YandexDirectMethodCaller;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Alexandr Kolosov
 * @since 7/3/14
 */
public class ProxyBuilder {

	private static class Handler implements InvocationHandler {

		private String name;
		private YandexDirectMethodCaller caller;

		private Handler(String name, YandexDirectMethodCaller caller) {
			this.name = name;
			this.caller = caller;
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			if (method.getName().equals("toString") && args == null) {
				return name;
			}

			WithConverter withConverter = method.getAnnotation(WithConverter.class);
			if (withConverter == null) {
				throw new IllegalStateException("no annotation on method " + method.getName());
			}

			Function<Object[], Object> converter;
			if (!withConverter.entity().isEmpty()) {
				converter = ParamConverter.createFunction(withConverter.entity());
			} else {
				converter = withConverter.converter().getFunction();
			}

			if (converter != null) {
				return caller.call(method, converter.apply(args), withConverter.flatten());
			}

			return caller.call(method, args);
		}
	}

	public static <T> T create(Class<T> targetInterface, YandexDirectMethodCaller caller) {
		String name = targetInterface.getName();
		return Reflection.newProxy(targetInterface, new Handler(name, caller));
	}
}
