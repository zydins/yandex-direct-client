package ru.cultserv.adv.yandex.direct.v5.models.ads;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.cultserv.adv.yandex.direct.v5.models.ModerationStatus;
import ru.cultserv.adv.yandex.direct.v5.models.util.ArrayOf;

public class AdInfo {

	@JsonProperty("Id")
	public Long id;

	@JsonProperty("CampaignId")
	public Long campaignId;

	@JsonProperty("Status")
	public ModerationStatus moderationStatus;

	@JsonProperty("State")
	public State state;

	@JsonProperty("StatusClarification")
	public String statusClarification;

	@JsonProperty("AdCategories")
	public ArrayOf<Category> categories;

	@JsonProperty("AgeLabel")
	public AgeLabel ageLabel;

	@JsonProperty("Type")
	public Type type;

	/*
	Start fields for creation
	 */

	@JsonProperty("AdGroupID")
	public Long adGroupId;

	@JsonProperty("TextAd")
	public TextAd textAd;

	//TODO

	/*
	End fields for creation
	 */

	/**
	 * https://tech.yandex.ru/direct/doc/dg/objects/ad-docpage/#status
	 */
	public enum State {
		OFF,
		ON,
		SUSPENDED,
		OFF_BY_MONITORING,
		ARCHIVED,
		UNKNOWN
	}

	public enum Category {
		ABORTION,
		ALCOHOL,
		BABY_FOOD,
		DIETARY_SUPPLEMENTS,
		MEDICINE,
		PSEUDO_WEAPON,
		TOBACCO
	}

	public enum Type {
		TEXT_AD,
		MOBILE_APP_AD,
		DYNAMIC_TEXT_AD
	}

	public enum AgeLabel {
		AGE_0,
		AGE_6,
		AGE_12,
		AGE_16,
		AGE_18,
		MONTHS_0,
		MONTHS_1,
		MONTHS_2,
		MONTHS_3,
		MONTHS_4,
		MONTHS_5,
		MONTHS_6,
		MONTHS_7,
		MONTHS_8,
		MONTHS_9,
		MONTHS_10,
		MONTHS_11,
		MONTHS_12
	}

	public enum Field {
		AdCategories,
		AgeLabel,
		AdGroupId,
		CampaignId,
		Id,
		State,
		Status,
		StatusClarification,
		Type
	}
}
