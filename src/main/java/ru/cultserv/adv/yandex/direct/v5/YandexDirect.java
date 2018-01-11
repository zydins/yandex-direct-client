package ru.cultserv.adv.yandex.direct.v5;

import ru.cultserv.adv.yandex.direct.v5.methods.*;
import ru.cultserv.adv.yandex.direct.v5.models.Unit;
import ru.cultserv.adv.yandex.direct.v5.models.bids.BidModifier;
import ru.cultserv.adv.yandex.direct.v5.util.ApiResponseCallback;

import java.io.Closeable;
import java.util.List;

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

	Reports reports();

	Unit apiPoints();

	int responseCode();

	List<String> getHeader(String name);

	void addCallback(final ApiResponseCallback callback);

	void removeCallback(final ApiResponseCallback callback);

	@Override
	void close();
}
