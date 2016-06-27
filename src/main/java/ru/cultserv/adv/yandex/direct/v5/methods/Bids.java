package ru.cultserv.adv.yandex.direct.v5.methods;

import ru.cultserv.adv.yandex.direct.v5.filters.BidRequest;
import ru.cultserv.adv.yandex.direct.v5.models.bids.AutoBidInfo;
import ru.cultserv.adv.yandex.direct.v5.models.bids.BidInfo;
import ru.cultserv.adv.yandex.direct.v5.models.bids.BidSetResult;

import java.util.List;

/**
 * @author Sergey Zudin
 * @since 27.06.16.
 */
public interface Bids {

    @WithConverter(converter = ParamConverter.SINGLE_PARAM_CONVERTER, flatten = true)
    List<BidInfo> get(BidRequest criteria);

    @WithConverter(entity = "Bids", flatten = true)
    List<BidSetResult> set(List<BidInfo> bids);

    @WithConverter(entity = "Bids", flatten = true)
    List<BidSetResult> setAuto(List<AutoBidInfo> bids);

}
