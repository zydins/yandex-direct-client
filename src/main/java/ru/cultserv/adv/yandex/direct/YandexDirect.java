package ru.cultserv.adv.yandex.direct;

import ru.cultserv.adv.yandex.direct.methods.Banners;
import ru.cultserv.adv.yandex.direct.methods.Campaigns;
import ru.cultserv.adv.yandex.direct.methods.Utils;
import ru.cultserv.adv.yandex.direct.methods.Vocabularies;

public interface YandexDirect {

	/**
	 * Доступ к методам для работы с рекламными кампаниями
	 */
	Campaigns campaigns();
	
	/**
	 * Доступ к методам для работы с объявлениями
	 */
	Banners banners();

	Vocabularies vocabularies();

	Utils utils();

}
