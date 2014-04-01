package ru.cultserv.adv.yandex.direct.models;

/**
 * Стратегия в Рекламной сети Яндекса. Ниже перечислены возможные значения.
 * 
 * Внимание! Автоматические стратегии в Рекламной сети доступны,
 * только если на поиске выключен показ объявлений (стратегия ShowsDisabled).
 */
public enum CampaignContextStrategyName {

	/**
	 * Выключить показ объявлений в Рекламной сети Яндекса.
	 * Это возможно, только если показ не выключен на поиске.
	 */
	ShowsDisabled,
	
	/**
	 * Стратегия «Процент от цены на поиске». Процент задают в параметре ContextPricePercent.
	 * Дополнительные параметры — ContextLimit и ContextLimitSum.
	 * Данная стратегия применяется для кампаний, которым стратегия не назначена явно.
	 */
	Default,
	
	/**
	 * Стратегия «Максимальный доступный охват».
	 * Ставки задают с помощью одного из методов: CreateOrUpdateBanners, SetAutoPrice (Live), UpdatePrices.
	 * 
	 * Внимание! Стратегия MaximumCoverage не доступна, если на поиске выбрана любая автоматическая стратегия.
	 */
	MaximumCoverage,
	
	/**
	 * Стратегия «Недельный бюджет: максимум кликов» (обязательный параметр WeeklySumLimit, дополнительный MaxPrice)
	 */
	WeeklyBudget,
	
	/**
	 * Стратегия «Недельный бюджет: максимальная конверсия»
	 * (обязательные параметры WeeklySumLimit и GoalID, дополнительный MaxPrice)
	 */
	CPAOptimizer,
	
	/**
	 * Стратегия «Средняя цена клика» (обязательный параметр AveragePrice, дополнительный WeeklySumLimit)
	 */
	AverageClickPrice,
	
	/**
	 * Стратегия «Недельный пакет кликов»
	 * (обязательный параметр ClicksPerWeek, дополнительные MaxPrice или AveragePrice)
	 */
	WeeklyPacketOfClicks,
	
	/**
	 * Стратегия «Средняя цена конверсии»
	 * (обязательные параметры AverageCPA и GoalID, дополнительныеWeeklySumLimit и MaxPrice)
	 */
	AverageCPAOptimization

}
