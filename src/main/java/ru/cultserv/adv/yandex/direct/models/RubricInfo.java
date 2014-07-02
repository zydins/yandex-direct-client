package ru.cultserv.adv.yandex.direct.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Alexandr Kolosov
 * @since 7/2/14
 */
public class RubricInfo {

	@JsonProperty("RubricID")
	public int rubric_id;

	@JsonProperty("ParentID")
	public int parent_id;

	@JsonProperty("Url")
	public String url;

	@JsonProperty("RubricFullName")
	public String rubric_full_name;

	@JsonProperty("RubricName")
	public String rubric_name;

	@JsonProperty("Checkable")
	public String checkable;

}
