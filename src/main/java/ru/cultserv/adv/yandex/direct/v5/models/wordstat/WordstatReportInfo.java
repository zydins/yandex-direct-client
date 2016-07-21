package ru.cultserv.adv.yandex.direct.v5.models.wordstat;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Alexandr Kolosov
 * @since 29.07.2014
 */
@Deprecated
public class WordstatReportInfo {

    @JsonProperty("Phrase")
    public String phrase;

    @JsonProperty("GeoID")
    public List<Integer> geo_id;

    @JsonProperty("SearchedWith")
    public List<WordstatItem> searched_with;

    @JsonProperty("SearchedAlso")
    public List<WordstatItem> searched_also;

}
