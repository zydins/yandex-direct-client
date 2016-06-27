package ru.cultserv.adv.yandex.direct.v5.impl;

import com.ning.http.client.AsyncHttpClientConfig;
import ru.cultserv.adv.yandex.direct.v5.AuthToken;
import ru.cultserv.adv.yandex.direct.v5.YandexDirect;
import ru.cultserv.adv.yandex.direct.v5.keystore.KeyStoreBuilder;
import ru.cultserv.adv.yandex.direct.v5.methods.*;
import ru.cultserv.adv.yandex.direct.v5.methods.impl.ProxyBuilder;
import ru.cultserv.adv.yandex.direct.v5.util.AsyncClientFactory;
import ru.cultserv.adv.yandex.direct.v5.util.requests.YandexDirectMethodCaller;

import javax.net.ssl.SSLContext;

public class YandexDirectImpl implements YandexDirect {

	private YandexDirectMethodCaller caller;

	protected YandexDirectImpl(YandexDirectMethodCaller caller) {
		this.caller = caller;
	}

	@Deprecated
    public YandexDirectImpl(KeyStoreBuilder.Builder builder) {
        this(builder.build());
    }

	@Deprecated
    public YandexDirectImpl(SSLContext context) {
        AsyncHttpClientConfig.Builder builder = new AsyncHttpClientConfig.Builder();
        builder.setSSLContext(context);
        AsyncHttpClientConfig config = builder.build();
        this.caller = YandexDirectMethodCaller.prepared(new AuthToken(null), AsyncClientFactory.createHttpClient(config));
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
	public Dictionaries dictionaries() {
		return create(Dictionaries.class);
	}

	@Override
	public Sitelinks sitelinks() {
		return create(Sitelinks.class);
	}

	@Override
	public VCards vcards() {
		return create(VCards.class);
	}

    private <T> T create(Class<T> targetInterface) {
		return ProxyBuilder.create(targetInterface, caller);
	}

	@Override
	public void close() {
		caller.close();
	}
}
