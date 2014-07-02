package ru.cultserv.adv.yandex.direct.impl;

import ru.cultserv.adv.yandex.direct.AuthToken;
import ru.cultserv.adv.yandex.direct.YandexDirect;
import ru.cultserv.adv.yandex.direct.methods.Banners;
import ru.cultserv.adv.yandex.direct.methods.Campaigns;
import ru.cultserv.adv.yandex.direct.methods.Utils;
import ru.cultserv.adv.yandex.direct.methods.Vocabularies;
import ru.cultserv.adv.yandex.direct.methods.impl.BannersImpl;
import ru.cultserv.adv.yandex.direct.methods.impl.CampaignsImpl;
import ru.cultserv.adv.yandex.direct.methods.impl.UtilsImpl;
import ru.cultserv.adv.yandex.direct.methods.impl.VocabulariesImpl;
import ru.cultserv.adv.yandex.direct.util.requests.YandexDirectMethodCaller;

public class YandexDirectImpl implements YandexDirect {

	private YandexDirectMethodCaller caller;
	
	public YandexDirectImpl(AuthToken token) {
		this.caller = YandexDirectMethodCaller.defaultCaller(token);
	}

	@Override
	public Campaigns campaigns() {
		return new CampaignsImpl(caller);
	}

	@Override
	public Banners banners() {
		return new BannersImpl(caller);
	}

	@Override
	public Vocabularies vocabularies() {
		return new VocabulariesImpl(caller);
	}

	@Override
	public Utils utils() {
		return new UtilsImpl(caller);
	}
}
