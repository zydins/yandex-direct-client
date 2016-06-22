package ru.cultserv.adv.yandex.direct.models.campain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.LocalTime;

import java.util.List;

/**
 * @author Alexandr Kolosov
 * @since 7/3/14
 */
public class SmsNotificationSettings {

	@JsonProperty("Events")
	public List<SmsEvent> event;
	@JsonProperty("TimeFrom")
	public LocalTime from;
	@JsonProperty("TimeTo")
	public LocalTime to;

	public enum SmsEvent {
		MONITORING,
		MODERATION,
		MONEY_IN,
		MONEY_OUT,
		FINISHED
	}
}
