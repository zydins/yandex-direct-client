package ru.cultserv.adv.yandex.direct.v5.models.wordstat;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Alexandr Kolosov
 * @since 29.07.2014
 */
@Deprecated
public class WordstatItem {

    @JsonProperty("Phrase")
    public String phrase;

    @JsonProperty("Shows")
    public int shows;

}
