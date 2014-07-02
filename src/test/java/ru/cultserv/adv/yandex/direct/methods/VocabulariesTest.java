package ru.cultserv.adv.yandex.direct.methods;

import org.junit.Assert;
import org.junit.Test;
import ru.cultserv.adv.yandex.direct.methods.impl.VocabulariesImpl;
import ru.cultserv.adv.yandex.direct.models.RegionInfo;
import ru.cultserv.adv.yandex.direct.util.AuthTokens;

import java.util.List;

/**
 * @author Alexandr Kolosov
 * @since 7/2/14
 */
public class VocabulariesTest {

	private VocabulariesImpl vocabularies = new VocabulariesImpl(AuthTokens.fake());

	@Test
	public void testGetRegions() {
		List<RegionInfo> regions = vocabularies.getRegions();
		Assert.assertNotNull(regions);
	}
}
