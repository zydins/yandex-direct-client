package ru.cultserv.adv.yandex.direct.methods;

import ru.cultserv.adv.yandex.direct.filters.CampaignRequest;
import ru.cultserv.adv.yandex.direct.models.OperationResult;
import ru.cultserv.adv.yandex.direct.models.campain.CampaignInfo;

import java.util.List;

public interface Campaigns {

	@WithConverter(entity = "Campaigns", flatten = true)
	List<OperationResult> add(List<CampaignInfo> campaigns);

//	@WithConverter(converter = ParamConverter.SINGLE_PARAM_CONVERTER)
//	CampaignGetResult get(CampaignRequest criteria);

	@WithConverter(converter = ParamConverter.SINGLE_PARAM_CONVERTER, flatten = true)
	List<CampaignInfo> get(CampaignRequest criteria);

	@WithConverter(entity = {"SelectionCriteria", "Ids"}, flatten = true)
	List<OperationResult> resume(List<Long> ids);

	@WithConverter(entity = {"SelectionCriteria", "Ids"}, flatten = true)
	List<OperationResult> suspend(List<Long> ids);

	@WithConverter(entity = {"SelectionCriteria", "Ids"}, flatten = true)
	List<OperationResult> archive(List<Long> ids);

	@WithConverter(entity = {"SelectionCriteria", "Ids"}, flatten = true)
	List<OperationResult> unarchive(List<Long> ids);

	@WithConverter(entity = {"SelectionCriteria", "Ids"}, flatten = true)
	List<OperationResult> delete(List<Long> ids);

	@WithConverter(entity = "Campaigns", flatten = true)
	List<OperationResult> update(List<CampaignInfo> campaigns);

}
