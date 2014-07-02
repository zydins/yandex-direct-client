package ru.cultserv.adv.yandex.direct.methods.impl;

import org.junit.Assert;
import org.junit.Test;
import ru.cultserv.adv.yandex.direct.methods.Utils;
import ru.cultserv.adv.yandex.direct.util.AuthTokens;

/**
 * @author Alexandr Kolosov
 * @since 7/2/14
 */
public class UtilsImplTest {

	private Utils utils = new UtilsImpl(AuthTokens.fake());

	@Test
	public void testPing() throws Exception {
		Assert.assertTrue(utils.ping());
	}
}
