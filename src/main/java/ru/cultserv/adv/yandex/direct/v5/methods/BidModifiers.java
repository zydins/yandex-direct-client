package ru.cultserv.adv.yandex.direct.v5.methods;

import ru.cultserv.adv.yandex.direct.v5.filters.BidModifiersRequest;
import ru.cultserv.adv.yandex.direct.v5.models.OperationResult;
import ru.cultserv.adv.yandex.direct.v5.models.bids.BidModifier;
import ru.cultserv.adv.yandex.direct.v5.models.bids.BidModifierToggle;
import ru.cultserv.adv.yandex.direct.v5.models.bids.BidModifierUpdate;
import ru.cultserv.adv.yandex.direct.v5.models.bids.ToggleResults;

import java.util.List;

/**
 * @author Sergey Zudin
 * @since 21.07.16.
 */
public interface BidModifiers {

    @WithConverter(entity = "BidModifiers", flatten = true)
    List<OperationResult> add(List<BidModifier> modifiers);

    @WithConverter(converter = ParamConverter.SINGLE_PARAM_CONVERTER, flatten = true)
    List<BidModifier> get(BidModifiersRequest criteria);

    @WithConverter(entity = {"SelectionCriteria", "Ids"}, flatten = true)
    List<OperationResult> delete(List<Long> ids);

    @WithConverter(entity = "BidModifiers", flatten = true)
    List<OperationResult> set(List<BidModifierUpdate> items);

    @WithConverter(entity = "BidModifierToggleItems", flatten = true)
    List<ToggleResults> toggle(List<BidModifierToggle> items);

}
