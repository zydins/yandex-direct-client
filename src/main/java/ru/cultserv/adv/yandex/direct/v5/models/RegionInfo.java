package ru.cultserv.adv.yandex.direct.v5.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

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

	@Override
	public String toString() {
		return Objects.toStringHelper(this)
				.add("region_id", region_id)
				.add("parent_id", parent_id)
				.add("region_name", region_name)
				.toString();
	}
}
