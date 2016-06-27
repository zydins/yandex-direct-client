package ru.cultserv.adv.yandex.direct.v5.models.util;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Sergey Zudin
 * @since 16.06.16.
 */
public class ExceptionNotification {

    @JsonProperty("Code")
    public int code;
    @JsonProperty("Message")
    public String message;
    @JsonProperty("Details")
    public String details;

}
