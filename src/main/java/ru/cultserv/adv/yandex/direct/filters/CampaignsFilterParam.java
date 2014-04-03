package ru.cultserv.adv.yandex.direct.filters;

import ru.cultserv.adv.yandex.direct.models.util.ExtendedStatus;
import ru.cultserv.adv.yandex.direct.models.util.StatusBoolean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CampaignsFilterParam {
	
	/**
	 * <p>
	 * Массив, содержащий логины клиентов, для которых требуется получить список кампаний.
	 * Заполняется только рекламными агентствами. Другие пользователи могут не указывать этот параметр.
	 * 
	 * <p>
	 * Требуется
	 * <br>
	 * Да для рекламных агентств
	 */
	@JsonProperty("Logins")
	public String[] logins;
	
	@JsonProperty("Filter")
	public CampaignsFilter filter;
	
	@JsonProperty("Limit")
	public int limit;
	
	@JsonProperty("Offset")
	public int offset;
	
	/**
	 * <p>
	 * Возвращать денежные значения в валюте кампании — Yes/No.
	 * При значении No значения конвертируются из валюты кампании в у. е. Значение по умолчанию — No.
	 * 
	 * <p>
	 * Требуется - нет
	 */
	@JsonProperty("CurrencySupported")
	public StatusBoolean currency_supported = StatusBoolean.No;
	
	/**
	 * Объект, содержащий условия отбора кампаний.
	 * Если не задан, возвращаются сведения о всех кампаниях, как в методе GetCampaignsList (Live).
	 */
	public static class CampaignsFilter {

		/**
		 * <p>
		 * Отбирать кампании по состоянию модерации:
		 * 
		 * <li>Yes — прошедшие модерацию;
		 * <li>No — не прошедшие модерацию;
		 * <li>New — не отправленные на модерацию (статус «Черновик»);
		 * <li>Pending — находящиеся на модерации.
		 */
		@JsonProperty("StatusModerate")
		public ExtendedStatus[] status_moderate;
		
		/**
		 * Отбирать кампании по состоянию активности:
		 * 
		 * <ul>
		 * 	<li>Yes — активные;</li>
		 * 	<li>No — не активные.</li>
		 * </ul>
		 * 
		 * Под активностью понимается состояние кампании, при котором показ объявлений включается
		 * и выключается автоматически — в соответствии с настройками временного таргетинга или в зависимости
		 * от баланса кампании. Неактивность кампании означает, что показ объявлений заблокирован клиентом
		 * или менеджером Яндекса и не может быть включен автоматически.
		 */
		@JsonProperty("IsActive")
		public StatusBoolean[] is_active;
		
		/**
		 * Отбирать кампании по признаку помещения в архив:
		 * 
		 * <ul>
		 * 	<li>Yes — в архиве;</li>
		 * 	<li>No — не в архиве;</li>
		 * 	<li>CurrencyConverted — кампания автоматически заархивирована при переходе клиента на работу в валюте
		 * 	и не может быть разархивирована</li>
		 * </ul>
		 */
		@JsonProperty("StatusArchive")
		public ExtendedStatus[] status_archive;
		
		/**
		 * Отбирать кампании по состоянию активизации:
		 * 
		 * <ul>
		 * 	<li>Yes — активированные;</li>
		 * 	<li>Pending — выполняется активизация.</li>
		 * </ul>
		 */
		@JsonProperty("StatusActivating")
		public ExtendedStatus[] status_activating;
		
		/**
		 * Отбирать кампании по состоянию показа объявлений:
		 * 
		 * <ul>
		 * 	<li>Yes — показ включен;</li>
		 * 	<li>No — показ выключен.</li>
		 * </ul>
		 */
		@JsonProperty("StatusShow")
		public StatusBoolean[] status_show;

	}

	public static class Builder {
		
		private CampaignsFilterParam filter_param;
		
		public Builder() {
			filter_param = new CampaignsFilterParam();
			filter_param.filter = new CampaignsFilter();
		}

		/**
		 * Получать данные по кампаниям для конкретных логинов.
		 * Использовать только для агенств!
		 * 
		 * @param logins список клиентских логинов агенства
		 * @return текущий инстанс билдера
		 */
		public Builder withLogins(String... logins) {
			filter_param.logins = logins;
			return this;
		}
		
		/**
		 * Устанавливает флаг для того, чтобы возвращать данные с денежными значениями в валюте кампании, а не в у.е.
		 * 
		 * @return текущий инстанс билдера
		 */
		public Builder withCampaignCurrency() {
			filter_param.currency_supported = StatusBoolean.Yes;
			return this;
		}
		
		public Builder withRange(int limit, int offset) {
			filter_param.limit = limit;
			filter_param.offset = offset;
			
			return this;
		}
		
		public Builder withLimit(int limit) {
			return withRange(limit, 0);
		}
		
		public Builder withoutArchived() {
			filter_param.filter.status_archive = new ExtendedStatus[] {ExtendedStatus.No};
			return this;
		}
		
		public CampaignsFilterParam build() {
			return filter_param;
		}

	}

}
