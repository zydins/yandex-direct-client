package ru.cultserv.adv.yandex.direct.v5.methods;

import ru.cultserv.adv.yandex.direct.v5.filters.ReportRequest;
import ru.cultserv.adv.yandex.direct.v5.models.reports.Report;
import ru.cultserv.adv.yandex.direct.v5.models.util.Format;

import java.util.List;

/**
 * @author Sergey Zudin
 * @since 09.01.18.
 */
public interface Reports {

    @WithConverter(converter = ParamConverter.SINGLE_PARAM_CONVERTER, flatten = true, conversionFrom = Format.TSV)
    List<Report.ReportEntry> get(ReportRequest request);

}
