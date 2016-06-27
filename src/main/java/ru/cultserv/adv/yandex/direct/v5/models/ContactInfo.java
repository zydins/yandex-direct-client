package ru.cultserv.adv.yandex.direct.v5.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContactInfo {

	/**
	 * Контактное лицо.
	 */
	@JsonProperty("ContactPerson")
	public String contact_person;
	
	/**
	 * Страна.
	 */
	@JsonProperty("Country")
	public String country;
	
	/**
	 * Телефонный код страны.
	 * Значение должно начинаться со знака «+», например «+7» для России.
	 * Исключение: если в поле CityCode указано значение «800», то в поле CountryCode допустимо значение «8».
	 */
	@JsonProperty("CountryCode")
	public String country_code;
	
	/**
	 * Город.
	 */
	@JsonProperty("City")
	public String city;
	
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
	@JsonProperty("Build")
	public String build;
	
	/**
	 * Номер квартиры или офиса.
	 */
	@JsonProperty("Apart")
	public String apart;
	
	/**
	 * Телефонный код города.
	 */
	@JsonProperty("CityCode")
	public String city_code;
	
	/**
	 * Телефонный номер для связи.
	 */
	@JsonProperty("Phone")
	public String phone;
	
	/**
	 * Добавочный телефонный номер для соединения через офисную АТС.
	 */
	@JsonProperty("PhoneExt")
	public String PhoneExt;
	
	/**
	 * Название организации.
	 */
	@JsonProperty("CompanyName")
	public String company_name;
	
	/**
	 * Тип сети мгновенного обмена сообщениями — icq, jabber, skype, mail_agent.
	 */
	@JsonProperty("IMClient")
	public IMClient im_client;
	
	/**
	 * Логин в сети мгновенного обмена сообщениями.
	 */
	@JsonProperty("IMLogin")
	public String im_login;
	
	/**
	 * Дополнительная информация о рекламируемом товаре или услуге.
	 */
	@JsonProperty("ExtraMessage")
	public String extra_message;
	
	/**
	 * Адрес электронной почты.
	 */
	@JsonProperty("ContactEmail")
	public String contact_email;
	
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
	public String work_time;
	
	/**
	 * Код ОГРН для юридических лиц.
	 */
	@JsonProperty("OGRN")
	public String ogrn;
	
	/**
	 * Объект MapPoint, задающий координаты местоположения клиента.
	 * По этим координатам ставится метка на карте.
	 * Если не заданы, метка ставится по указанному адресу клиента.
	 */
	@JsonProperty("PointOnMap")
	public MapPoint point_on_map;
	
	public enum IMClient {
		icq,
		jabber,
		skype,
		mail_agent
	}
	
	public static class MapPoint {
		/**
		 * Долгота точки.
		 */
		public float x;
		
		/**
		 * Широта точки.
		 */
		public float y;
		
		/**
		 * Долгота левого нижнего угла области на карте.
		 * Может принимать значение от -180 до 180.
		 */
		public float x1;
		
		/**
		 * Широта левого нижнего угла области на карте.
		 * Может принимать значение от -90 до 90.
		 */
		public float y1;
		
		/**
		 * Долгота правого верхнего угла области на карте.
		 * Может принимать значение от -180 до 180.
		 */
		public float x2;
		
		/**
		 * Широта правого верхнего угла области на карте.
		 * Может принимать значение от -90 до 90.
		 */
		public float y2;
	}

}
