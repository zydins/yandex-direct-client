package ru.cultserv.adv.yandex.direct.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.cultserv.adv.yandex.direct.models.util.StatusBoolean;

public class PhraseInfo {

	/**
	 * Идентификатор фразы.
	 * Для добавления фразы задают 0, для изменения параметров фразы указывают ее идентификатор.
	 */
	@JsonProperty("PhraseID")
	public Long phrase_id;
	
	/**
	 * Ключевая фраза.
	 * 
	 * Может содержать минус-слова, которые указывают со знаком минус перед словом, например [молния -гром -дождь].
	 * Общие для нескольких фраз минус-слова предпочтительно задавать в параметре группы объявлений MinusKeywords.
	 * 
	 * Внимание! Суммарная длина фраз одной группы объявлений не может превышать 4096 символов.
	 * Суммарная длина фраз состоит из суммы длин параметров Phrase во всех фразах группы плюс количество
	 * символов-разделителей между фразами (количество фраз – 1).
	 */
	@JsonProperty("Phrase")
	public String phrase;
	
	/**
	 * Признак того, что фраза является рубрикой Яндекс.Каталога — Yes/No.
	 * Предустановленное значение — No. При значении Yes переданная фраза игнорируется.
	 */
	@JsonProperty("IsRubric")
	public StatusBoolean is_rubric;
	
	/**
	 * Ставка на поиске Яндекса (в валюте, указанной в параметре Currency).
	 * Используется, только если для кампании выбрана стратегия с ручным управлением ставками.
	 * 
	 * Максимальное и минимальное значения представлены в таблице Валютные параметры и ограничения.
	 * Если значение перед сохранением конвертируется из у. е. в валюту кампании, то оно округляется
	 * вверх с точностью до шага торгов в этой валюте (см. раздел Реальные валюты вместо у. е.).
	 * Если после конвертации в валюту кампании значение оказалось меньше минимальной
	 * или больше максимальной ставки в этой валюте, оно устанавливается равным минимальной
	 * или, соответственно, максимальной ставке.
	 */
	@JsonProperty("Price")
	public Float price;
	
	/**
	 * Ставка в Рекламной сети Яндекса (в валюте, указанной в параметре Currency).
	 * 
	 * Параметр доступен для изменения в следующих случаях:
	 * Для Рекламной сети выбрана стратегия MaximumCoverage.
	 * Для Рекламной сети выбрана стратегия Default и фраза отключена на поиске за низкий CTR.
	 * Для новых фраз данное условие не актуально, поскольку фразы больше не отключаются за низкий CTR.
	 * 
	 * Максимальное и минимальное значения представлены в таблице Валютные параметры и ограничения.
	 * Если значение перед сохранением конвертируется из у. е. в валюту кампании, то оно округляется 
	 * вверх с точностью до шага торгов в этой валюте (см. раздел Реальные валюты вместо у. е.).
	 * Если после конвертации в валюту кампании значение оказалось меньше минимальной или больше максимальной
	 * ставки в этой валюте, оно устанавливается равным минимальной или, соответственно, максимальной ставке.
	 * 
	 * Требуется для стратегии MaximumCoverage
	 */
	@JsonProperty("ContextPrice")
	public Float context_price;
	
	/**
	 * Включить автоброкер — Yes/No. Предустановленное значение — Yes.
	 */
	@JsonProperty("AutoBroker")
	public StatusBoolean auto_broker;
	
	/**
	 * Приоритет фразы при использовании автоматических стратегий. Возможные значения:
	 * Low — низкий приоритет;
	 * Medium — средний приоритет;
	 * High — высокий приоритет.
	 * 
	 * Высокий приоритет обеспечивает на 10–15% больше показов по фразе, чем по фразам
	 * со средним приоритетом. Низкий приоритет уменьшает показы на такую же величину.
	 * Если в объявлении только одна фраза, параметр не имеет значения.
	 * 
	 * Требуется для стратегии WeeklyBudget
	 */
	@JsonProperty("AutoBudgetPriority")
	public BudgetPriority auto_budget_priority;
	
	/**
	 * Содержит значения подстановочных переменных для формирования ссылки на сайт.
	 * http://api.yandex.ru/direct/doc/concepts/banner.xml#links
	 */
	@JsonProperty("UserParams")
	public PhraseUserParams user_params;

	/**
	 * Количество кликов по всем объявлениям группы, показанным на поиске по данной фразе.
	 * Рассчитывается за 28 дней от текущей даты. Для расчета отбираются дни,
	 * в течение которых был хотя бы один клик по объявлению.
	 */
	@JsonProperty("Clicks")
	public Integer clicks;

	/**
	 * Количество показов всех объявлений группы по данной фразе на поиске.
	 * Рассчитывается за 28 дней от текущей даты. Для расчета отбираются дни,
	 * в течение которых был хотя бы один показ объявления по данной фразе.
	 */
	@JsonProperty("Shows")
	public Integer shows;

	/**
	 * Валюта, в которой указаны ставки.
	 * Значение должно совпадать с валютой кампании.
	 * 
	 * Если параметр отсутствует или равен NULL, подразумеваются условные единицы (у. е.).
	 * В этом случае, если кампания ведется в реальной валюте, переданные приложением ставки
	 * перед сохранением конвертируются в реальную валюту (см. раздел Реальные валюты вместо у. е.).
	 * 
	 * Если значение отлично от NULL и не совпадает с валютой кампании (одной из кампаний),
	 * возвращается ошибка с кодом 245.
	 */
	@JsonProperty("Currency")
	public Currency currency;
	
	public static class PhraseUserParams {

		/**
		 * Значение подстановочной переменной {param1}. Не более 255 байт.
		 * 
		 * Требуется при использовании подстановочных переменных в Href
		 */
		@JsonProperty("Param1")
		public String param1;
		
		/**
		 * Значение подстановочной переменной {param2}. Не более 255 байт.
		 * 
		 * Требуется при использовании подстановочных переменных в Href
		 */
		@JsonProperty("Param2")
		public String param2;

	}

}