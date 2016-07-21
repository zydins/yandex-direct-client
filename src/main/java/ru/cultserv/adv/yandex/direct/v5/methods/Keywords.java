package ru.cultserv.adv.yandex.direct.v5.methods;

import ru.cultserv.adv.yandex.direct.v5.filters.KeywordRequest;
import ru.cultserv.adv.yandex.direct.v5.models.OperationResult;
import ru.cultserv.adv.yandex.direct.v5.models.keywords.KeywordInfo;

import java.util.List;

/**
 * @author Sergey Zudin
 * @since 27.06.16.
 */
public interface Keywords {

    @WithConverter(entity = "Keywords", flatten = true)
    List<OperationResult> add(List<KeywordInfo> keywords);

    @WithConverter(converter = ParamConverter.SINGLE_PARAM_CONVERTER, flatten = true)
    List<KeywordInfo> get(KeywordRequest criteria);

    @WithConverter(entity = {"SelectionCriteria", "Ids"}, flatten = true)
    List<OperationResult> resume(List<Long> ids);

    @WithConverter(entity = {"SelectionCriteria", "Ids"}, flatten = true)
    List<OperationResult> suspend(List<Long> ids);

    @WithConverter(entity = {"SelectionCriteria", "Ids"}, flatten = true)
    List<OperationResult> delete(List<Long> ids);

    @WithConverter(entity = "Campaigns", flatten = true)
    List<OperationResult> update(List<KeywordInfo> keywords);

}
