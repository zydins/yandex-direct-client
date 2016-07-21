package ru.cultserv.adv.yandex.direct.v5.models.campain;

/**
 * @author Sergey Zudin
 * @since 18.11.15.
 */
@Deprecated
public enum BannersStatOrderByNames {

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
    clImage

}
