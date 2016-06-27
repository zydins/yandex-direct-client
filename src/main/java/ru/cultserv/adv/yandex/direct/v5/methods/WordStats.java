package ru.cultserv.adv.yandex.direct.v5.methods;

import ru.cultserv.adv.yandex.direct.v5.models.wordstat.KeywordsSuggestionInfo;
import ru.cultserv.adv.yandex.direct.v5.models.wordstat.NewWordstatReportInfo;
import ru.cultserv.adv.yandex.direct.v5.models.wordstat.WordstatReportInfo;
import ru.cultserv.adv.yandex.direct.v5.models.wordstat.WordstatReportStatusInfo;

import java.util.List;

/**
 * @author Alexandr Kolosov
 * @since 29.07.2014
 */
public interface WordStats {

    @DirectMethod(MethodName.CreateNewWordstatReport)
    int create(NewWordstatReportInfo info);

    @DirectMethod(MethodName.DeleteWordstatReport)
    int delete(int report_id);

    @DirectMethod(MethodName.GetWordstatReport)
    List<WordstatReportInfo> get(int report_id);

    @DirectMethod(MethodName.GetWordstatReportList)
    List<WordstatReportStatusInfo> get();

    @DirectMethod(MethodName.GetKeywordsSuggestion)
    List<String> suggests(KeywordsSuggestionInfo suggestion);

}
