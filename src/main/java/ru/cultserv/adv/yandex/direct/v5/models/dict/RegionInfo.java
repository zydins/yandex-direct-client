package ru.cultserv.adv.yandex.direct.v5.models.dict;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

/**
 * @author Alexandr Kolosov
 * @since 7/2/14
 */
public class RegionInfo {

	@JsonProperty("GeoRegionId")
	public int id;

	@JsonProperty("ParentId")
	public Long parentId;

	@JsonProperty("GeoRegionName")
	public String regionName;

	@JsonProperty("GeoRegionType")
	public String regionType;

	@Override
	public String toString() {
		return Objects.toStringHelper(this)
				.add("id", id)
				.add("parentId", parentId)
				.add("regionName", regionName)
				.add("regionType", regionType)
				.toString();
	}
}
