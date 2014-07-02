package ru.cultserv.adv.yandex.direct.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Alexandr Kolosov
 * @since 7/2/14
 */
public class RegionInfo {

	@JsonProperty("RegionID")
	public int region_id;

	@JsonProperty("ParentID")
	public int parent_id;

	@JsonProperty("RegionName")
	public String region_name;

}
