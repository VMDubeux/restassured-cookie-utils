package io.github.VMDubeux.restassured;

import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

public class CookieTest {
    @Test
    public void createCookieMap() {
        CookieManagement cookieManagement = new CookieManagement();
        assertNotNull(cookieManagement);
    }
}
