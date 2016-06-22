package ru.cultserv.adv.yandex.direct.models.campain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Alexandr Kolosov
 * @since 7/3/14
 */
public class DailyBudget {

	@JsonProperty("Amount")
	public long amount;

	@JsonProperty("Mode")
	public BudgetMode mode;

	public enum BudgetMode {
		STANDARD,
		DISTRIBUTED
	}

}
