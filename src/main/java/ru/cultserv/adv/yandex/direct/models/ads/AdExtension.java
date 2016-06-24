package ru.cultserv.adv.yandex.direct.models.ads;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Sergey Zudin
 * @since 24.06.16.
 */
public class AdExtension {

    @JsonProperty("AdExtensionId")
    public Long id;
    @JsonProperty("Type")
    public Type type;

    public enum Type {
        CALLOUT,
        UNKNOWN
    }
}
