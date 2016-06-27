package ru.cultserv.adv.yandex.direct.v5.methods;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;

@Retention(RetentionPolicy.RUNTIME)
@Target(value={METHOD})
public @interface DirectMethod {

	MethodName value();

}
