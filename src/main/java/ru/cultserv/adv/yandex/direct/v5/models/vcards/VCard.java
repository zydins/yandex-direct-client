package ru.cultserv.adv.yandex.direct.v5.models.vcards;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VCard {

	@JsonProperty("Id")
	public Long id;

	@JsonProperty("CampaignId")
	public Long campaignId;

	/**
	 * Страна.
	 */
	@JsonProperty("Country")
	public String country;

	/**
	 * Город.
	 */
	@JsonProperty("City")
	public String city;

	/**
	 * <p>
	 * Режим работы организации или режим обслуживания клиентов.
	 * Задается как строка, в которой указан диапазон дней недели и рабочих часов с точностью до минут.
	 * Дни недели обозначаются цифрами от 0 до 6, где 0 — понедельник, 6 — воскресение. Формат строки:
	 * “день_с;день_по;час_с;минуты_с;час_до;мин_до“
	 *
	 * <p>
	 * Например, строка “0;4;10;0;18;0“ задает такой режим:<br>
	 * 0;4 — с понедельника по пятницу;<br>
	 * 10;0 — с 10 часов 0 минут;<br>
	 * 18;0 — до 18 часов 0 минут.
	 *
	 * <p>
	 * Режим может состоять из нескольких строк указанного формата, например: “0;4;10;0;18;0;5;6;11;0;16;0“.
	 * Здесь в дополнение к предыдущему примеру задан режим:<br>
	 * 5;6 — с субботы по воскресение;<br>
	 * 11;0 — с 11 часов 0 минут;<br>
	 * 16;0 — до 16 часов 0 минут.
	 */
	@JsonProperty("WorkTime")
	public String workTime;

	@JsonProperty("Phone")
	public Phone phone;

	/**
	 * Улица.
	 */
	@JsonProperty("Street")
	public String street;

	/**
	 * Номер дома.
	 */
	@JsonProperty("House")
	public String house;

	/**
	 * Номер строения или корпуса.
	 */
	@JsonProperty("Building")
	public String building;

	/**
	 * Номер квартиры или офиса.
	 */
	@JsonProperty("Apartment")
	public String apartment;


	@JsonProperty("InstantMessenger")
	public Messenger messenger;

	/**
	 * Название организации.
	 */
	@JsonProperty("CompanyName")
	public String companyName;

	/**
	 * Дополнительная информация о рекламируемом товаре или услуге.
	 */
	@JsonProperty("ExtraMessage")
	public String extraMessage;

	/**
	 * Адрес электронной почты.
	 */
	@JsonProperty("ContactEmail")
	public String contactEmail;

	/**
	 * Код ОГРН для юридических лиц.
	 */
	@JsonProperty("Ogrn")
	public String ogrn;

	/**
	 * Объект MapPoint, задающий координаты местоположения клиента.
	 * По этим координатам ставится метка на карте.
	 * Если не заданы, метка ставится по указанному адресу клиента.
	 */
	@JsonProperty("PointOnMap")
	public MapPoint point_on_map;

	/**
	 * Контактное лицо.
	 */
	@JsonProperty("ContactPerson")
	public String contactPerson;

	public static class MapPoint {
		/**
		 * Долгота точки.
		 */
		public float X;

		/**
		 * Широта точки.
		 */
		public float Y;

		/**
		 * Долгота левого нижнего угла области на карте.
		 * Может принимать значение от -180 до 180.
		 */
		public float X1;

		/**
		 * Широта левого нижнего угла области на карте.
		 * Может принимать значение от -90 до 90.
		 */
		public float Y1;
		
		/**
		 * Долгота правого верхнего угла области на карте.
		 * Может принимать значение от -180 до 180.
		 */
		public float X2;
		
		/**
		 * Широта правого верхнего угла области на карте.
		 * Может принимать значение от -90 до 90.
		 */
		public float Y2;
	}

	public static class Phone {
		/**
		 * Телефонный код страны.
		 * Значение должно начинаться со знака «+», например «+7» для России.
		 * Исключение: если в поле CityCode указано значение «800», то в поле CountryCode допустимо значение «8».
		 */
		@JsonProperty("CountryCode")
		public String countryCode;

		/**
		 * Телефонный код города.
		 */
		@JsonProperty("CityCode")
		public String cityCode;

		/**
		 * Телефонный номер для связи.
		 */
		@JsonProperty("PhoneNumber")
		public String number;

		/**
		 * Добавочный телефонный номер для соединения через офисную АТС.
		 */
		@JsonProperty("Extention")
		public String extention;

	}

	public enum Field {
		
	}
}
