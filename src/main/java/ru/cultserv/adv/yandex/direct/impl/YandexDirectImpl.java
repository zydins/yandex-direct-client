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

public class YandexDirectImpl implements YandexDirect {
	
	private AuthToken token;
	
	public YandexDirectImpl(AuthToken token) {
		this.token = token;
	}

	@Override
	public Campaigns campaigns() {
		return new CampaignsImpl(token);
	}

	@Override
	public Banners banners() {
		return new BannersImpl(token);
	}

	@Override
	public Vocabularies vocabularies() {
		return new VocabulariesImpl(token);
	}

	@Override
	public Utils utils() {
		return new UtilsImpl(token);
	}
}
