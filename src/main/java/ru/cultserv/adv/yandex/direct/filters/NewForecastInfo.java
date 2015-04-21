package ru.cultserv.adv.yandex.direct.filters;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Alexandr Kolosov
 * @since 7/3/14
 */
public class NewForecastInfo {

	@JsonProperty("Phrases")
	String[] phrases;

	@JsonProperty("GeoID")
	Integer[] regions;

	public static class Builder {

		private NewForecastInfo info;

		public Builder() {
			this.info = new NewForecastInfo();
		}

		public Builder phrases(String ... phrases) {
			this.info.phrases = phrases;
			return this;
		}

		public Builder region(Integer ... regions) {
			this.info.regions = regions;
			return this;
		}

		public NewForecastInfo build() {
			return this.info;
		}
	}
}
