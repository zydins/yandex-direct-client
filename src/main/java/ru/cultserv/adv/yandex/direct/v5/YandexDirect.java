package ru.cultserv.adv.yandex.direct.v5;

import ru.cultserv.adv.yandex.direct.v5.methods.AdExtensions;
import ru.cultserv.adv.yandex.direct.v5.methods.AdGroups;
import ru.cultserv.adv.yandex.direct.v5.methods.Ads;
import ru.cultserv.adv.yandex.direct.v5.methods.Campaigns;

import java.io.Closeable;

public interface YandexDirect extends Closeable {

	Campaigns campaigns();

	Ads ads();

	AdGroups adGroups();

	AdExtensions adExtensions();

//	Bids bids();
//
//	BidModifier bidModifier();
//
//	Changes changes();
//
//	Dictionaries dictionaries();
//
//	DynamicTextAdTargets dynamicTextAdTargets();
//
//	Keywords keywords();
//
//	Sitelinks sitelinks();
//
//	VCards vcards();

	@Override
	void close();
}
