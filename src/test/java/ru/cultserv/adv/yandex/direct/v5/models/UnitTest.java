package ru.cultserv.adv.yandex.direct.v5.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * User: Iggi
 * Date: 17/08/2017
 * Time: 17:36
 */
public class UnitTest {

    @Test
    public void mappingTest() throws IOException {
        final ObjectMapper om = new ObjectMapper();
        final String s = om.writeValueAsString(new Unit("l", 1, 2, 3));
        final Unit u = om.readValue(s, Unit.class);
        Assert.assertEquals("l", u.getLogin());
        Assert.assertEquals(1, u.getCost());
        Assert.assertEquals(2, u.getBalance());
        Assert.assertEquals(3, u.getDailyLimit());
    }
}