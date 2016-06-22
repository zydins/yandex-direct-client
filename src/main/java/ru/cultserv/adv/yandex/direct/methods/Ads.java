package ru.cultserv.adv.yandex.direct.methods;

import ru.cultserv.adv.yandex.direct.filters.BannersFilterParam;
import ru.cultserv.adv.yandex.direct.filters.PhrasesFilterParam;
import ru.cultserv.adv.yandex.direct.models.PhraseInfo;
import ru.cultserv.adv.yandex.direct.models.banner.BannerInfo;
import ru.cultserv.adv.yandex.direct.models.banner.CampaignBidsInfo;

import java.util.List;

public interface Ads {

	/**
	 * Помещает объявления в архив.
	 * 
	 * Помещать в архив можно объявления, показ которых остановлен.
	 * У объявлений в архиве параметр StatusArchive равен «Yes».
	 */
    @DirectMethod(MethodName.ArchiveBanners)
	void archive(List<Long> banner_ids);
	
	/**
	 * Создает группы объявлений, объявления и фразы.
	 * 
	 * Если кампания активна, добавленные и измененные объявления автоматически отправляются на модерацию.
	 * Для кампаний в статусе «Черновик» отправить объявление на модерацию можно с помощью метода ModerateBanners.
	 * 
	 * При успешном выполнении метод возвращает массив, содержащий идентификаторы созданных баннеров.
	 */
    @DirectMethod(MethodName.CreateOrUpdateBanners)
	List<Long> create(List<BannerInfo> banners);
	
	/**
	 * Обновляет данные объявлений.
	 */
    @DirectMethod(MethodName.CreateOrUpdateBanners)
	List<Long> update(List<BannerInfo> banners);
	
	/**
	 * Удаляет объявления.
	 * 
	 * При удалении объявления удаляются записи о нем в базе данных.
	 * Поэтому получить какую-либо информацию об удаленном объявлении невозможно.
	 * 
	 * Удалить можно только объявление, которое не было в показе и по которому не накоплена статистика.
	 * Для других объявлений доступна архивация с помощью метода ArchiveBanners (Live).
	 */
    @DirectMethod(MethodName.DeleteBanners)
	void delete(List<Long> banner_ids);
	
	/**
	 * Возвращает параметры групп объявлений, объявлений и фраз.
	 * 
	 * Метод возвращает параметры групп, объявлений и фраз.
	 * Параметры фраз возвращаются в сокращенном или в полном виде (см. параметр GetPhrases).
	 */
    @DirectMethod(MethodName.GetBanners)
	List<BannerInfo> get(BannersFilterParam filtering_param);
	
	/**
	 * Возвращает информацию о фразах.
	 * 
	 * @param banner_ids содержит массив идентификаторов объявлений BannerID (не более 1000)
	 */
    @DirectMethod(MethodName.GetBannerPhrases)
	List<PhraseInfo> phrases(List<Long> banner_ids);
	
	/**
	 * Возвращает информацию о фразах и позволяет ограничить состав возвращаемых данных.
	 */
    @DirectMethod(MethodName.GetBannerPhrasesFilter)
	List<PhraseInfo> phrases(PhrasesFilterParam filtering_param);
	
	/**
	 * Отправляет на модерацию объявления в статусе «Черновик».
	 * 
	 * Метод служит для модерации объявлений у вновь созданных кампаний.
	 * Такие кампании и объявления имеют статус «Черновик».
	 *
     * Если заданы идентификаторы объявлений:
	 *      Если у кампании есть хотя бы одно объявление, которое активно или отправлено на модерацию,
	 *      другие создаваемые или редактируемые объявления отправляются на модерацию автоматически.
	 *      В этом случае вызов метода ModerateBanners возвращает сообщение об ошибке с кодом 151.
     *
     * Если задана кампания:
     *      Отправляет на модерацию только объявления в статусе «Черновик» из заданной кампании.
     *      Если такие объявления отсутствуют у кампании, метод возвращает значение 0.
	 */
    @DirectMethod(MethodName.ModerateBanners)
	void moderate(CampaignBidsInfo info);

	/**
	 * Разрешает показ объявлений.
	 * 
	 * Разрешение показа не означает, что объявления фактически показываются.
	 * Для этого необходимо выполнение и других условий: достаточный баланс средств, кампания
	 * и объявление проверены модератором, показ на уровне кампании разрешен (метод ResumeCampaign).
	 * Фактическому показу соответствует значение Yes в параметре IsActive.
	 */
    @DirectMethod(MethodName.ResumeBanners)
	void resume(List<Long> banner_ids);
	
	/**
	 * Останавливает показ объявлений.
	 */
    @DirectMethod(MethodName.StopBanners)
	void stop(List<Long> banner_ids);
	
	/**
	 * Извлекает объявления из архива.
	 * 
	 * У объявлений, извлеченных из архива, параметр StatusArchive имеет значение «No».
	 * Если параметр StatusArchive объявления имеет значение «CurrencyConverted», метод возвращает ошибку с кодом 155.
	 */
    @DirectMethod(MethodName.UnArchiveBanners)
	void unArchive(List<Long> banner_ids);

}
