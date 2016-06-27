package ru.cultserv.adv.yandex.direct.v5.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

public class SiteLink {

	/**
	 * Текст быстрой ссылки (не более 30 символов).
	 * Суммарная длина текстов всех быстрых ссылок — не более 66 символов.
	 */
	@JsonProperty("Title")
	public String title;
	
	/**
	 * Адрес быстрой ссылки. Протокол «http://» не указывают.
	 * Может содержать подстановочные переменные (см. раздел Ссылки на сайт).
	 * 
	 * Внимание! В быстрых ссылках подстановка значений переменных
	 * {campaign_id}, {ad_id}, {banner_id}, {phrase_id} гарантируется
	 * только при наличии этих же переменных в основной ссылке объявления.
	 */
	@JsonProperty("Href")
	public String href;

	@Override
	public String toString() {
		return Objects.toStringHelper(this)
				.add("title", title)
				.add("href", href)
				.toString();
	}
}
