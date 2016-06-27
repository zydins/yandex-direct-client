package ru.cultserv.adv.yandex.direct.v5.models.vcards;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Sergey Zudin
 * @since 27.06.16.
 */
public class Messenger {

    /**
     * Тип сети мгновенного обмена сообщениями — icq, jabber, skype, mail_agent.
     */
    @JsonProperty("MessengerClient")
    public MessengerClient client;

    /**
     * Логин в сети мгновенного обмена сообщениями.
     */
    @JsonProperty("MessengerLogin")
    public String login;

    public enum MessengerClient {
        icq,
        jabber,
        skype,
        mail_agent
    }

}
