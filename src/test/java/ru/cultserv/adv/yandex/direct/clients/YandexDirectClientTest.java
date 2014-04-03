package ru.cultserv.adv.yandex.direct.clients;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import ru.cultserv.adv.yandex.direct.YandexDirect;
import ru.cultserv.adv.yandex.direct.impl.YandexDirectImpl;
import ru.cultserv.adv.yandex.direct.methods.Campaigns;
import ru.cultserv.adv.yandex.direct.util.AuthTokens;

public class YandexDirectClientTest {
	
	private YandexDirect direct = new YandexDirectImpl(AuthTokens.fake());

	@Test
	public void shouldCallSimpleMethodToGetCampaigns() {
		Campaigns campaigns = direct.campaigns();
		assertNotNull(campaigns);
	}

}
