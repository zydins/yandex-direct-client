package ru.cultserv.adv.yandex.direct.methods.impl;

import ru.cultserv.adv.yandex.direct.AuthToken;
import ru.cultserv.adv.yandex.direct.methods.MethodName;
import ru.cultserv.adv.yandex.direct.methods.Vocabularies;
import ru.cultserv.adv.yandex.direct.models.RegionInfo;
import ru.cultserv.adv.yandex.direct.models.RubricInfo;
import ru.cultserv.adv.yandex.direct.util.requests.YandexDirectMethodCaller;
import ru.cultserv.adv.yandex.direct.util.requests.YandexRequestExecutor;

import java.util.List;

/**
 * @author Alexandr Kolosov
 * @since 7/2/14
 */
public class VocabulariesImpl implements Vocabularies {

	private final YandexDirectMethodCaller caller;

	public VocabulariesImpl(AuthToken token) {
		this.caller = new YandexDirectMethodCaller(token, new YandexRequestExecutor());
	}

	@Override
	public List<RegionInfo> getRegions() {
		return caller.call(MethodName.GetRegions);
	}

	@Override
	public List<RubricInfo> getRubrics() {
		return caller.call(MethodName.GetRubrics);
	}
}
