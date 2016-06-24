package ru.cultserv.adv.yandex.direct.methods;

import ru.cultserv.adv.yandex.direct.filters.AdExtensionRequest;
import ru.cultserv.adv.yandex.direct.models.OperationResult;
import ru.cultserv.adv.yandex.direct.models.ads.AdExtension;

import java.util.List;

/**
 * @author Sergey Zudin
 * @since 24.06.16.
 */
public interface AdExtensions {

    @WithConverter(converter = ParamConverter.SINGLE_PARAM_CONVERTER, flatten = true)
    List<AdExtension> get(AdExtensionRequest request);

    @WithConverter(entity = {"SelectionCriteria", "Ids"}, flatten = true)
    List<OperationResult> delete(List<Long> ids);

    @WithConverter(entity = {"SelectionCriteria", "Ids"}, flatten = true)
    List<OperationResult> add(List<AdExtension> extensions);

}
