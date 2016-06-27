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
@Deprecated
public interface WordStats {

    int create(NewWordstatReportInfo info);

    int delete(int report_id);

    List<WordstatReportInfo> get(int report_id);

    List<WordstatReportStatusInfo> get();

    List<String> suggests(KeywordsSuggestionInfo suggestion);

}
