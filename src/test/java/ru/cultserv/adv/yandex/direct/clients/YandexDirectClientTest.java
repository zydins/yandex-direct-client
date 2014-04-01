package ru.cultserv.adv.yandex.direct.clients;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ru.cultserv.adv.yandex.direct.YandexDirect;
import ru.cultserv.adv.yandex.direct.methods.Campaigns;
import ru.cultserv.adv.yandex.direct.models.CampaignShortInfo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public abstract class YandexDirectClientTest {
	
	private YandexDirect direct;
	
	@Before
	public void setUp() {
		direct = directInstance();
	}
	
	public abstract YandexDirect directInstance();

	@Test
	public void shouldCallSimpleMethodToGetCampaigns() {
		Campaigns campaigns = direct.campaigns();
		assertNotNull(campaigns);
	}
	
	@Test
	public void shouldGetCampaignsList() {
		List<CampaignShortInfo> campaigns = direct.campaigns().list();
		
		assertNotNull(campaigns);
		assertTrue(!campaigns.isEmpty());
		
		CampaignShortInfo campaign = campaigns.get(0);
		assertNotNull(campaign);
	}
	
	@Test
	public void shouldGetCampaignsListForLogins() {
		List<CampaignShortInfo> campaigns = direct.campaigns().list("xolvo");
		
		assertNotNull(campaigns);
	}

}
