package ru.cultserv.adv.yandex.direct.clients;

import ru.cultserv.adv.yandex.direct.AuthToken;
import ru.cultserv.adv.yandex.direct.YandexDirect;
import ru.cultserv.adv.yandex.direct.impl.YandexDirectImpl;

public class YDProductionClientTest extends YandexDirectClientTest {

	@Override
	public YandexDirect directInstance() {
		return new YandexDirectImpl(new AuthToken("f3e8a7c18f284908aa226b64213c4002"));
	}

}
