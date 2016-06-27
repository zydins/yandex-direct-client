package ru.cultserv.adv.yandex.direct.v5.methods;

import ru.cultserv.adv.yandex.direct.v5.models.RegionInfo;
import ru.cultserv.adv.yandex.direct.v5.models.RubricInfo;

import java.util.List;

/**
 * @author Alexandr Kolosov
 * @since 7/2/14
 */
public interface Vocabularies {

	@DirectMethod(MethodName.GetRegions)
	List<RegionInfo> getRegions();

	@DirectMethod(MethodName.GetRubrics)
	List<RubricInfo> getRubrics();

}
