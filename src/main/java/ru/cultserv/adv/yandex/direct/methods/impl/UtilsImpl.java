package ru.cultserv.adv.yandex.direct.methods.impl;

import ru.cultserv.adv.yandex.direct.AuthToken;
import ru.cultserv.adv.yandex.direct.methods.MethodName;
import ru.cultserv.adv.yandex.direct.methods.Utils;
import ru.cultserv.adv.yandex.direct.util.requests.YandexDirectMethodCaller;

/**
 * @author Alexandr Kolosov
 * @since 7/2/14
 */
public class UtilsImpl implements Utils {

	private final YandexDirectMethodCaller caller;

	public UtilsImpl(AuthToken token) {
		this(YandexDirectMethodCaller.defaultCaller(token));
	}

	public UtilsImpl(YandexDirectMethodCaller caller) {
		this.caller = caller;
	}

	@Override
	public boolean ping() {
		return caller.call(MethodName.PingAPI) == 1;
	}
}
