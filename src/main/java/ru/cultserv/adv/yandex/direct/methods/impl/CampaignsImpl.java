package ru.cultserv.adv.yandex.direct.methods.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.cultserv.adv.yandex.direct.AuthToken;
import ru.cultserv.adv.yandex.direct.filters.CampaignsFilterParam;
import ru.cultserv.adv.yandex.direct.methods.Campaigns;
import ru.cultserv.adv.yandex.direct.methods.MethodName;
import ru.cultserv.adv.yandex.direct.models.CampaignInfo;
import ru.cultserv.adv.yandex.direct.models.CampaignShortInfo;
import ru.cultserv.adv.yandex.direct.models.Currency;
import ru.cultserv.adv.yandex.direct.util.requests.YandexDirectMethodCaller;
import ru.cultserv.adv.yandex.direct.util.requests.YandexRequestExecutor;

import com.fasterxml.jackson.core.type.TypeReference;

public class CampaignsImpl implements Campaigns {
	
	private final YandexDirectMethodCaller caller;
	
	public CampaignsImpl(AuthToken token) {
		this.caller = new YandexDirectMethodCaller(token, new YandexRequestExecutor());
	}

	@Override
	public Long create(CampaignInfo campaign) {
		return caller.call(MethodName.CreateOrUpdateCampaign, campaign, Long.class);
	}

	@Override
	public void update(CampaignInfo campaign) {
		caller.call(MethodName.CreateOrUpdateCampaign, campaign, Void.class);
	}

	@Override
	public void stop(Long campaign_id) {
		caller.call(MethodName.StopCampaign, campaign_id, Void.class);
	}

	@Override
	public void resume(Long campaign_id) {
		caller.call(MethodName.ResumeCampaign, campaign_id, Void.class);
	}

	@Override
	public void delete(Long campaign_id) {
		caller.call(MethodName.DeleteCampaign, campaign_id, Void.class);
	}

	@Override
	public void archive(Long campaign_id) {
		caller.call(MethodName.ArchiveCampaign, campaign_id, Void.class);
	}

	@Override
	public void unArchive(Long campaign_id) {
		caller.call(MethodName.UnArchiveCampaign, campaign_id, Void.class);
	}

	@Override
	public List<CampaignShortInfo> list() {
		return list(new String[] {});
	}
	
	@Override
	public List<CampaignShortInfo> list(String... logins) {
		TypeReference<List<CampaignShortInfo>> return_type = new TypeReference<List<CampaignShortInfo>>() {};
		
		return caller.call(MethodName.GetCampaignsList, logins, return_type);
	}

	@Override
	public List<CampaignShortInfo> list(CampaignsFilterParam filtering_param) {
		TypeReference<List<CampaignShortInfo>> return_type = new TypeReference<List<CampaignShortInfo>>() {};
		
		return caller.call(MethodName.GetCampaignsListFilter, filtering_param, return_type);
	}

	@Override
	public List<CampaignInfo> params(List<Long> campaign_ids) {
		return params(campaign_ids, null);
	}

	@Override
	public List<CampaignInfo> params(List<Long> campaign_ids, Currency currency) {
		Map<String, Object> param = new HashMap<>();
		param.put("CampaignIDS", campaign_ids);
		
		if(currency != null)
			param.put("Currency", currency);
		
		TypeReference<List<CampaignInfo>> return_type = new TypeReference<List<CampaignInfo>>() {};
		
		return caller.call(MethodName.GetCampaignsParams, param, return_type);
	}

}
