package ru.cultserv.adv.yandex.direct.v5.models.keywords;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Sergey Zudin
 * @since 28.12.16.
 */
public class KeywordGetResult {

    @JsonProperty("LimitedBy")
    public Long limitedBy;
    @JsonProperty("Keywords")
    public List<KeywordInfo> keywords;

}
