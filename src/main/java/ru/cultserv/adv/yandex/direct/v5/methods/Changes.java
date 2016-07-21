package ru.cultserv.adv.yandex.direct.v5.methods;

import org.joda.time.LocalDate;
import ru.cultserv.adv.yandex.direct.v5.models.campain.CampaignUpdates;
import ru.cultserv.adv.yandex.direct.v5.models.dict.DictionaryUpdates;

/**
 * @author Sergey Zudin
 * @since 21.07.16.
 */
public interface Changes {

    @WithConverter(entity = "Timestamp")
    DictionaryUpdates checkDictionaries(LocalDate date);

    @WithConverter(entity = "Timestamp")
    CampaignUpdates checkCampaigns(LocalDate date);

//    @WithConverter(entity = "DictionaryNames")
//    Dictionary check(List<Dictionary.Type> types);

}
