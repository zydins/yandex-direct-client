package ru.cultserv.adv.yandex.direct.methods.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.cultserv.adv.yandex.direct.AuthToken;
import ru.cultserv.adv.yandex.direct.filters.BannersFilterParam;
import ru.cultserv.adv.yandex.direct.filters.PhrasesFilterParam;
import ru.cultserv.adv.yandex.direct.methods.Banners;
import ru.cultserv.adv.yandex.direct.methods.MethodName;
import ru.cultserv.adv.yandex.direct.models.BannerInfo;
import ru.cultserv.adv.yandex.direct.models.PhraseInfo;
import ru.cultserv.adv.yandex.direct.util.requests.YandexDirectMethodCaller;
import ru.cultserv.adv.yandex.direct.util.requests.YandexRequestExecutor;

public class BannersImpl implements Banners {

	private final YandexDirectMethodCaller caller;
	
	public BannersImpl(AuthToken token) {
		this.caller = new YandexDirectMethodCaller(token, new YandexRequestExecutor());
	}

	@Override
	public void archive(List<Long> banner_ids) {
		caller.call(MethodName.ArchiveBanners, bannerIdsParam(banner_ids));
	}

	@Override
	public List<Long> create(List<BannerInfo> banners) {
		return createOrUpdate(banners);
	}

	@Override
	public List<Long> update(List<BannerInfo> banners) {
		return createOrUpdate(banners);
	}
	
	private List<Long> createOrUpdate(List<BannerInfo> banners) {
		return caller.call(MethodName.CreateOrUpdateBanners, banners);
	}

	@Override
	public void delete(List<Long> banner_ids) {
		caller.call(MethodName.DeleteBanners, bannerIdsParam(banner_ids));
	}

	@Override
	public List<BannerInfo> get(BannersFilterParam filtering_param) {
		return caller.call(MethodName.GetBanners, filtering_param);
	}

	@Override
	public List<PhraseInfo> phrases(List<Long> banner_ids) {
		return caller.call(MethodName.GetBannerPhrases, banner_ids);
	}

	@Override
	public List<PhraseInfo> phrases(PhrasesFilterParam filtering_param) {
		return caller.call(MethodName.GetBannerPhrasesFilter, filtering_param);
	}

	@Override
	public void moderate(List<Long> banner_ids) {
		caller.call(MethodName.ModerateBanners, bannerIdsParam(banner_ids));
	}

	@Override
	public int moderate(Long campaign_id) {
		return caller.call(MethodName.ModerateBanners, campaignIdParam(campaign_id));
	}

	@Override
	public void resume(List<Long> banner_ids) {
		caller.call(MethodName.ResumeBanners, bannerIdsParam(banner_ids));
	}

	@Override
	public void stop(List<Long> banner_ids) {
		caller.call(MethodName.StopBanners, bannerIdsParam(banner_ids));
	}

	@Override
	public void unArchive(List<Long> banner_ids) {
		caller.call(MethodName.UnArchiveBanners, bannerIdsParam(banner_ids));
	}
	
	private Map<String, Object> bannerIdsParam(List<Long> banner_ids) {
		return param("BannerIDS", banner_ids);
	}
	
	private Map<String, Object> campaignIdParam(Long campaign_id) {
		return param("CampaignID", campaign_id);
	}
	
	private Map<String, Object> param(String name, Object value) {
		Map<String, Object> param = new HashMap<>();
		param.put(name, value);
		
		return param;
	}

}
