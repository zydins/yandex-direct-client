package ru.cultserv.adv.yandex.direct.v5;

import ru.cultserv.adv.yandex.direct.v5.methods.*;

import java.io.Closeable;

public interface YandexDirect extends Closeable {

	Campaigns campaigns();

	Ads ads();

	AdGroups adGroups();

	AdExtensions adExtensions();

	Bids bids();

//	BidModifier bidModifier();
//
//	Changes changes();
//
	Dictionaries dictionaries();

//	DynamicTextAdTargets dynamicTextAdTargets();
//
//	Keywords keywords();
//
	Sitelinks sitelinks();

	VCards vcards();

	@Override
	void close();
}
