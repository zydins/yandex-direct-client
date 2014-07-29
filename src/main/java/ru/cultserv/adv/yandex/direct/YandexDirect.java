package ru.cultserv.adv.yandex.direct;

import ru.cultserv.adv.yandex.direct.methods.*;

public interface YandexDirect {

	/**
	 * Доступ к методам для работы с рекламными кампаниями
	 */
	Campaigns campaigns();
	
	/**
	 * Доступ к методам для работы с объявлениями
	 */
	Banners banners();

	Forecasts forecasts();

	Vocabularies vocabularies();

	Utils utils();

    WordStats wordstats();

}
