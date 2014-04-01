package ru.cultserv.adv.yandex.direct.methods;

import java.util.List;

import ru.cultserv.adv.yandex.direct.filters.CampaignsFilterParam;
import ru.cultserv.adv.yandex.direct.models.CampaignInfo;
import ru.cultserv.adv.yandex.direct.models.CampaignShortInfo;
import ru.cultserv.adv.yandex.direct.models.Currency;

public interface Campaigns {

	Long create(CampaignInfo campaign);
	
	void update(CampaignInfo campaign);
	
	void stop(Long campaign_id);
	
	void resume(Long campaign_id);
	
	void delete(Long campaign_id);
	
	void archive(Long campaign_id);
	
	void unArchive(Long campaign_id);
	
	List<CampaignShortInfo> list();
	
	List<CampaignShortInfo> list(String... logins);
	
	/**
	 * Простой фильтр по списку компаний
	 * 
	 * @param filtering_param
	 * @return список кампаний
	 */
	List<CampaignShortInfo> list(CampaignsFilterParam filtering_param);
	
	/**
	 * <p>
	 * Возвращает параметры кампаний.
	 * 
	 * <p>
	 * Денежные значения в условных единицах (у. е.).
	 * Если кампания ведется в реальной валюте, возвращаемые значения конвертируются из валюты кампании в у. е.
	 *  
	 * @param campaign_ids список id кампаний, для которых нужно получить параметры
	 * @return список параметров для кампаний
	 */
	List<CampaignInfo> params(List<Long> campaign_ids);
	
	/**
	 * 
	 * @param campaign_ids
	 * @param currency
	 * @return
	 */
	List<CampaignInfo> params(List<Long> campaign_ids, Currency currency);

}
