package ru.cultserv.adv.yandex.direct.v5.models.ads;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Sergey Zudin
 * @since 24.06.16.
 */
public class AdExtensionShort {

    @JsonProperty("AdExtensionId")
    public Long id;
    @JsonProperty("Type")
    public AdExtension.Type type;

}
