package ru.cultserv.adv.yandex.direct.v5.models.util;

/**
 * @author Sergey Zudin
 * @since 09.01.18.
 *
 * https://tech.yandex.ru/direct/doc/reports/spec-docpage/#FilterItem
 */
public enum Operator {

    EQUALS,
    NOT_EQUALS,
    IN,
    NOT_IN,
    LESS_THAN,
    GREATER_THAN,
    STARTS_WITH_IGNORE_CASE,
    DOES_NOT_START_WITH_IGNORE_CASE,
    STARTS_WITH_ANY_IGNORE_CASE,
    DOES_NOT_START_WITH_ALL_IGNORE_CASE

}
