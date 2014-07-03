package ru.cultserv.adv.yandex.direct.methods.impl;

import ru.cultserv.adv.yandex.direct.methods.DirectMethod;
import ru.cultserv.adv.yandex.direct.methods.MethodName;
import ru.cultserv.adv.yandex.direct.util.requests.YandexDirectMethodCaller;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

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

			DirectMethod annotation = method.getAnnotation(DirectMethod.class);
			if (annotation == null) {
				throw new IllegalStateException("no annotation on method " + method.getName());
			}

			MethodName methodName = annotation.value();
			return caller.call(methodName, args);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T create(Class<T> targetInterface, YandexDirectMethodCaller caller) {
		Class<?>[] interfaces = {targetInterface};
		String name = targetInterface.getName();
		return (T) Proxy.newProxyInstance(targetInterface.getClassLoader(), interfaces, new Handler(name, caller));
	}
}
