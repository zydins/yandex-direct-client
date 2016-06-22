package ru.cultserv.adv.yandex.direct.models.campain;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.cultserv.adv.yandex.direct.models.util.StatusBoolean;

import java.util.Arrays;
import java.util.List;

/**
 * @author Alexandr Kolosov
 * @since 7/3/14
 */
public class EmailNotificationSettings {

	public static final List<Integer> INTERVALS = Arrays.asList(15, 30, 60);

	@JsonProperty("Email")
	public String email;
	@JsonProperty("CheckPositionInterval")
	public int interval;
	@JsonProperty("WarningBalance")
	public int balancePercent;
	@JsonProperty("SendAccountNews")
	public StatusBoolean accountNews;
	@JsonProperty("SendWarnings")
	public StatusBoolean warnings;

}
