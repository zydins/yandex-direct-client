package ru.cultserv.adv.yandex.direct.v5.impl;

import ru.cultserv.adv.yandex.direct.v5.AuthToken;
import ru.cultserv.adv.yandex.direct.v5.YandexDirect;
import ru.cultserv.adv.yandex.direct.v5.methods.*;
import ru.cultserv.adv.yandex.direct.v5.methods.impl.ProxyBuilder;
import ru.cultserv.adv.yandex.direct.v5.models.Unit;
import ru.cultserv.adv.yandex.direct.v5.models.bids.BidModifier;
import ru.cultserv.adv.yandex.direct.v5.util.ApiResponseCallback;
import ru.cultserv.adv.yandex.direct.v5.util.requests.YandexDirectMethodCaller;

public class YandexDirectImpl implements YandexDirect {

	private YandexDirectMethodCaller caller;

	protected YandexDirectImpl(YandexDirectMethodCaller caller) {
		this.caller = caller;
	}

	@Deprecated
	public YandexDirectImpl(AuthToken token) {
		this.caller = YandexDirectMethodCaller.defaultCaller(token);
	}

	@Override
	public Campaigns campaigns() {
		return create(Campaigns.class);
	}

	@Override
	public Ads ads() {
		return create(Ads.class);
	}

	@Override
	public AdGroups adGroups() {
		return create(AdGroups.class);
	}

	@Override
	public AdExtensions adExtensions() {
		return create(AdExtensions.class);
	}

	@Override
	public Bids bids() {
		return create(Bids.class);
	}

	@Override
	public BidModifier bidModifier() {
		return create(BidModifier.class);
	}

	@Override
	public Changes changes() {
		return create(Changes.class);
	}

	@Override
	public Dictionaries dictionaries() {
		return create(Dictionaries.class);
	}

	@Override
	public Keywords keywords() {
		return create(Keywords.class);
	}

	@Override
	public Sitelinks sitelinks() {
		return create(Sitelinks.class);
	}

	@Override
	public VCards vcards() {
		return create(VCards.class);
	}

	@Override
	public Unit apiPoints() {
		return caller.apiPoints();
	}

	@Override
	public void addCallback(final ApiResponseCallback callback) {
		caller.addCallback(callback);
	}

	@Override
	public void removeCallback(final ApiResponseCallback callback) {
		caller.removeCallback(callback);
	}

	private <T> T create(Class<T> targetInterface) {
		return ProxyBuilder.create(targetInterface, caller);
	}

	@Override
	public void close() {
		caller.close();
	}
}
