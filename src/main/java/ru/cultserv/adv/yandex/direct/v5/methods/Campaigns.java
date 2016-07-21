package ru.cultserv.adv.yandex.direct.v5.methods;

import ru.cultserv.adv.yandex.direct.v5.filters.CampaignRequest;
import ru.cultserv.adv.yandex.direct.v5.models.OperationResult;
import ru.cultserv.adv.yandex.direct.v5.models.campain.CampaignGetResult;
import ru.cultserv.adv.yandex.direct.v5.models.campain.CampaignInfo;

import java.util.List;

public interface Campaigns {

	@WithConverter(entity = "Campaigns", flatten = true)
	List<OperationResult> add(List<CampaignInfo> campaigns);

	@WithConverter(converter = ParamConverter.SINGLE_PARAM_CONVERTER, directName = "get")
	CampaignGetResult fullGet(CampaignRequest criteria);

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
