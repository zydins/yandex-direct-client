package ru.cultserv.adv.yandex.direct.v5.methods;

import org.junit.Test;
import ru.cultserv.adv.yandex.direct.v5.AuthToken;
import ru.cultserv.adv.yandex.direct.v5.YandexDirect;
import ru.cultserv.adv.yandex.direct.v5.filters.ReportRequest;
import ru.cultserv.adv.yandex.direct.v5.impl.YandexDirectFactory;
import ru.cultserv.adv.yandex.direct.v5.models.reports.Report;
import ru.cultserv.adv.yandex.direct.v5.models.reports.ReportField;
import ru.cultserv.adv.yandex.direct.v5.models.util.Operator;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author Sergey Zudin
 * @since 09.01.18.
 */
public class ReportTest {

    public YandexDirect direct = YandexDirectFactory.builder()
            .token(new AuthToken("your-token"))
            .build();
    private Reports reports = direct.reports();

    @Test
    public void testGet() {
        ReportRequest request = new ReportRequest(new ReportRequest.SelectionCriteria(LocalDate.now().minusDays(1), LocalDate.now(),
                Collections.singletonList(new ReportRequest.SelectionCriteria.FilterItem(
                        ReportField.CampaignId, Operator.IN, Arrays.asList("1", "2", "3", "4")))),
                "test" + System.currentTimeMillis());
        request.fields = Arrays.asList(ReportField.Date, ReportField.CampaignId, ReportField.AdId, ReportField.Clicks, ReportField.Impressions, ReportField.Cost);
        List<Report.ReportEntry> entries;
        while (true) {
            entries = reports.get(request);
            if (entries == null) {
                if (direct.responseCode() == 201 || direct.responseCode() == 202) {
                    int retryIn = 5;
                    List<String> header = direct.getHeader("retryIn");
                    if (header != null && !header.isEmpty()) {
                        int secondsToUpdate = Integer.parseInt(header.get(0));
                        retryIn = Math.min(secondsToUpdate, 30);
                    }
                    LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(retryIn));
                }
            } else {
                break;
            }
        }
        System.out.println(entries);
    }

}
