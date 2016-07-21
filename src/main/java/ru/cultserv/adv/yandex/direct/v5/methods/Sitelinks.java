package ru.cultserv.adv.yandex.direct.v5.methods;

import ru.cultserv.adv.yandex.direct.v5.filters.SitelinksRequest;
import ru.cultserv.adv.yandex.direct.v5.models.OperationResult;
import ru.cultserv.adv.yandex.direct.v5.models.ads.SitelinksSet;

import java.util.List;

/**
 * @author Sergey Zudin
 * @since 27.06.16.
 */
public interface Sitelinks {

    @WithConverter(entity = "SitelinksSets", flatten = true)
    List<OperationResult> add(List<SitelinksSet> sitelinksSets);

    @WithConverter(entity = {"SelectionCriteria", "Ids"}, flatten = true)
    List<OperationResult> delete(List<Long> ids);

    @WithConverter(converter = ParamConverter.SINGLE_PARAM_CONVERTER, flatten = true)
    List<SitelinksSet> get(SitelinksRequest criteria);

}
