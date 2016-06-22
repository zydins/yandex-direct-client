package ru.cultserv.adv.yandex.direct.methods;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;

/**
 * @author Sergey Zudin
 * @since 16.06.16.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value={METHOD})
public @interface WithConverter {

    ParamConverter converter() default ParamConverter.EMPTY_PARAM_CONVERTER;
    String entity() default "";

}
