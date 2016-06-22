package ru.cultserv.adv.yandex.direct.filters;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.cultserv.adv.yandex.direct.models.campain.CampaignInfo;
import ru.cultserv.adv.yandex.direct.models.util.Page;

import java.util.Arrays;
import java.util.List;

public class CampaignRequest {

	@JsonProperty("SelectionCriteria")
	public SelectionCriteria selectionCriteria = new SelectionCriteria();
	@JsonProperty("FieldNames")
	public List<CampaignFieldName> fieldNames = Arrays.asList(CampaignFieldName.values());
	@JsonProperty("Page")
	public Page page;
	//TODO

	public static class SelectionCriteria {
		@JsonProperty("Ids")
		public List<Long> ids;
		@JsonProperty("Types")
		public List<CampaignInfo.Type> types;
		@JsonProperty("States")
		public List<CampaignInfo.State> states;
		@JsonProperty("Statuses")
		public List<CampaignInfo.ModerationStatus> moderationStatuses;
		@JsonProperty("StatusesPayment")
		public List<CampaignInfo.PaymentStatus> paymentStatuses;
	}

	public enum CampaignFieldName {
		BlockedIps,
		ExcludedSites,
		Currency,
		DailyBudget,
		Notification,
		EndDate,
		Funds,
		ClientInfo,
		Id,
		Name,
		NegativeKeywords,
		RepresentedBy,
		StartDate,
		Statistics,
		State,
		Status,
		StatusPayment,
		StatusClarification,
		SourceId,
		TimeTargeting,
		TimeZone,
		Type
	}

}
