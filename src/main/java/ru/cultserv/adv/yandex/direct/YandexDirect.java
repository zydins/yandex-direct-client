package ru.cultserv.adv.yandex.direct;

import ru.cultserv.adv.yandex.direct.methods.Banners;
import ru.cultserv.adv.yandex.direct.methods.Campaigns;

public interface YandexDirect {

	/**
	 * Доступ к методам для работы с рекламными кампаниями
	 * 
	 * @return
	 */
	Campaigns campaigns();
	
	/**
	 * Доступ к методам для работы с объявлениями
	 * 
	 * @return
	 */
	Banners banners();

}
