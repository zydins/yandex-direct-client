package ru.cultserv.adv.yandex.direct.models.campain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Sergey Zudin
 * @since 16.06.16.
 */
public class Notification {

    @JsonProperty("SmsSettings")
    public SmsNotificationSettings sms;
    @JsonProperty("EmailSettings")
    public EmailNotificationSettings email;

}
