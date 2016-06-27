package ru.cultserv.adv.yandex.direct.v5.methods;

import ru.cultserv.adv.yandex.direct.v5.models.dict.Dictionary;

import java.util.List;

/**
 * @author Sergey Zudin
 * @since 27.06.16.
 */
public interface Dictionaries {

    @WithConverter(entity = "DictionaryNames")
    Dictionary get(List<Dictionary.Type> types);

}
