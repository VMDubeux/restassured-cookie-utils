package io.github.VMDubeux.restassured;

import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

public class CookieMapTest {
    @Test
    public void createCookieMap() {
        CookieMap cookieMap = new CookieMap();

        assertNotNull(cookieMap);
    }
}
