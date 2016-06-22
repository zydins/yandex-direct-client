package ru.cultserv.adv.yandex.direct;

import ru.cultserv.adv.yandex.direct.methods.Ads;
import ru.cultserv.adv.yandex.direct.methods.Campaigns;

import java.io.Closeable;

public interface YandexDirect extends Closeable {

	Campaigns campaigns();

	Ads ads();

//	AdGroups adGroups();
//
//	AdExtentions adExtentions();
//
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
