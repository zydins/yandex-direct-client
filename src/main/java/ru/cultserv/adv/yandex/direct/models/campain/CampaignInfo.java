package ru.cultserv.adv.yandex.direct.models.campain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.LocalDate;
import ru.cultserv.adv.yandex.direct.models.Currency;
import ru.cultserv.adv.yandex.direct.models.util.ArrayOfString;


public class CampaignInfo {

	@JsonProperty("Id")
	public long id;

	/*
	Start fields for creation
	 */

	@JsonProperty("Name")
	public String name;

	@JsonProperty("StartDate")
	public LocalDate startDate;

	@JsonProperty("DailyBudget")
	public DailyBudget dailyBidget;

	@JsonProperty("EndDate")
	public LocalDate endDate;

	@JsonProperty("NegativeKeywords")
	public ArrayOfString negativeKeywords;

	@JsonProperty("BlockedIps")
	public ArrayOfString blockedIps;

	@JsonProperty("ExcludedSites")
	public ArrayOfString excludedSites;

	@JsonProperty("TextCampaign")
	public TextCampaignParam textCampaign;

	@JsonProperty("MobileAppCampaign")
	public MobileAppCampaignParam mobileAppCampaign;

	@JsonProperty("DynamicTextCampaign")
	public DynamicTextCampaignParam dynamicTextCampaign;

	@JsonProperty("ClientInfo")
	public String clientInfo;

	@JsonProperty("Notification")
	public Notification notification;

	@JsonProperty("TimeTargeting")
	public TimeTargetingParam timeTargeting;

	@JsonProperty("TimeZone")
	public String timezone;

	/*
	End fields for creation
	 */

	@JsonProperty("Type")
	public Type type;

	@JsonProperty("Status")
	public ModerationStatus moderationStatus;

	@JsonProperty("State")
	public State state;

	@JsonProperty("StatusPayment")
	public PaymentStatus paymentStatus;

	@JsonProperty("StatusClarification")
	public String statusClarification;

	@JsonProperty("SourceId")
	public Long sourceId;

	@JsonProperty("Statistics")
	public Stat statistics;

	@JsonProperty("Currency")
	public Currency currency;

	//TODO
	//Funds
	//RepresentedBy
	//LimitedBy

	public enum Type {
		TEXT_CAMPAIGN,
		MOBILE_APP_CAMPAIGN,
		DYNAMIC_TEXT_CAMPAIGN
	}

	public enum State {
		ARCHIVED,
		CONVERTED,
		ENDED,
		OFF,
		ON,
		SUSPENDED
	}

	public enum ModerationStatus {
		ACCEPTED,
		DRAFT,
		MODERATION,
		REJECTED
	}

	public enum PaymentStatus {
		DISALLOWED,
		ALLOWED
	}

	public static class Stat {
		@JsonProperty("Clicks")
		public long clicks;
		@JsonProperty("Impressions")
		public long shows;
	}

}
