package ru.cultserv.adv.yandex.direct.v5.models.dict;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.cultserv.adv.yandex.direct.v5.models.Currency;

/**
 * @author Sergey Zudin
 * @since 27.06.16.
 */
public class CurrencyInfo {

    @JsonProperty("Currency")
    public Currency currency;
    @JsonProperty("Properties")
    public Properties properties;

    public static class Properties {
        @JsonProperty("Name")
        public String name;
        @JsonProperty("Value")
        public String value;
    }

}
