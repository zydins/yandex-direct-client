package ru.cultserv.adv.yandex.direct.v5.models.ads;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.cultserv.adv.yandex.direct.v5.models.ModerationStatus;
import ru.cultserv.adv.yandex.direct.v5.models.util.StatusBoolean;

/**
 * @author Sergey Zudin
 * @since 24.06.16.
 */
public class AdExtension {

    @JsonProperty("Id")
    public Long id;

    @JsonProperty("Associated")
    public StatusBoolean isAssosiated;

    @JsonProperty("Type")
    public Type type;

    /*
    Start fields for creating
     */

    @JsonProperty("Callout")
    public Callout callout;

    /*
    End fields for creating
     */

    @JsonProperty("State")
    public State state;

    @JsonProperty("Status")
    public ModerationStatus moderationStatus;

    @JsonProperty("StatusClarification")
    public String statusClarification;

    public static class Callout {
        @JsonProperty("CalloutText")
        public String text;

        public Callout() {
        }

        public Callout(String text) {
            this.text = text;
        }

        public enum Field {
            CalloutText
        }

    }

    public enum Field {
        Id,
        Type,
        Status,
        StatusClarification,
        Associated
    }

    public enum Type {
        CALLOUT,
        UNKNOWN
    }

    public enum State {
        ON,
        DELETED,
        UNKNOWN;
    }
}
