package ru.cultserv.adv.yandex.direct.v5.methods;

import org.junit.Test;
import ru.cultserv.adv.yandex.direct.v5.AuthToken;
import ru.cultserv.adv.yandex.direct.v5.YandexDirect;
import ru.cultserv.adv.yandex.direct.v5.filters.CampaignRequest;
import ru.cultserv.adv.yandex.direct.v5.impl.YandexDirectFactory;
import ru.cultserv.adv.yandex.direct.v5.models.campain.CampaignGetResult;
import ru.cultserv.adv.yandex.direct.v5.models.util.Page;

public class CampaignsTest {

	public YandexDirect direct = YandexDirectFactory.builder().token(new AuthToken("ARZ529YAAswKhCIZBB8bSgWYUaUDeeWYXQ")).build();
	private Campaigns campaigns = direct.campaigns();

	@Test
	public void testGet() {
		CampaignRequest criteria = new CampaignRequest();
		criteria.page = new Page(1l);
		CampaignGetResult campaignGetResult = campaigns.fullGet(criteria);
		System.out.println(campaignGetResult.campaigns);

//		List<CampaignInfo> campaignInfos = campaigns.get(criteria);
//		System.out.println(campaignInfos);
		System.out.println(direct.apiPoints());

//		List<OperationResult> unarchive = campaigns.unarchive(Collections.singletonList(17971081l));
//		System.out.println(unarchive);
	}

//	@Test
//	public void shouldGetCampaignsList() {
//		List<CampaignShortInfo> campaignsInfos = campaigns.list();
//
//		assertNotNull(campaignsInfos);
//		assertTrue(!campaignsInfos.isEmpty());
//
//		CampaignShortInfo campaign = campaignsInfos.get(0);
//		assertNotNull(campaign);
//		assertNotNull(campaign.campaign_id);
//
//		CampaignInfo info = campaigns.params(campaign.campaign_id);
//		assertNotNull(info);
//	}
//
//	@Test
//	public void shouldGetCampaignsListForLogins() {
//		List<CampaignShortInfo> campaignsInfos = campaigns.list("xolvo");
//
//		assertNotNull(campaignsInfos);
//	}
//
//	@Test
//	public void shouldGetCampaignsWithoutArchiveFilter() {
//		int limit = 5;
//
//		CampaignsSelectionCriteria filtering_param =
//			new CampaignsSelectionCriteria.Builder()
//				.withoutArchived()
//				.withRange(limit, 0)
//				.build();
//
//		List<CampaignShortInfo> campaignsInfos = campaigns.list(filtering_param);
//
//		checkNotArchivedCampaigns(campaignsInfos, limit);
//	}
//
//	private void checkNotArchivedCampaigns(List<CampaignShortInfo> campaignsInfos, int limit) {
//		assertNotNull(campaignsInfos);
//		assertTrue(campaignsInfos.size() <= limit);
//
//		for(CampaignShortInfo campaignInfo : campaignsInfos) {
//			assertFalse(campaignInfo.isArchived());
//		}
//	}
//
//	public CampaignShortInfo getFirstNotArchivedCampaign() {
//		CampaignsSelectionCriteria filtering_param =
//			new CampaignsSelectionCriteria.Builder()
//				.withoutArchived()
//				.withLimit(1)
//				.build();
//
//		List<CampaignShortInfo> campaignsInfos = campaigns.list(filtering_param);
//
//		checkNotArchivedCampaigns(campaignsInfos, 1);
//
//		return campaignsInfos.get(0);
//	}

}
