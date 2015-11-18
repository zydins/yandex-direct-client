package ru.cultserv.adv.yandex.direct.models.campain;

/**
 * @author Sergey Zudin
 * @since 18.11.15.
 */
public enum BannersStatGroupByName {

    /**
     * Дата сбора статистики statDate
     */
    clDate,

    /**
     * Идентификатор фразы, или рубрики Яндекс.Каталога, или ретаргетинга
     */
    clPhrase,

    /**
     * Идентификатор объявления. Значение clBanner не требуется указывать, поскольку оно автоматически добавляется к
     * входным данным, чтобы идентификаторы объявлений всегда выводились в отчет. Значение может использоваться в
     * параметре OrderBy для сортировки строк в отчете
     */
    clBanner,

    /**
     * Тип показа объявления: с изображением или без.
     */
    clImage,

    /**
     * Тип устройства, на котором показано объявление
     */
    clDeviceType,

    /**
     * Средняя позиция показов объявления ShowsAveragePosition и средняя позиция кликов по объявлению СlicksAveragePosition
     */
    clAveragePosition,

    /**
     * Доход Revenue и рентабельность ROI
     */
    clROI

}
