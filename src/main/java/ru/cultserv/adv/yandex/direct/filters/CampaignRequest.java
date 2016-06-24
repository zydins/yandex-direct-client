package ru.cultserv.adv.yandex.direct.filters;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.cultserv.adv.yandex.direct.models.ModerationStatus;
import ru.cultserv.adv.yandex.direct.models.campain.CampaignInfo;
import ru.cultserv.adv.yandex.direct.models.util.Page;

import java.util.Arrays;
import java.util.List;

public class CampaignRequest {

	@JsonProperty("SelectionCriteria")
	public SelectionCriteria selectionCriteria = new SelectionCriteria();
	@JsonProperty("FieldNames")
	public List<CampaignInfo.Field> fieldNames = Arrays.asList(CampaignInfo.Field.values());
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
		public List<ModerationStatus> moderationStatuses;
		@JsonProperty("StatusesPayment")
		public List<CampaignInfo.PaymentStatus> paymentStatuses;
	}

}
