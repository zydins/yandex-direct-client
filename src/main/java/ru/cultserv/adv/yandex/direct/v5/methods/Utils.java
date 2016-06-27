package ru.cultserv.adv.yandex.direct.v5.methods;

/**
 * @author Alexandr Kolosov
 * @since 7/2/14
 */
public interface Utils {

	@DirectMethod(MethodName.PingAPI)
	int ping();

}
