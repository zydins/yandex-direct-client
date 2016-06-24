package ru.cultserv.adv.yandex.direct.methods;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;

/**
 * @author Sergey Zudin
 * @since 16.06.16.
 */
public enum ParamConverter {

    SINGLE_PARAM_CONVERTER(input -> input.length == 1 ? input[0] : (Object) input),
    EMPTY_PARAM_CONVERTER(input -> null);

    private Function<Object[], Object> function;

    ParamConverter(Function<Object[], Object> function) {
        this.function = function;
    }

    public Function<Object[], Object> getFunction() {
        return function;
    }

    public static Function<Object[], Object> createFunction(String... fieldNames) {
        return objects -> {
            Object o = objects[0];
            for (int i = fieldNames.length - 1; i >= 0; i--) {
                o = ImmutableMap.of(fieldNames[i], o);
            }
            return o;
        };
    }
}
