package ru.cultserv.adv.yandex.direct.v5;

import ru.cultserv.adv.yandex.direct.v5.methods.*;
import ru.cultserv.adv.yandex.direct.v5.models.bids.BidModifier;

import java.io.Closeable;

public interface YandexDirect extends Closeable {

	Campaigns campaigns();

	Ads ads();

	AdGroups adGroups();

	AdExtensions adExtensions();

	Bids bids();

	BidModifier bidModifier();

	Changes changes();

	Dictionaries dictionaries();

//	DynamicTextAdTargets dynamicTextAdTargets();

	Keywords keywords();

	Sitelinks sitelinks();

	VCards vcards();

	Integer apiPoints();

	@Override
	void close();
}
