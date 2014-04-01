package ru.cultserv.adv.yandex.direct.methods.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.cultserv.adv.util.ApiRequestExecutor;
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
	
	private AuthToken token;
	private ApiRequestExecutor request_executor = new YandexRequestExecutor();
	
	public CampaignsImpl(AuthToken token) {
		this.token = token;
	}

	@Override
	public Long create(CampaignInfo campaign) {
		return new YandexDirectMethodCaller(token)
				.call(MethodName.CreateOrUpdateCampaign, campaign, Long.class, request_executor);
	}

	@Override
	public void update(CampaignInfo campaign) {
		new YandexDirectMethodCaller(token)
			.call(MethodName.CreateOrUpdateCampaign, campaign, Void.class, request_executor);
	}

	@Override
	public void stop(Long campaign_id) {
		new YandexDirectMethodCaller(token)
			.call(MethodName.StopCampaign, campaign_id, Void.class, request_executor);
	}

	@Override
	public void resume(Long campaign_id) {
		new YandexDirectMethodCaller(token)
			.call(MethodName.ResumeCampaign, campaign_id, Void.class, request_executor);
	}

	@Override
	public void delete(Long campaign_id) {
		new YandexDirectMethodCaller(token)
			.call(MethodName.DeleteCampaign, campaign_id, Void.class, request_executor);
	}

	@Override
	public void archive(Long campaign_id) {
		new YandexDirectMethodCaller(token)
			.call(MethodName.ArchiveCampaign, campaign_id, Void.class, request_executor);
	}

	@Override
	public void unArchive(Long campaign_id) {
		new YandexDirectMethodCaller(token)
			.call(MethodName.UnArchiveCampaign, campaign_id, Void.class, request_executor);
	}

	@Override
	public List<CampaignShortInfo> list() {
		return list(new String[] {});
	}
	
	@Override
	public List<CampaignShortInfo> list(String... logins) {
		TypeReference<List<CampaignShortInfo>> return_type = new TypeReference<List<CampaignShortInfo>>() {};
		
		return new YandexDirectMethodCaller(token)
				.call(MethodName.GetCampaignsList, logins, return_type, request_executor);
	}

	@Override
	public List<CampaignShortInfo> list(CampaignsFilterParam filtering_param) {
		TypeReference<List<CampaignShortInfo>> return_type = new TypeReference<List<CampaignShortInfo>>() {};
		
		return new YandexDirectMethodCaller(token)
				.call(MethodName.GetCampaignsListFilter, filtering_param, return_type, request_executor);
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
		
		return new YandexDirectMethodCaller(token)
			.call(MethodName.GetCampaignsParams, param, return_type, request_executor);
	}

}
