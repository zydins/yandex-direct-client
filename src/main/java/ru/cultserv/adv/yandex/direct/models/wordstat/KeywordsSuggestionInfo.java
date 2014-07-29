package ru.cultserv.adv.yandex.direct.models.wordstat;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Alexandr Kolosov
 * @since 29.07.2014
 */
public class KeywordsSuggestionInfo {

    @JsonProperty("Keywords")
    public String[] keywords;

    public static KeywordsSuggestionInfo of(String ... keywords) {
        KeywordsSuggestionInfo info = new KeywordsSuggestionInfo();
        info.keywords = keywords;
        return info;
    }
}
