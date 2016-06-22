package ru.cultserv.adv.yandex.direct.methods;

import ru.cultserv.adv.yandex.direct.filters.CampaignRequest;
import ru.cultserv.adv.yandex.direct.models.campain.AddCampaignResult;
import ru.cultserv.adv.yandex.direct.models.campain.CampaignGetResult;
import ru.cultserv.adv.yandex.direct.models.campain.CampaignInfo;

import java.util.List;

public interface Campaigns {

	@DirectMethod(MethodName.CreateOrUpdateCampaign)
	List<AddCampaignResult> add(List<CampaignInfo> campaigns);

//	@DirectMethod(MethodName.GetCampaignsList)
	@WithConverter(converter = ParamConverter.SINGLE_PARAM_CONVERTER)
	CampaignGetResult get(CampaignRequest criteria);

//	delete();


//	resume();
//
//	suspend();
//
//	archive();
//
//	unarchive();
//
//	update();

//	@DirectMethod(MethodName.CreateOrUpdateCampaign)
//	Long create(CampaignInfo campaign);
//
//	@DirectMethod(MethodName.CreateOrUpdateCampaign)
//	void update(CampaignInfo campaign);
//
//	@DirectMethod(MethodName.StopCampaign)
//	void stop(Long campaign_id);
//
//	@DirectMethod(MethodName.ResumeCampaign)
//	void resume(Long campaign_id);
//
//	@DirectMethod(MethodName.DeleteCampaign)
//	void delete(Long campaign_id);
//
//	@DirectMethod(MethodName.ArchiveCampaign)
//	void archive(Long campaign_id);
//
//	@DirectMethod(MethodName.UnArchiveCampaign)
//	void unArchive(Long campaign_id);
//
//	@DirectMethod(MethodName.GetCampaignsList)
//	List<CampaignShortInfo> list(String... logins);
//
//	/**
//	 * Простой фильтр по списку компаний
//	 */
//	@DirectMethod(MethodName.GetCampaignsListFilter)
//	List<CampaignShortInfo> list(CampaignsFilterParam filtering_param);
//
//	/**
//	 * Возвращает параметры кампаний.
//	 *
//	 * Денежные значения в условных единицах (у. е.).
//	 * Если кампания ведется в реальной валюте, возвращаемые значения конвертируются из валюты кампании в у. е.
//	 */
//	@DirectMethod(MethodName.GetCampaignParams)
//	CampaignInfo params(long campaign_id);
//
//	@DirectMethod(MethodName.GetBannersStat)
//	BannersStat bannersStat(BannersStatParam param);
//
//	@DirectMethod(MethodName.GetSummaryStat)
//	List<SummaryStat> summaryStat(SummaryStatParam param);

}
