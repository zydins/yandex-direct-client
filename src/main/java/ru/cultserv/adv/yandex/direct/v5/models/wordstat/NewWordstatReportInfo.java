package ru.cultserv.adv.yandex.direct.v5.models.wordstat;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Alexandr Kolosov
 * @since 29.07.2014
 */
public class NewWordstatReportInfo {

    @JsonProperty("Phrases")
    String[] phrases;

    @JsonProperty("GeoID")
    Integer[] regions;

    public static class Builder {

        private NewWordstatReportInfo info;

        public Builder() {
            this.info = new NewWordstatReportInfo();
        }

        public Builder phrases(List<String> phrases) {
            this.info.phrases = phrases.toArray(new String[0]);
            return this;
        }

        public Builder phrases(String ... phrases) {
            this.info.phrases = phrases;
            return this;
        }

        public Builder region(Integer ... regions) {
            this.info.regions = regions;
            return this;
        }

        public NewWordstatReportInfo build() {
            return this.info;
        }
    }
}
