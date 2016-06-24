package ru.cultserv.adv.yandex.direct.methods;

import ru.cultserv.adv.yandex.direct.filters.AdRequest;
import ru.cultserv.adv.yandex.direct.models.OperationResult;
import ru.cultserv.adv.yandex.direct.models.ads.AdInfo;

import java.util.List;

public interface Ads {

    @WithConverter(entity = "Ads", flatten = true)
    List<OperationResult> add(List<AdInfo> ads);

    @WithConverter(entity = {"SelectionCriteria", "Ids"}, flatten = true)
    List<OperationResult> archive();

    @WithConverter(entity = {"SelectionCriteria", "Ids"}, flatten = true)
    List<OperationResult> delete();

    @WithConverter(converter = ParamConverter.SINGLE_PARAM_CONVERTER, flatten = true)
    List<AdInfo> get(AdRequest request);

    @WithConverter(entity = {"SelectionCriteria", "Ids"}, flatten = true)
    List<OperationResult> moderate();

    @WithConverter(entity = {"SelectionCriteria", "Ids"}, flatten = true)
    List<OperationResult> resume();

    @WithConverter(entity = {"SelectionCriteria", "Ids"}, flatten = true)
    List<OperationResult> suspend();

    @WithConverter(entity = {"SelectionCriteria", "Ids"}, flatten = true)
    List<OperationResult> unarchive();

    @WithConverter(entity = "Ads", flatten = true)
    List<OperationResult> update(List<AdInfo> ads);

}
