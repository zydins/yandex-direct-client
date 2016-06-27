package ru.cultserv.adv.yandex.direct.v5.methods;

import ru.cultserv.adv.yandex.direct.v5.filters.VCardsRequest;
import ru.cultserv.adv.yandex.direct.v5.models.OperationResult;
import ru.cultserv.adv.yandex.direct.v5.models.vcards.VCard;

import java.util.List;

/**
 * @author Sergey Zudin
 * @since 27.06.16.
 */
public interface VCards {

    @WithConverter(entity = "VCards", flatten = true)
    List<OperationResult> add(List<VCard> groups);

    @WithConverter(entity = {"SelectionCriteria", "Ids"}, flatten = true)
    List<OperationResult> delete(List<Long> ids);

    @WithConverter(converter = ParamConverter.SINGLE_PARAM_CONVERTER, flatten = true)
    List<VCard> get(VCardsRequest criteria);

}
