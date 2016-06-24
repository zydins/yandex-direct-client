package ru.cultserv.adv.yandex.direct.methods;

import ru.cultserv.adv.yandex.direct.filters.AdGroupRequest;
import ru.cultserv.adv.yandex.direct.models.OperationResult;
import ru.cultserv.adv.yandex.direct.models.ads.AdGroup;

import java.util.List;

/**
 * @author Sergey Zudin
 * @since 24.06.16.
 */
public interface AdGroups {

    @WithConverter(entity = "AdGroups", flatten = true)
    List<OperationResult> add(List<AdGroup> groups);

    @WithConverter(entity = {"SelectionCriteria", "Ids"}, flatten = true)
    List<OperationResult> delete(List<Long> ids);

    @WithConverter(converter = ParamConverter.SINGLE_PARAM_CONVERTER, flatten = true)
    List<AdGroup> get(AdGroupRequest criteria);

    @WithConverter(entity = "AdGroups", flatten = true)
    List<OperationResult> update(List<AdGroup> groups);

}
